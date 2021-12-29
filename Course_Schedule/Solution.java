package com.company;

import java.util.*;

/**
 There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

 For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 Return true if you can finish all courses. Otherwise, return false.



 Example 1:

 Input: numCourses = 2, prerequisites = [[1,0]]
 Output: true
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0. So it is possible.
 Example 2:

 Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 Output: false
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
class Solution {
    List<Integer>[] prereqList;
    boolean[] canFinishCourses;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        prereqList = new ArrayList[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][1];
            int prereq = prerequisites[i][0];
            List<Integer> prereqSet = prereqList[course];
            if(prereqSet == null) {
                prereqSet = new ArrayList<>();
            }
            prereqSet.add(prereq);
            prereqList[course] = prereqSet;
        }

        canFinishCourses = new boolean[numCourses];
        int[] checkedCourse = new int[numCourses];
        for(int courseIndex = 0; courseIndex < numCourses; courseIndex++) {
            checkedCourse[courseIndex] = 1;
            if(!checkCoursePrereq(courseIndex, checkedCourse)) {
                return  false;
            }
            checkedCourse[courseIndex] = 0;
        }

        return true;
    }

    private boolean checkCoursePrereq(int courseIndex, int[] checkedCourse) {
        if (canFinishCourses[courseIndex]) {
            return true;
        }
        List<Integer> prereqSet = prereqList[courseIndex];
        if(prereqSet == null || prereqSet.isEmpty()) {
            canFinishCourses[courseIndex] = true;
            return true;
        }

        boolean canFinish = true;
        for(int course : prereqSet) {
            if(checkedCourse[course] == 1) {
                canFinish = false;
                break;
            }
            checkedCourse[course] = 1;
            canFinish &= checkCoursePrereq(course, checkedCourse);
            if(!canFinish) {
                break;
            }
            checkedCourse[course] = 0;
        }

        canFinishCourses[courseIndex] = canFinish;
        return canFinish;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int courseNum = 3;
        int[][] prerequisites = {{1, 0}, {2, 0}, {0, 1}};
        System.out.println(s.canFinish(courseNum, prerequisites));
    }
}