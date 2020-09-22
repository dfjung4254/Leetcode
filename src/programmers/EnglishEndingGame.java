package programmers;

import java.util.HashSet;
import java.util.Set;

public class EnglishEndingGame {

    public int[] solution(int n, String[] words) {
        int[] answer;

        int ans = 0;
        Set<String> visited = new HashSet<>();

        boolean isStart = true;
        boolean isFind = true;
        String before = "";
        for(String word : words){
            ans++;
            if(!isStart){
                if(!isValid(word, before, visited)){
                    isFind = false;
                    break;
                }
            }
            isStart = false;
            before = word;
            visited.add(word);
        }

        answer = new int[2];
        if(!isFind){
            answer[0] = ans % n;
            answer[1] = ans / n;
            if(answer[0] != 0){
                answer[1]++;
            }else{
                answer[0] = n;
            }
        }

        return answer;
    }

    private boolean isValid(String word, String before, Set<String> visited){
        if(visited.contains(word)) return false;
        return word.charAt(0) == before.charAt(before.length() - 1);
    }

}
