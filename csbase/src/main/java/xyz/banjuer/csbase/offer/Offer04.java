package xyz.banjuer.csbase.offer;

/**
 * 剑指 Offer 04. 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer04 {

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        for (int[] a : matrix) {
            for (int anInt : a) {
                if (target == anInt) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        // 右上角视图类似搜索树，等于当前值查到，小于则向左，大于向下
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int columnIndex = columns -  1, rowIndex = 0;
        while (columnIndex >= 0 && rowIndex < rows) {
            int e = matrix[rowIndex][columnIndex];
            // 目标值大于元素，向下找
            if (target > e) {
                rowIndex++;
            // 目标值小于元素，向左找
            } else if (target < e) {
                columnIndex--;
            } else {
                return true;
            }
        }
        return false;
    }

}
