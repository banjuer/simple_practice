-- 1. 计算每个用户停留总时长 tag: 快手
-- 表view_log: user_id,page_id,view_time
-- 思路: lag:上一条,lead: 下一条
with
user_view as (
    select
        user_id,page_id
         ,view_time as start_time
        -- 按用户时间排序，下一条页面时间即为当前页面结束
         ,lead(view_time) over (partition by user_id order by view_time) as end_time
    from view_log
)
select user_id,page_id,sum(unix_timestamp(end_time - start_time)) as view_seconds
from user_view
group by user_id,page_id order by view_seconds;


-- 2. 计算用户最大连续登录天数 tag: 度小满
-- 表login: user_id,login_date
-- 思路: 按用户登录日期排序。核心内容: 连续天数-排序号应为同一天
with
-- 用户所有登录的日期排序号
login_rank as (
    select
        user_id,login_date
         ,rank() over(partition by user_id order by login_date) rank_num
    from login_date
),
-- 聚合用户同一开始登录日期(日期-排序号)的次数
login_times as (
    select user_id, start_date, count(*) login_times from(
          select
              user_id,login_date,date_sub(login_date, rank_num) start_date
          from login_rank
    ) t
    group by user_id, start_date
)
-- 同一日期的最大连续登录天数
select user_id,max(login_times) as max_login_times
from login_times
group by user_id


