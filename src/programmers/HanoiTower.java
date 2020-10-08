package programmers;

import java.util.ArrayList;
import java.util.List;

public class HanoiTower {

    public int[][] solution(int n) {
        List<int[]> answerList = new ArrayList<>();

        /* recursive */
        hanoi(answerList, n, 1, 3);


        int[][] answer = new int[answerList.size()][2];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private void hanoi(List<int[]> answer, int n, int src, int dest){

        if(n == 1){
            answer.add(new int[]{src, dest});
        }else{
            hanoi(answer, n - 1, src, 6 - src - dest);
            answer.add(new int[]{src, dest});
            hanoi(answer, n - 1, 6 - src - dest, dest);
        }

    }

}
