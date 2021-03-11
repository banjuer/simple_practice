package xyz.banjuer.csbase.leetcode;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 查找表
 */
public class SolutionSearchTable {


    /**
     * 451 根据字符出现频率排序
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     */
    public String frequencySort(String s) {
        char[] sc = s.toCharArray();
        // 计数
        Map<Character, Integer> scMap = new HashMap<>();
        for (char c : sc) {
            scMap.merge(c, 1, Integer::sum);
        }
        class Node {
            Node(int cnt, char c) {
                this.c = c;
                this.cnt = cnt;
            }

            int cnt;
            char c;
        }
        // 入队
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o2.cnt - o1.cnt);
        scMap.forEach((k, v) -> q.offer(new Node(v, k)));
        StringBuilder sb = new StringBuilder(sc.length);
        // 出队
        while (!q.isEmpty()) {
            Node node = q.remove();
            for (int i = 0; i < node.cnt; i++) {
                sb.append(node.c);
            }
        }
        return sb.toString();
    }

    /**
     * 205 同构字符串
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     */
    public boolean isIsomorphic(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        // 遍历s,s每个char在tc中表现
        Map<Character, Character> scMap = new HashMap<>();
        for (int i = 0; i < sc.length; i++) {
            Character scValue = scMap.get(sc[i]);
            if (scValue == null) scMap.put(sc[i], tc[i]);
            else {
                if (scValue != tc[i]) {
                    return false;
                }
            }
        }
        // 两个字符不能映射同一个字符, value值不能相同
        if (scMap.values().size() != new HashSet<>(scMap.values()).size()) {
            return false;
        }
        return true;
    }

    /**
     * 290 单词规律
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     */
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (ss.length != chars.length) return false;
        Map<Character, String> patternMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            String s1 = patternMap.get(chars[i]);
            if (s1 == null) patternMap.put(chars[i], ss[i]);
            else if (!s1.equals(ss[i])) return false;
        }
        Collection<String> values = patternMap.values();
        if (values.size() != new HashSet<>(values).size()) return false;
        return true;
    }

    Set<Integer> duplicate = new HashSet<>();

    /**
     * 202 快乐数
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     */
    public boolean isHappy(int n) {
        if (duplicate.contains(n)) return false;
        duplicate.add(n);
        String s = String.valueOf(n);
        char[] cs = s.toCharArray();
        int res = 0;
        for (char c : cs) {
            Integer si = Integer.valueOf(String.valueOf(c));
            res += (si * si);
        }
        if (res == 1) return true;
        else return isHappy(res);
    }

    /**
     * 242 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     */
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        int[] stable = new int['z' - 'a' + 1];
        for (char c : ss) {
            stable[c - 'a'] += 1;
        }
        char[] ts = t.toCharArray();
        for (char c : ts) {
            if (stable[c - 'a'] == 0) {
                return false;
            } else {
                stable[c - 'a'] -= 1;
            }
        }
        for (char c : ss) {
            if (stable[c - 'a'] != 0) return false;
        }
        return true;
    }

    /**
     * 349 两个数组的交集
     * 给定两个数组，编写一个函数来计算它们的交集。
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(Math.max((int) (nums1.length / .75f) + 1, 16));
        for (int j : nums1) {
            set1.add(j);
        }
        Set<Integer> common = new HashSet<>(Math.max((int) (nums2.length / .75f) + 1, 16));
        for (int j : nums2) {
            if (set1.contains(j)) common.add(j);
        }
        int[] res = new int[common.size()];
        Iterator<Integer> iterator = common.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }

    /**
     * 350 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>(mapSize(nums1));
        Map<Integer, Integer> common = new HashMap<>(mapSize(nums2));
        for (int k : nums1) {
            putWithInc(map1, k);
        }
        for (int j : nums2) {
            Integer k2 = map1.get(j);
            if (k2 != null) {
                putWithInc(common, j);
            }
        }
        int sz = 0;
        for (Map.Entry<Integer, Integer> e : common.entrySet()) {
            Integer key = e.getKey();
            Integer value = e.getValue();
            Integer integer = map1.get(key);
            if (integer < value) {
                sz += integer;
                common.put(key, integer);
            } else {
                sz += value;
            }
        }
        int[] res = new int[sz];
        Iterator<Map.Entry<Integer, Integer>> iterator = common.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            for (int j = 0; j < value; j++) {
                res[i++] = key;
            }
        }
        return res;
    }

    private void putWithInc(Map<Integer, Integer> map, Integer k) {
        Integer cnt = map.get(k);
        if (cnt == null) {
            cnt = 1;
        } else {
            cnt += 1;
        }
        map.put(k, cnt);
    }

    int mapSize(int[] arr) {
        return Math.max((int) (arr.length / .75) + 1, 16);
    }


    public static void main(String[] args) {
        SolutionSearchTable solution = new SolutionSearchTable();
        String tree = solution.frequencySort("Aabb");
        System.out.println(tree);
    }

}
