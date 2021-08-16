package xyz.banjuer.csbase.offer;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class Offer50 {

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        // 开辟两个字母数字，一个记录出现次数，一个记录当前字符第一次出现的索引位
        int[] indexes = new int[26];
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            // 次数统计
            counts[index] = counts[index] + 1;
            // 记录出现的索引位
            if (indexes[index] == 0) {
                indexes[index] = i;
            }
        }
        long lastIndex = Long.MAX_VALUE;
        for (int i = 0; i < counts.length; i++) {
            // 只出现一次,去索引表查找当前索引位
            if (counts[i] == 1) {
                if (indexes[i] < lastIndex) {
                    lastIndex = indexes[i];
                }
            }
        }
        if (lastIndex != Long.MAX_VALUE) {
            return chars[(int)lastIndex];
        }
        return ' ';
    }

    public static void main(String[] args) {
        int[] ints = new int[26];
        for (int i : ints) {
            System.out.println(i);
        }
    }

}
