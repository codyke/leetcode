/*Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        int i = 0;
        int j = 0;
        int num = 0;
        ArrayList<ArrayList<Integer>> PTriangle = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0) {
            return PTriangle;
        }
        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        PTriangle.add(firstRow);
        for(j = 1; j < numRows; j++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(i = 0; i < j + 1; i++) {
                num = 0;
                if (i - 1 >= 0) {
                    num += PTriangle.get(j -1).get(i - 1);
                } 
                if (i <= j - 1) {
                    num += PTriangle.get(j - 1).get(i);
                }
                row.add(num);
            }
            PTriangle.add(row);
        }
        return PTriangle;
    }
}
