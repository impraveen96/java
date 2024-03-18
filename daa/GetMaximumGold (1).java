/*
The Kolar Gold Fields (KGF) is in the form of a m*n grid,
Each field, contains some amount of Gold in it.
 
You can mine the gold in the KGF in the following way.
	- You can start at any position in the grid, never visit a cell with no gold.
	- each time you visit a cell, you will grab all the gold in it.
	- You can move one step to the left, right, up or down.
	- You can't visit the same cell more than once.
	- You can stop at any cell.
	
Your task is to find the maximum amount of gold you can collect.

Input Format:
-------------
Line-1: Two integers M and N size of the KGF grid.
Next M lines: N space separated integers, gold in each row of the grid.

Output Format:
--------------
Print an integer, maximum amount of gold.


Sample Input-1:
---------------
3 3
0 6 0
5 8 7
0 9 0

Sample Output-1:
----------------
24

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 9 -> 8 -> 7.

Sample Input-2:
---------------
5 3
1 0 7
2 0 6
3 4 5
0 3 0
9 0 20

Sample Output-2:
----------------
28

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7


=== testcases ===
case =1
input =3 3
4 6 0
5 8 7
0 9 0
output =24

case =2
input =5 3
1 0 7
2 0 6
3 4 5
0 3 0
9 0 20
output =28

case =3
input =5 6
5 3 5 5 6 7
6 3 7 8 7 0
9 0 1 8 0 2
9 9 0 8 0 3
7 2 6 0 2 4
output =107

case =4
input =7 7
1 8 5 6 8 0 7
0 7 3 2 7 5 0
8 0 1 0 3 7 2
2 3 0 0 2 3 8
2 0 3 5 0 2 5
0 7 6 0 0 5 8
0 2 0 8 3 6 7
output =118

case =5
input =8 5
6 7 2 6 0
6 3 6 4 3
9 0 7 3 6
9 0 8 3 1
1 0 4 5 8
0 8 0 3 3
8 4 9 4 9
3 0 2 0 6
output =147

case =6
input =6 5
5 2 9 9 0
3 6 3 2 5
6 5 2 8 5
5 4 3 0 5
5 9 6 6 9
6 3 1 1 6
output =138

*/

import java.util.*;

class GetMaximumGold {
    public int getMaximumGold(int[][] grid, int nrows, int mcols) {
        int maxGold = 0;
        for (int row = 0; row < nrows; row++) {
            for (int col = 0; col < mcols; col++) {
                maxGold = Math.max(maxGold, getMaximumGoldBacktrack(grid, row, col, 0));
            }
        }
        return maxGold;
    }
    
    private int getMaximumGoldBacktrack(int[][] grid, int row, int col, int curGold) 
	{
        if (row < 0 || row >= grid.length || 
			col < 0 || col >= grid[0].length || 
			grid[row][col] == 0)
		{
            return curGold;
		}

        curGold += grid[row][col];
		System.out.println("row " + row + " col " + col + " maxgold " + curGold);
        int temp = grid[row][col];
        int maxGold = curGold;
        
        grid[row][col] = 0;

        maxGold = Math.max(maxGold, getMaximumGoldBacktrack(grid, row + 1, col, curGold)); // next row
        maxGold = Math.max(maxGold, getMaximumGoldBacktrack(grid, row, col + 1, curGold));	// next column
        maxGold = Math.max(maxGold, getMaximumGoldBacktrack(grid, row-1, col, curGold));	// previous row
        maxGold = Math.max(maxGold, getMaximumGoldBacktrack(grid, row, col-1, curGold));	// previous column

        grid[row][col] = temp;
        
        return maxGold;
    }  
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int grid[][]=new int[rows][cols];
		for(int i = 0;i < rows; i++)
			for(int j = 0; j < cols; j++)
				grid[i][j] = sc.nextInt();

		System.out.println(new GetMaximumGold().getMaximumGold(grid, rows, cols));
	}
}