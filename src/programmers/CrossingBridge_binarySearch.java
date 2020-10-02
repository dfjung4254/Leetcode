package programmers;

public class CrossingBridge_binarySearch {

    public int solution(int[] stones, int k) {
        int answer = 0;

        int left = 1;
        int right = 200000001;
        int mid = 0;
        while(left < right){
            mid = (left + right) / 2;

            if(isCrossingAvailable(stones, mid, k)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left - 1;
    }

    private boolean isCrossingAvailable(int[] stones, int mid, int k){

        int value = mid - 1;
        int zeroStartIdx = 0;
        boolean isBeforeZero = false;
        int i = 0;
        for(; i < stones.length; i++){
            int minusStone = stones[i] - value;
            if(minusStone <= 0){
                if(!isBeforeZero){
                    zeroStartIdx = i;
                    isBeforeZero = true;
                }
            }else{
                if(isBeforeZero){
                    int zeroCnt = i - zeroStartIdx;
                    if(zeroCnt >= k){
                        return false;
                    }
                }
                isBeforeZero = false;
            }
        }
        if(isBeforeZero){
            int zeroCnt = i - zeroStartIdx;
            return zeroCnt < k;
        }

        return true;
    }

}
