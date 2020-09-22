package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeTest {

    private final int[][] SOLUTIONS = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int[] answer;
        List<Integer> list = new ArrayList<>();


        int min = 0;
        for(int i = 0; i < 3; i++){

            int solCnt = 0;
            for(int j = 0; j < answers.length; j++){
                if(SOLUTIONS[i][j % SOLUTIONS[i].length] == answers[j]){
                    solCnt++;
                }
            }


            if(solCnt > min){
                list.clear();
                list.add(i + 1);
                min = solCnt;
            }else if(solCnt == min){
                list.add(i + 1);
            }

        }

        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

}
