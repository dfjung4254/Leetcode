package com.devjk.nhnInterview;

import java.util.HashMap;
import java.util.HashSet;

public class nhn2020_1 {

    public static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

        HashSet<Character> fastPlayers = new HashSet<>();
        HashMap<Character, Integer> playersCount = new HashMap();
        for(char name : namesOfQuickPlayers){
            fastPlayers.add(name);
        }

        char[] position = new char[numOfAllPlayers - 1];
        for(int i = 0; i < position.length; i++) {
            position[i] = (char) ('B' + i);
            playersCount.put(position[i], 0);
        }

        char curName = 'A';
        int curPos = 0;
        playersCount.put(curName, 1);

        for(int curMove : numOfMovesPerGame){
            int nextPos = getNextPos(curPos, curMove, position.length);
            if(!fastPlayers.contains(position[nextPos])){
                /* change current */
                char tmp = position[nextPos];
                position[nextPos] = curName;
                curName = tmp;
            }
            int playerCnt = playersCount.get(curName);
            playersCount.put(curName, playerCnt + 1);
            curPos = nextPos;
        }

        for(char pos : position){
            System.out.println(pos + " " + playersCount.get(pos));
        }
        System.out.println(curName + " " + playersCount.get(curName));

    }

    private static int getNextPos(int curPos, int curMove, int size){
        int ret = 0;
        int mov = curMove;
        if(curMove < 0){
            mov = size + curMove;
        }
        ret = (curPos + mov) % size;
        return ret;
    }


}
