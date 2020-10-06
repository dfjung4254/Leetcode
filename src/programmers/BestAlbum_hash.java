package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum_hash {

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> genreCnt = new HashMap<>();
        Map<String, List<int[]>> genreList = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            if(!genreCnt.containsKey(genres[i])){
                genreCnt.put(genres[i], 0);
                genreList.put(genres[i], new ArrayList<>());
            }
            int cnt = genreCnt.get(genres[i]);
            genreCnt.put(genres[i], cnt + plays[i]);
            List<int[]> list = genreList.get(genres[i]);
            list.add(new int[]{plays[i], i});
            genreList.put(genres[i], list);
        }

        /* sort */
        List<Pair> list = new ArrayList<>();
        for(String key : genreCnt.keySet()){
            list.add(new Pair(key, genreCnt.get(key)));
        }
        list.sort(((o1, o2) -> Integer.compare(o2.value, o1.value)));

        List<Integer> answerList = new ArrayList<>();
        for(Pair pa : list){
            List<int[]> genList = genreList.get(pa.key);
            genList.sort((o1, o2) -> Integer.compare(o2[0], o1[0]));
            int size = genList.size();
            for(int i = 0; i < size; i++){
                if(i >= 2){
                    break;
                }
                answerList.add(genList.get(i)[1]);
            }
        }

        answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    private class Pair{
        String key;
        int value;
        public Pair(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

}
