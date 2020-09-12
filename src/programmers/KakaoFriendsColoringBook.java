package programmers;

import java.util.HashSet;
import java.util.Set;

public class KakaoFriendsColoringBook {

    public int[] solution(int[][] v) {

        int[] answer = {};

        System.out.println("Hello Java");

        Set<Integer> x_map = new HashSet<>();
        Set<Integer> y_map = new HashSet<>();

        for(int i = 0; i < v.length; i++){
            if(x_map.contains(v[i][0])){
                x_map.remove(v[i][0]);
            }else{
                x_map.add(v[i][0]);
            }
            if(y_map.contains(v[i][1])){
                y_map.remove(v[i][1]);
            }else{
                y_map.add(v[i][1]);
            }
        }

        int x = x_map.iterator().next();
        int y = y_map.iterator().next();

        answer = new int[2];
        answer[0] = x;
        answer[1] = y;

        return answer;
    }

}
