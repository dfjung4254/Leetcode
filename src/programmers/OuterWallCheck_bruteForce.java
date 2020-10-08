package programmers;

import java.util.*;

public class OuterWallCheck_bruteForce {

    private int answer = 0;

    public int solution(int n, int[] weak, int[] d) {

        Set<Integer> visited = new HashSet<>();

        Integer[] dist = Arrays.stream(d).boxed().toArray(Integer[]::new);
        Arrays.sort(dist, (o1, o2) -> Integer.compare(o2, o1));

        /* brute force */
        getAns(dist, visited, n, weak);
        if(answer == 0){
            answer = -1;
        }

        return answer;
    }

    private void getAns(Integer[] dist, Set<Integer> visited, int n, int[] weak){

        for(int i = 1; i <= dist.length; i++){

            bruteForce(i, 0, new ArrayList<>(), weak, dist, 0, n, new boolean[dist.length]);

        }

    }

    private void bruteForce(int targetCount, int currentCount, List<Integer> distList, int[] weak, Integer[] dist, int index, int n, boolean[] visited){

        if(currentCount >= targetCount){
            System.out.println("try : " + distList.toString());
            boolean chk = checkAvailable(weak, distList, n);
            if(chk && (answer == 0 || answer > currentCount)){
                answer = currentCount;
            }
            return;
        }

        for(int i = 0; i < dist.length; i++){
            if(!visited[i]){
                distList.add(dist[i]);
                visited[i] = true;
                bruteForce(targetCount, currentCount + 1, distList, weak, dist, i + 1, n, visited);
                visited[i] = false;
                distList.remove(distList.size() - 1);
            }
        }

    }

    private boolean checkAvailable(int[] weak, List<Integer> distList, int n){

        int[] weakLine = new int[weak.length];

        /* make start case */
        for(int startIndex = 0; startIndex < weak.length; startIndex++){
            for(int i = startIndex; i < weak.length; i++){
                weakLine[i - startIndex] = weak[i];
            }
            for(int i = 0; i < startIndex; i++){
                weakLine[weak.length - startIndex + i] = weak[i] + n;
            }
            int currentIndex = getMaxLengthIndex(distList, weakLine);
            if(currentIndex >= weakLine.length){
                System.out.println("available : " + Arrays.toString(weakLine));
                return true;
            }
        }

        return false;
    }

    private int getMaxLengthIndex(List<Integer> distList, int[] weakLine){
        int currentIndex = 0;
        for(Integer curDist : distList){
            if(currentIndex >= weakLine.length){
                break;
            }
            int target = weakLine[currentIndex] + curDist;
            while(currentIndex < weakLine.length){
                if(weakLine[currentIndex] <= target){
                    currentIndex++;
                }else{
                    break;
                }
            }
        }
        return currentIndex;
    }

}
