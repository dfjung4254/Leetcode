package programmers;

public class PredictDraw {

    public int solution(int n, int a, int b){

        int gameCnt = 0;
        int untilDiv = 0;
        int ta = Math.min(a, b);
        int tb = Math.max(a, b);
        int index = n / 2;
        boolean isFind = false;
        while(n != 1){
            n = n / 2;
            if(!isFind && ta <= index && tb > index){
                isFind = true;
                untilDiv = gameCnt;
            }
            if(ta <= index){
                index -= n / 2;
            }else{
                index += n / 2;
            }
            gameCnt++;
        }

        return gameCnt - untilDiv;
    }

}
