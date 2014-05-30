/*Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 */

import java.util.*;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] sortNumbers = Arrays.copyOf(numbers, numbers.length);
        
        Arrays.sort(sortNumbers); 
        
        int i = 0; 
        int numA = 0; 
        int numB = 0; 
        int found = 0;
        for(i = 0; i < sortNumbers.length; i++) {
           found = binaryFound(sortNumbers, target - sortNumbers[i]); 
           if (found == 1) {
               break; 
           }
        }
        
        int[] result = new int[2]; 
        result[0] = result[1] = -1;
        int j = 0;
        for(j = 0; j < numbers.length && found == 1; j++){
            if (numbers[j] == sortNumbers[i] && result[0] == -1) {
                result[0] = j + 1;
            } else if (numbers[j] == (target - sortNumbers[i]) && result[1] == -1){
                result[1] = j + 1;
            }
        }
        
        int tmp = result[0]; 
        if (result[1] < result[0]) {
            result[0] = result[1]; 
            result[1] = tmp;
        }
        
        return result; 
    }
    
    public int binaryFound(int[] array, int num) {
        int first = 0;
        int last = array.length - 1; 
        int middle = (first + last) / 2; 
        while (first <= last) 
        {
            if (array[middle] == num) {
                return 1; 
            } else if (array[middle] < num) {
                first = middle + 1; 
            } else {
                last = middle - 1;
            }
            middle = (first + last) / 2; 
        }
        return 0;
    }
}