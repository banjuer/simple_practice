package xyz.banjuer.csbase.leetcode.array;

import xyz.banjuer.common.utils.ArrayUtils;

/**
 * 滑动窗口
 */
public class SolutionSlidingWindow {

    /**
     * 76. 最小覆盖子串
     * <p>
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
     */
    public String minWindow(String s, String t) {
        // TODO
        char[] ts = t.toCharArray();
        // t串字符计数: 长度为26 * 2(小写在前大写在后), 索引为字符位置,值为该字符在t串出现次数
        int[] hash = new int[26 * 2];
        for (char c : ts) {
            hash[getIndex(c)] += 1;
        }

        // 滑动窗口左右边界
        int l = 0, r = -1;
        // s中最短字串长度, 下一个左边界跳转位置(找到字串后下一个滑动窗口左边界)
        int minLength = 0, lastL = -1;
        boolean tStart = false;
        // 最小字串左右边界[minL, minR],找到比minLength小后更新
        int minL = -1, minR = -1;
        char[] ss = s.toCharArray();
        while (l < ss.length) {
            if (hash[getIndex(ss[l])] != 0) {
                if (tStart) {
                    r++;
                }
            }
        }
        return "";
    }

    private int getIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else {
            return c - 'A' + 26;
        }
    }

    /**
     * 209 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     */
    public int minSubArrayLen(int s, int[] nums) {
        // [l, r],初始不包含元素故
        int l = 0, r = -1, sum = 0, minLength = nums.length + 1;
        while (l < nums.length) {
            if (sum < s && r + 1 < nums.length) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                minLength = Math.min(minLength, r - l + 1);
            }
        }
        return minLength == nums.length + 1 ? 0 : minLength;
    }

    public static void main(String[] args) {
        SolutionSlidingWindow window = new SolutionSlidingWindow();
        window.minWindow("aaa", "aacC");
        System.out.println('Z' - 'A');
    }

}
