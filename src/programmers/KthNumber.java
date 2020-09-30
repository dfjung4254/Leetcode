package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthNumber {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int cmdIdx = 0;
        for(int[] cmd : commands){
            int left = cmd[0] - 1;
            int right = cmd[1] - 1;
            int idx = cmd[2] - 1;
            List<Integer> list = new ArrayList<>();
            for(int i = left; i <= right; i++){
                list.add(array[i]);
            }
            Collections.sort(list);
            answer[cmdIdx++] = list.get(idx);
        }

        return answer;
    }

}
