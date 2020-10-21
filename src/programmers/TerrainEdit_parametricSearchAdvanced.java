package programmers;

public class TerrainEdit_parametricSearchAdvanced {

    public long solution(int[][] land, int P, int Q) {

        /* use parametric search - 2차함수의 최소값을 구하는 느낌으로 */
        long left = 0;
        long right = 1000000001;
        long heightCandidate = 0;
        while(left < right){

            heightCandidate = (left + right) / 2;
            if(val(heightCandidate,land, P, Q) > val(heightCandidate + 1, land, P, Q)){
                left = heightCandidate + 1;
            }else{
                right = heightCandidate;
            }

        }

        return val(left, land, P, Q);
    }

    private long val(long candidate, int[][] land, int p, int q){
        long ret = 0;
        for(int[] row : land){
            for(int eachCount : row){
                long diff = Math.abs(eachCount - candidate);
                ret += (eachCount > candidate) ? diff * q : diff * p;
            }
        }
        return ret;
    }

}
