package com.devjk;

/*

    Solution_36 : Valid Sudoku

 */

public class Solution_36 {

    private boolean visited[] = new boolean[10];

    public boolean isValidSudoku(char[][] board) {
        return rowCheck(board) && colCheck(board) && subBoxCheck(board);
    }

    private boolean rowCheck(char[][] board){
        boolean isValid = true;
        for(int i = 0; i < 9; i++){
            resetVisited();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(visited[num]){
                        isValid = false;
                    }else{
                        visited[num] = true;
                    }
                }
            }
        }
        return isValid;
    }

    private boolean colCheck(char[][] board){
        boolean isValid = true;
        for(int j = 0; j < 9; j++){
            resetVisited();
            for(int i = 0; i < 9; i++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(visited[num]){
                        isValid = false;
                    }else{
                        visited[num] = true;
                    }
                }
            }
        }
        return isValid;
    }

    private boolean subBoxCheck(char[][] board){
        boolean isValid = true;
        for(int i = 0; i < 9; i += 3){
            for(int j = 0; j < 9; j += 3){
                resetVisited();
                for(int si = i; si < i + 3; si++){
                    for(int sj = j; sj < j + 3; sj++){
                        if(board[si][sj] != '.'){
                            int num = board[si][sj] - '0';
                            if(visited[num]){
                                isValid = false;
                            }else{
                                visited[num] = true;
                            }
                        }
                    }
                }
            }
        }
        return isValid;
    }

    private void resetVisited(){
        for(int i = 1; i < 10; i++){
            visited[i] = false;
        }
    }

}
