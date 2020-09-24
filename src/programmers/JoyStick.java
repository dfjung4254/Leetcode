package programmers;

public class JoyStick {

    public int solution(String name) {
        int answer = 0;
        int nearIdx = 0;
        int farIdx = 0;
        int twoPath = 0;

        /* bfs + greedy */
        int idx = 0;
        for(char ch : name.toCharArray()){
            answer += getMinCnt(ch);
            if(ch != 'A'){
                if(nearIdx == 0){
                    nearIdx = idx;
                }
                farIdx = idx;
                int tpIdx = idx + 1;
                int size = name.length();
                for(; tpIdx < size; tpIdx++){
                    if(name.charAt(tpIdx) != 'A'){
                        break;
                    }
                }
                int tpPath = idx + size - tpIdx + 1;
                if(twoPath == 0 || twoPath > tpPath){
                    twoPath = tpPath;
                }
            }
            idx++;
        }

        int onePath = Math.min(farIdx, name.length() - nearIdx);
        answer += Math.min(onePath, twoPath);

        return answer;
    }

    private int getMinCnt(char ch){
        int num1 = ch - 'A';
        int num2 = 'Z' - ch + 1;
        return Math.min(num1, num2);
    }

}
