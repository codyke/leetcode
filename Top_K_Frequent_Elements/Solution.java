package com.company;

import java.util.*;

/* Given a non-empty array of integers, return the k most frequent elements.

        Example 1:

        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
        Example 2:

        Input: nums = [1], k = 1
        Output: [1]
*/

public class Solution {
    public int[] topKFrequentTreeMap(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i : nums) {
            Integer count = null;
            if (numCount.containsKey(i)) {
                count = numCount.get(i);
            } else {
                count = 0;
            }
            count++;
            numCount.put(i, count);
        }

        TreeMap<Integer, List<Integer>> sortedCountMap = new TreeMap<>();
        // build the map
        for(Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            List<Integer> resultList = null;
            if (sortedCountMap.containsKey(entry.getValue())) {
                resultList = sortedCountMap.get(entry.getValue());
            } else {
                resultList = new ArrayList<>();
            }
            resultList.add(entry.getKey());
            sortedCountMap.put(entry.getValue(), resultList);
        }

        int[] result = new int[k];
        int idx = 0;
        while (idx < k) {
            Map.Entry<Integer, List<Integer>> lastEntry = sortedCountMap.pollLastEntry();
            for(Integer i : lastEntry.getValue()) {
                result[idx++] = i;
                if (idx >= k) {
                    break;
                }
            }
        }
        return result;
    }
    public int[] topKFrequent(int[] nums, int k) {
        List<Map.Entry<Integer, Integer>> countList = new ArrayList<>();
        Arrays.sort(nums);
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(nums[i - 1], count);
                countList.add(entry);
                count = 1;
            }
        }
        countList.add(new AbstractMap.SimpleEntry<>(nums[nums.length - 1], count));

        Collections.sort(countList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = countList.get(i).getKey();
        }
        return result;
    }
}
