/*Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. */
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = 0; 
        int end = A.length - 1; 
        int middle = 0; 
        int[] result = new int[2]; 
        result[0] = -1; 
        result[1] = -1;
        boolean found = false;
        middle = binarySearch(A, target, start, end); 
        if(middle != -1) {
            result[0] = middle;
            result[1] = middle;
            found = true; 
        }
        
        if(found) {
            // find left one 
            int tmp = middle; 
            do{
                tmp = binarySearch(A, target, 0, tmp - 1);  
                if(tmp != -1) {
                    result[0] = tmp; 
                }
            } while(tmp != -1);
            
            // find right one 
            tmp = middle; 
            do{
                tmp = binarySearch(A, target, tmp + 1, A.length - 1); 
                if(tmp != -1) {
                    result[1] = tmp;
                }
            } while(tmp != -1); 
        }
        return result; 
    }
    
    public int binarySearch(int[] A, int target, int start, int end) {
        int middle = 0; 
        while(start <= end){
            middle = (start + end) / 2; 
            if(A[middle] == target) {
                return middle; 
            } else if(A[middle] < target) {
                start = middle + 1; 
            } else if(A[middle] > target) {
                end = middle - 1;
            }
        }; 
        
        return -1;
    }
}