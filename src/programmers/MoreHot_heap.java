package programmers;

import java.util.PriorityQueue;

public class MoreHot_heap {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : scoville){
            pq.offer(num);
        }

        while(!pq.isEmpty()){
            int first = pq.poll();
            if(first >= K){
                break;
            }
            int second = 0;
            if(!pq.isEmpty()){
                second = pq.poll();
            }else{
                answer = -1;
                break;
            }
            int mixed = first + (second * 2);
            pq.offer(mixed);
            answer++;
        }

        return answer;
    }

}
