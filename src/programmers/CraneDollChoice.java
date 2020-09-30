package programmers;

import java.util.Stack;

public class CraneDollChoice {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> st = new Stack<>();

        for(int move : moves){
            /* find upper */
            int i = 0;
            move--;
            boolean isFind = true;
            while(board[i][move] == 0){
                i++;
                if(i >= board.length){
                    isFind = false;
                    break;
                }
            }
            if(!isFind){
                continue;
            }
            int doll = board[i][move];
            board[i][move] = 0;
            if(!st.isEmpty() && st.peek() == doll){
                answer++;
                st.pop();
            }else{
                st.push(doll);
            }
        }
        answer *= 2;
        return answer;
    }

}
