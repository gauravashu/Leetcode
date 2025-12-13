class Solution {
    public int diagonalSum(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int sum = 0;
        for(int rowNo = 0; rowNo < r; rowNo++){
            int primaryDiagonal = mat[rowNo][rowNo];
            //column = (c-rowNo-1)
            int secondaryDiagonal = mat[rowNo][c-rowNo-1];
            sum += primaryDiagonal;
            if(rowNo != (c-rowNo-1))
              sum += secondaryDiagonal;
        }
        return sum;
        
    }
}
