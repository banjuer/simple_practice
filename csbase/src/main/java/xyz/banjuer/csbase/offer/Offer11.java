package xyz.banjuer.csbase.offer;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer11 {

    public int minArray(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public int minArray2(int[] numbers) {
        // 使用二分查找[low,height]
        int low = 0, height = numbers.length - 1;
        while (low <= height) {
            int pivot = (height - low) / 2 + low;
            if (numbers[pivot] > numbers[height]) {
                low = pivot + 1;
            } else if (numbers[pivot] < numbers[height]) {
                height = pivot - 1;
            } else {
                height--;
            }
        }
        return numbers[low];
    }

}
