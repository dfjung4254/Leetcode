package com.devjk.kakaoInterview2021_1;

public class kakao2021_1_1_3_1 {

    private ArrayList<Integer>[][][][] chain = new ArrayList[4][3][3][3];

    public int[] solution(String[] info, String[] query) {
        int[] answer;

        for(int a = 0; a < 3; a++){
            for(int b = 0; b < 2; b++){
                for(int c = 0; c < 2; c++){
                    for(int d = 0; d < 2; d++){
                        chain[a][b][c][d] = new ArrayList<>();
                    }
                }
            }
        }

        /* set Info */
        for(String oneInfo : info){
            String[] parsed = oneInfo.split(" ");
            int lang; int type; int career; int soulFood; int codingTest;
            if("cpp".equals(parsed[0])) lang = 0;
            else if("java".equals(parsed[0])) lang = 1;
            else lang = 2;
            type = ("backend".equals(parsed[1])) ? 0 : 1;
            career = ("junior".equals(parsed[2])) ? 0 : 1;
            soulFood = ("chicken".equals(parsed[3])) ? 0 : 1;
            codingTest = Integer.parseInt(parsed[4]);
            chain[lang][type][career][soulFood].add(codingTest);

        }



        /* do query */
        answer = new int[query.length];
        int idx = 0;
        for(String cmd : query){

            String[] parsed = cmd.split(" ");
            /* 0, 2, 4, 6, 7*/
            int[] lang; int[] type; int[] career; int[] soulFood; int codingTarget;
            if("-".equals(parsed[0])){
                lang = new int[3];
                lang[0] = 0; lang[1] = 1; lang[2] = 2;
            }else{
                lang = new int[1];
                if("cpp".equals(parsed[0])) lang[0] = 0;
                else if("java".equals(parsed[0])) lang[0] = 1;
                else lang[0] = 2;
            }
            if("-".equals(parsed[2])){
                type = new int[2];
                type[0] = 0; type[1] = 1;
            }else{
                type = new int[1];
                type[0] = ("backend".equals(parsed[2])) ? 0 : 1;
            }
            if("-".equals(parsed[4])){
                career = new int[2];
                career[0] = 0; career[1] = 1;
            }else{
                career = new int[1];
                career[0] = ("junior".equals(parsed[4])) ? 0 : 1;
            }
            if("-".equals(parsed[6])){
                soulFood = new int[2];
                soulFood[0] = 0; soulFood[1] = 1;
            }else{
                soulFood = new int[1];
                soulFood[0] = ("chicken".equals(parsed[6])) ? 0 : 1;
            }

            codingTarget = Integer.parseInt(parsed[7]);

            int cnt = 0;
            for (int value : lang) {
                for (int k : type) {
                    for (int i : career) {
                        for (int j : soulFood) {
                            for (int codingInfo : chain[value][k][i][j]) {
                                if (codingInfo >= codingTarget) {
                                    cnt++;
                                }
                            }
                        }
                    }
                }
            }
            answer[idx++] = cnt;

        }

        return answer;
    }

}
