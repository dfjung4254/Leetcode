package programmers;

import java.util.ArrayList;
import java.util.List;

public class FailRate_simulate {

    public int[] solution(int n, int[] stages) {
        int[] answer = new int[n];

        int peopleSize = stages.length;
        List<int[]> list = new ArrayList<>();
        List<StageInfo> stageList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new int[]{i, 0});
            stageList.add(new StageInfo(i, 0));
        }

        for(int stage : stages){
            stage = stage - 1;
            if(stage < n){
                int[] stageInfo = list.get(stage);
                stageInfo[1]++;
            }
        }

        for(int[] stageInfo : list){
            int stageNo = stageInfo[0];
            int people = stageInfo[1];
            double val = (double) people / peopleSize;
            peopleSize -= people;
            stageList.get(stageNo).val = val;
        }

        stageList.sort((o1, o2) -> {
            if (o1.val < o2.val) {
                return 1;
            } else if (o1.val > o2.val) {
                return -1;
            } else {
                if (o1.index > o2.index) {
                    return 1;
                } else if(o1.index < o2.index){
                    return -1;
                }
                return 0;
            }
        });

        int index = 0;
        for(StageInfo sf : stageList){
            answer[index++] = sf.index + 1;
        }

        return answer;
    }

    private class StageInfo {
        int index;
        double val;
        public StageInfo(int index, double val){
            this.index = index;
            this.val = val;
        }
    }

}
