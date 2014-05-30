/* You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter). */

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        int start = 0; 
        int end = 0; 
        int sLen = S.length(); 
        int listSize = L.length; 
        if(listSize == 0) {
            return result; 
        }
        int step = L[0].length(); 
        if (step == 0) {
            return result; 
        }
        HashMap<String, Integer> listMap = new HashMap<String, Integer>(); 
        // build hash table 
        int i = 0; 
        for(i = 0; i < listSize; i++) {
            if(listMap.containsKey(L[i])) {
                listMap.put(L[i], listMap.get(L[i]) + 1); 
            } else {
                listMap.put(L[i], 1); 
            }
        }
        
        HashMap<String, Integer> map2 = (HashMap<String, Integer>)listMap.clone(); 
        for(start = 0, end = 0; start + step * listSize - 1 < sLen;) {
            String tmp = S.substring(end, end + step); 
            if(map2.containsKey(tmp)) {
                int k = map2.get(tmp) - 1; 
                if(k == 0) {
                    map2.remove(tmp);
                    if(map2.isEmpty()) {
                        result.add(start); 
                        map2 = (HashMap<String, Integer>)listMap.clone();
                        start++; 
                        end = start; 
                    } else {
                        end += step; 
                    }
                } else {
                    map2.put(tmp, k); 
                    end += step; 
                }
            } else {
                map2 = (HashMap<String, Integer>)listMap.clone(); 
                start++; 
                end = start; 
            }
        }
        
        return result; 
    }
}