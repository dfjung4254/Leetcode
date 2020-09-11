package programmers;

public class Carpet {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        bruteForce(answer, brown, yellow);

        return answer;
    }

    private void bruteForce(int[] answer, int brown, int yellow) {

        int mid = yellow / 2 + 1;
        for(int i = 1; i <= mid; i++){
            if(yellow % i == 0){
                int mocs = yellow / i;
                int brownCandidate = (i * 2) + (mocs * 2) + 4;
                if(brownCandidate == brown){
                    /* find answer */
                    answer[0] = Math.max(i, mocs) + 2;
                    answer[1] = Math.min(i, mocs) + 2;
                    break;
                }
            }
        }
    }

}
