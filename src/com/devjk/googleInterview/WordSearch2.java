package com.devjk.googleInterview;

import java.util.ArrayList;
import java.util.List;

/*

    Google Interview - Word Search 2
    Given a 2D board and a list of words from the dictionary, find all words in the board.
    Each word must be constructed from letters of sequentially adjacent cell,
    where "adjacent" cells are those horizontally or vertically neighboring.
    The same letter cell may not be used more than once in a word.

    Example:
        Input:
            board = [
                ['o','a','a','n'],
                ['e','t','a','e'],
                ['i','h','k','r'],
                ['i','f','l','v']
            ]
            words = ["oath","pea","eat","rain"]
        Output: ["eat","oath"]

    Note:
        1. All inputs are consist of lowercase letters a-z.
        2. The values of words are distinct.

 */
public class WordSearch2 {

    private List<String> ans;
    private final int[] DIR_I = {0, 1, 0, -1};
    private final int[] DIR_J = {1, 0, -1, 0};

    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<>();
        for(String word : words){
            if(isWordInBoard(board, word)){
                ans.add(word);
            }
        }
        return ans;
    }

    public boolean isWordInBoard(char[][] board, String word){
        int word_size = word.length();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(findRecursiveWay(board, word, i, j, 0, word_size)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean findRecursiveWay(char[][] board, String word, int i, int j, int index, int word_size){
        boolean[][] visited = new boolean[board.length][board[0].length];
        return findRecursiveWay(board, word, i, j, index, word_size, visited);
    }

    public boolean findRecursiveWay(char[][] board, String word, int i, int j, int index, int word_size, boolean[][] visited){

        if(index >= word_size){
            return true;
        }

        char target = word.charAt(index);
        if(checkBoundary(i, j, board.length, board[0].length) && !visited[i][j] && target == board[i][j]){
            visited[i][j] = true;
            for(int dir = 0; dir < 4; dir++){
                int next_i = i + DIR_I[dir];
                int next_j = j + DIR_J[dir];
                if(findRecursiveWay(board, word, next_i, next_j, index + 1, word_size, visited)){
                    return true;
                }
            }
            visited[i][j] = false;
        }

        return false;
    }

    public boolean checkBoundary(int i, int j, int size_i, int size_j){
        return (i >= 0 && i < size_i && j >= 0 && j < size_j);
    }

}
