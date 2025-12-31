import java.util.*;


class Solution {

    
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public int latestDayToCross(int row, int col, int[][] cells) {

       

       

        int left = col - 1;        
        int right = cells.length; 

        while (left < right) {
          
            int mid = right - (right - left) / 2;

            if (walkPossible(row, col, cells, mid)) {
                left = mid;       
            } else {
                right = mid - 1;   
            }
        }

        return left;
    }

    boolean walkPossible(int rows, int cols, int[][] cells, int day) {

        
        int[][] grid = new int[rows][cols];

      
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }

     
        Queue<int[]> q = new LinkedList<>();

       
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 0) {
                q.offer(new int[]{0, j});
                grid[0][j] = -1; 
            }
        }


        while (!q.isEmpty()) {
            int[] cell = q.poll();

            if (cell[0] == rows - 1) {
                return true;
            }

            for (int[] dir : dirs) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];

                if (newRow >= 0 && newCol >= 0 &&
                    newRow < rows && newCol < cols &&
                    grid[newRow][newCol] == 0) {

                    grid[newRow][newCol] = -1; 
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }

        return false; 
    }
}
