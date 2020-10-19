package programmers;

public class NumberBlock {

    /*

        효율성 failed..

     */


    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];

        /* begin ~ end 까지 최대 10000 */
        int idx = 0;
        for(long num = begin; num <= end; num++){
            /* num 의 약수 중 최대값을 구한다 */
            double max = Math.sqrt((double)num);
            long yaksoo = 0;
            for(long i = 2; i <= max; i++){
                if(num / i > 10000000){
                    continue;
                }
                if(num % i == 0){
                    yaksoo = (long) num / i;
                    break;
                }
            }
            if(yaksoo == 0){
                yaksoo = 1;
            }
            answer[idx++] = (int) yaksoo;
        }

        if(begin == 1){
            answer[0] = 0;
        }

        return answer;
    }

}
