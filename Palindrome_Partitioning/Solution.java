/* Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>(); 
        List<String> mylist = new ArrayList<String>(); 
        int len = s.length(); 
        if(len ==0) {
            return result; 
        }
        findPartition(s, 0, len, mylist, result); 
        return result;
    }
    
    public void findPartition(String s, int start, int end, List<String> mylist, List<List<String>> result){
        if(start == end) {
            List<String> r = new ArrayList<String>(mylist); 
            result.add(r); 
            return;
        }
        
        int i = 1;
        while(start + i <= end) {
            String sub = s.substring(start, start + i); 
            if(isPalidrome(sub)) {
                mylist.add(sub); 
                findPartition(s, start + i, end, mylist, result); 
                mylist.remove(mylist.size() - 1); 
            }
            i++; 
        }
        
    }
    
    public boolean isPalidrome(String s) {
        int len = s.length(); 
        if(len <= 1) {
            return true; 
        }
        int start = 0; 
        int end = len - 1; 
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true; 
    }
}