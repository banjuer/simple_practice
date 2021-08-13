package xyz.banjuer.csbase.offer;

/**
 * 剑指 Offer 05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Offer05 {

    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
