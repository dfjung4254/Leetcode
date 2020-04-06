package com.devjk;

public class Line2020_2 {

    private int answer;
    private int answer_length;

    public int solution(String answer_sheet, String[] sheets) {
        answer = 0;
        answer_length = answer_sheet.length();
        int peopleSize = sheets.length;
        for(int i = 0; i < peopleSize - 1; i++){
            for(int j = i + 1; j < peopleSize; j++){
                int tpAns = getLongestAns(answer_sheet, sheets[i], sheets[j]);
                answer = Math.max(answer, tpAns);
            }
        }

        return answer;
    }

    public int getLongestAns(String answer_sheet, String sheet1, String sheet2){
        int count = 0;
        int seqCount = 0;
        int maxSeqCount = 0;
        for(int i = 0; i < answer_length; i++){
            /* 답이 틀리고 시트가 일치하는 경우 */
            if(answer_sheet.charAt(i) != sheet1.charAt(i) && sheet1.charAt(i) == sheet2.charAt(i)){
                count++;
                seqCount++;
            }else{
                maxSeqCount = Math.max(seqCount, maxSeqCount);
                seqCount = 0;
            }
        }
        maxSeqCount = Math.max(seqCount, maxSeqCount);

        return count + maxSeqCount * maxSeqCount;
    }

}
