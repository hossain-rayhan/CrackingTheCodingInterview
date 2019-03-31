//LeetCode- 51: N Queens
//Cracking the Coding Interview: Chapter 8

//basic concept from CTCI- Chapter 8
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[] boardRow = new char[n];
        Arrays.fill(boardRow, '.');
        
        List<List<String>> result = new ArrayList<>();
        int[] colIndex = new int[n]; //index of queens in each row
        Arrays.fill(colIndex, -1);
        //start from row zero, and run dfs recursively
        dfs(colIndex, 0, result, boardRow);
        
        return result;
    }
    
    public void dfs(int[] colIndex, int row, List<List<String>> result, char[] boardRow){
        if(row == colIndex.length){
            //queens placed on all the rows perfectly
            //convert the board into result format
            result.add(getResult(colIndex, boardRow)); 
            return;
        }
        //otherwise check the every column and find the correct position for this row
        for(int col = 0; col < colIndex.length; col++){
            if(isValid(colIndex, row, col)){
                colIndex[row] = col; //choose
                dfs(colIndex, row + 1, result, boardRow); // explore
                colIndex[row] = -1; //undo - 3 main rules of backtracking
            }
        }
    }
    
    public boolean isValid(int[] colIndex, int row, int col){
        //we don't need to check the rows, as our code working only once in a row
        //cheeck if there is already a Queen in the same column, or same diagonal position
        for(int r = 0; r < row; r++){ // check only the previous rows, because we haven't explored the later ones
            int c = colIndex[r]; //if -1, No queen. else there is a queen at index c
            if(c == col){
                return false; // already a quuen in the same column
            }    
            
            //check diagonals. If row distance and column distance are equal, then conflict
            int colDistance = Math.abs(c - col);
            int rowDistance = row - r; //row is always greater, no need to do the abs
            if(rowDistance == colDistance){
                return false;
            }
        }
        return true;
    }
    
    public List<String> getResult(int[] colIndex, char[] boardRow){
        List<String> board = new ArrayList<>();

        for(int row = 0; row < colIndex.length; row++){
            boardRow[colIndex[row]] = 'Q';
            board.add(String.copyValueOf(boardRow));
            boardRow[colIndex[row]] = '.';
        }
        return board;
    }
}
