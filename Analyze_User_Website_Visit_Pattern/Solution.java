package com.company;

import java.util.*;

/**
 * We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].
 *
 * A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)
 *
 * Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"]
 * Explanation:
 * The tuples in this example are:
 * ["joe", 1, "home"]
 * ["joe", 2, "about"]
 * ["joe", 3, "career"]
 * ["james", 4, "home"]
 * ["james", 5, "cart"]
 * ["james", 6, "maps"]
 * ["james", 7, "home"]
 * ["mary", 8, "home"]
 * ["mary", 9, "about"]
 * ["mary", 10, "career"]
 * The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 */
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<AbstractMap.SimpleEntry<Integer,String>>> userWebsiteMap = new HashMap<>();
        for(int i = 0; i < username.length; i++) {
            List<AbstractMap.SimpleEntry<Integer,String>> visitList = userWebsiteMap.get(username[i]);
            if (visitList == null) {
                visitList = new ArrayList<>();
            }
            visitList.add(new AbstractMap.SimpleEntry(timestamp[i], website[i]));
            userWebsiteMap.put(username[i], visitList);
        }

        Map<String, Integer> threeSeqMap = new HashMap<>();
        for(List<AbstractMap.SimpleEntry<Integer,String>> v : userWebsiteMap.values()) {
            Collections.sort(v, (a, b) -> {
                return a.getKey().compareTo(b.getKey());
            });
            Set<String> visitedString = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < v.size(); i++) {
                sb.append(v.get(i).getValue());
                sb.append(" ");
                for(int j = i + 1; j < v.size(); j++) {
                    sb.append(v.get(j).getValue());
                    sb.append(" ");
                    for(int k = j + 1; k < v.size(); k++) {
                        sb.append(v.get(k).getValue());
                        String s = sb.toString();
                        if (visitedString.contains(s)) {
                            sb.delete(sb.length() - v.get(k).getValue().length(), sb.length());
                            continue;
                        } else {
                            visitedString.add(s);
                        }
                        Integer count = threeSeqMap.get(s);
                        if (count == null) {
                            count = 1;
                        } else {
                            count++;
                        }
                        threeSeqMap.put(s, count);
                        sb.delete(sb.length() - v.get(k).getValue().length(), sb.length());
                    }
                    sb.delete(sb.length() - v.get(j).getValue().length() - 1, sb.length());
                }
                sb.delete(sb.length() - v.get(i).getValue().length() - 1, sb.length());
            }
        }

        String result = null;
        int maxCount = -1;

        for(Map.Entry<String, Integer> entry : threeSeqMap.entrySet()) {
            if (maxCount < entry.getValue()) {
                maxCount = entry.getValue();
                result = entry.getKey();
            } else if (maxCount == entry.getValue()) {
                if (result == null) {
                    result = entry.getKey();
                } else {
                    result = result.compareTo(entry.getKey()) > 0 ? entry.getKey() : result;
                }
            }
        }

        return Arrays.asList(result.split(" "));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] username = {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
        int[] time = {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};
        String[] website = {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};
        System.out.println(s.mostVisitedPattern(username, time, website));
    }
}