/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.*/

public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>(); 
        int num = strs.length; 
        if(num < 2) {
            return result; 
        }
        
        String[][] cpy = new String[num][2]; 
        
        for(int i = 0; i < num; i++) {
            
            char[] c = strs[i].toCharArray(); 
            Arrays.sort(c); 
            cpy[i][0] = String.valueOf(c); 
            cpy[i][1] = strs[i];
        }
        Arrays.sort(cpy, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
        
        int cur = 0; 
        int next = 1; 
        int first = 0; 
        while(cur < num && next < num) {
            if(cpy[cur][0].equals(cpy[next][0])) {
                if (first == 0) {
                    result.add(cpy[cur][1]); 
                    first = 1; 
                }
                result.add(cpy[next][1]); 
                next++; 
            } else {
                first = 0; 
                cur = next; 
                next++; 
            }
        }
        return result; 
    }
    
}