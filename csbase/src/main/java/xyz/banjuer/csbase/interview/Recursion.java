package xyz.banjuer.csbase.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Recursion {

    /**
     * Tag: 美团
     *
     * User共有4层，1-4:总监，经理，组长，开发
     * 返回每个用户id下的所有开发者
     * 每个用户下的所有开发者
     */
    public static Map<User, List<User>> collectDev(List<User> users){
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if(user.level == 1) {
                findDevs(user, users);
            }
        }
        return cache;
    }

    // 缓存每一个用户下的
    private static Map<User, List<User>> cache = new HashMap<>();

    private static List<User> findDevs(User leader, List<User> users) {
        List<User> cacheUsers = cache.get(leader);
        if (cacheUsers != null) {
            return cacheUsers;
        }
        List<User> devs = new ArrayList<>();
        String userId = leader.userId;
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (userId.equals(user.leaderId)) {
                devs.add(user);
            } else {
                List<User> devs1 = findDevs(user, users);
                devs.addAll(devs1);
            }
        }
        cache.put(leader, devs);
        return devs;
    }

    static class User{
        int level;
        String userId;
        String leaderId;

        public User(int level, String userId, String leaderId) {
            this.level = level;
            this.userId = userId;
            this.leaderId = leaderId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return level == user.level && Objects.equals(userId, user.userId) &&
                    Objects.equals(leaderId, user.leaderId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(level, userId, leaderId);
        }
    }

}
