package programmers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ChangeWords {

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Set<String> visited = new HashSet<>();
        Queue<Word> q = new LinkedList<>();

        visited.add(begin);
        q.offer(new Word(begin, 0));
        while(!q.isEmpty()){
            Word curStr = q.poll();
            if(curStr.word.equals(target)){
                answer = curStr.dist;
                break;
            }
            for(String word : words){
                if(!visited.contains(word) && isAvailable(word, curStr.word)){
                    visited.add(word);
                    q.offer(new Word(word, curStr.dist + 1));
                }
            }

        }
        return answer;
    }

    private boolean isAvailable(String word1, String word2){
        int size = word1.length();
        int diffCnt = 0;
        for(int i = 0; i < size; i++){
            if(word1.charAt(i) != word2.charAt(i)){
                diffCnt++;
            }
        }

        return (diffCnt == 1);
    }

    private class Word{
        String word;
        int dist;
        public Word(String word, int dist){
            this.word = word;
            this.dist = dist;
        }
    }

}
