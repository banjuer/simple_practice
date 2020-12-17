package xyz.banjuer.csbase.leetcode.array;

import java.util.Arrays;

/**
 * 双索引:
 * 在双索引技术下，计算成本更优秀(时间复杂度)
 */
public class SolutionTwoPointers {

    /**
     * 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器。
     */
    public int maxArea(int[] height) {
        // 1. 暴力O(n^2)
        // int maxArea = 0;
        // for (int i = 0; i < height.length; i++) {
        //     for (int j = i + 1; j < height.length; j++) {
        //         maxArea = Math.max(maxArea, area(height, i, j));
        //     }
        // }
        // return maxArea;

        // 2. 双指针 指针向内移动，每次都是1，故宽度是向着减少的方向进行，如果想要取得最大面积，指针需要向着更高的方向移动，另一保持不动
        int l = 0, r = height.length - 1;
        int maxArea = area(height, l, r);
        // 形成面积至少两个点
        while (l < r) {
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
            maxArea = Math.max(maxArea, area(height, l, r));
        }
        return maxArea;
    }

    /**
     * l, r 索引位组成的面积
     */
    int area(int[] height, int l, int r) {
        int min = Math.min(height[l], height[r]);
        return min * (r - l);
    }

    /**
     * 345. 反转字符串中的元音字母
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     * 元音字母不包含字母 "y" 。
     */
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        if (cs.length == 0) return s;
        int l = 0, r = cs.length - 1;
        for (; l <= r; l++, r--) {
            while (!isVowel(cs[l])) {
                l ++;
                if (l > r) return new String(cs);
            }
            while (!isVowel(cs[r])) {
                r--;
                if (r < l) return new String(cs);
            }
            char t = cs[l];
            cs[l] = cs[r];
            cs[r] = t;
        }
        return new String(cs);
    }

    boolean isVowel(char c) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (char vowel : vowels) {
            if (c == vowel || c == vowel + ('A' - 'a')) return true;
        }
        return false;
    }

    /**
     * 344. 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     */
    public void reverseString(char[] s) {
        if (s.length <= 0) return;
        int l = 0, r = s.length - 1, mid = r / 2;
        for (; l <= mid; l++, r--) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
        }
    }

    /**
     * 167. 两数之和 II - 输入有序数组
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{++l, ++r};
            if (sum > target)
                r--;
            else
                l++;
        }
        return new int[]{-1, -1};
    }

    /**
     * 125. 验证回文串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (!isEffective(chars[l])) {
                l++;
                if(l > r) return true;
            }
            while (!isEffective(chars[r])) {
                r--;
                if (l > r) return true;
            }
            char left = toUpper(chars[l]), right = toUpper(chars[r]);
            if (left != right) return false;
            l++;
            r--;
        }
        return true;
    }

    boolean isEffective(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    char toUpper(char c) {
        if (c >= 'a' && c <= 'z')
            return (char) (c - 'a' + 'A');
        return c;
    }

    public static void main(String[] args) {
        SolutionTwoPointers solution = new SolutionTwoPointers();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(height));
    }

}
