package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class EnforcementCamera {

    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, Comparator.comparingInt(o -> o[0]));
        int befY = routes[0][1];
        for(int i = 0 ; i < routes.length - 1; i++){
            if(routes[i][1] < befY){
                befY = routes[i][1];
            }
            if(routes[i + 1][0] > befY){
                answer++;
                befY = routes[i + 1][1];
            }
        }

        return answer;
    }

}
