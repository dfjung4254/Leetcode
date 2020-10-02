package programmers;

import java.util.*;

public class DoublePriorityQueue {

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        /* number - index */
        PriorityQueue<Number> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.num, o1.num));
        PriorityQueue<Number> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.num));
        Set<Integer> isUsing = new HashSet<>();

        int idx = 0;
        for(String operation : operations){
            String[] op = operation.split( " ");
            String cmd = op[0];
            int num = Integer.parseInt(op[1]);
            if("I".equals(cmd)){
                isUsing.add(idx);
                maxHeap.offer(new Number(num, idx));
                minHeap.offer(new Number(num, idx++));
            }else{
                if(num == 1){
                    RemoveHeap(maxHeap, isUsing);
                }else{
                    RemoveHeap(minHeap, isUsing);
                }
            }
        }

        boolean isAnswerSet = false;
        while(!maxHeap.isEmpty()){
            Number num = maxHeap.poll();
            if(isUsing.contains(num.idx)){
                answer[0] = num.num;
                isAnswerSet = true;
            }

            if(isAnswerSet){
                break;
            }
        }

        isAnswerSet = false;
        while(!minHeap.isEmpty()){
            Number num = minHeap.poll();
            if(isUsing.contains(num.idx)){
                answer[1] = num.num;
                isAnswerSet = true;
            }

            if(isAnswerSet){
                break;
            }
        }

        return answer;
    }

    private void RemoveHeap(PriorityQueue<Number> heap, Set<Integer> isUsing) {
        while (!heap.isEmpty()) {
            boolean isDelComplete = false;
            Number polledNum = heap.poll();
            if(isUsing.contains(polledNum.idx)){
                isUsing.remove(polledNum.idx);
                isDelComplete = true;
            }
            if(isDelComplete){
                break;
            }
        }
    }

    private class Number {
        int num;
        int idx;
        public Number(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }

}
