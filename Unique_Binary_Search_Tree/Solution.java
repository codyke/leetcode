/*Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
public class Solution {
    public int numTrees(int n) {
        int[] result = new int[n + 1]; 
        int i = 0; 
        result[0] = 1; 
        result[1] = 1;
        int k = 0; 
        for(i = 2; i < n + 1; ++i) {
            for(k = 1; k <= i; ++k) {
                result[i] += result[k - 1] * result[i - k]; 
            }
        }
        
        return result[n]; 
    }
}