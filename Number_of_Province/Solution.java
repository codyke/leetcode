package com.company;

import java.util.*;

/**
 There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

 A province is a group of directly or indirectly connected cities and no other cities outside of the group.

 You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

 Return the total number of provinces.



 Example 1:


 Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 Output: 2
 Example 2:


 Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 Output: 3
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        return dfs(isConnected);
    }

    public int dfs(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int numOfProv = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(visited[i] == 0) {
                numOfProv++;
                dfsHelper(i, isConnected, visited);
            }
        }
        return numOfProv;
    }

    public void dfsHelper(int cur, int[][] isConnected, int[] visited) {
        if(visited[cur] == 1) {
            return;
        }
        visited[cur] = 1;
        for(int j = 0; j < isConnected[cur].length; j++) {
            if (isConnected[cur][j] == 1) {
                dfsHelper(j, isConnected, visited);
            }
        }
    }

    public int bfs(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        Stack<Integer> stack = new Stack<>();

        int numOfProv = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(visited[i] == 1) {
                continue;
            }
            stack.push(i);
            numOfProv++;

            while(!stack.isEmpty()) {
                int cur = stack.pop();
                if(visited[cur] == 0) {
                    for(int j = 0; j < isConnected[cur].length; j++) {
                        if (isConnected[cur][j] == 1) {
                            stack.push(j);
                        }
                    }
                    visited[cur] = 1;
                }
            }
        }
        return numOfProv;
    }
}