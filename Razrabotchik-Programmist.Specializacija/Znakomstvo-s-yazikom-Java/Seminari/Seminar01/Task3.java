/*Задание №3
Дан массив nums = [3,2,2,3] и число val = 3.
Если в массиве есть числа, равные заданному, нужно перенести
эти элементы в конец массива.
Таким образом, первые несколько (или все) элементов массива
должны быть отличны от заданного, а остальные - равны ему. */

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int val = 3;
        int[] nums = {3, 2, 2, 3};
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            while (nums[right] == val && left < right){
                right--;
            }

            if (nums[left] == val){
                nums[left] = nums[right];
                nums[right] = val;
            }
            left++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
