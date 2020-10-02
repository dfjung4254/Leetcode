package programmers;

import java.util.*;

public class LittleFriendsSaCheonSung_simulate_advanced {

    public String solution(int m, int n, String[] board) {
        StringBuilder answer = new StringBuilder();
        Map<Character, int[]> map1 = new HashMap<>();
        Map<Character, int[]> map2 = new HashMap<>();

        /* brute force - n^3 */
        char[][] chBoard = new char[m][n];
        for(int i = 0; i < m; i++){
            char[] ch = board[i].toCharArray();
            for(int j = 0; j < n; j++){
                chBoard[i][j] = ch[j];
                if(chBoard[i][j] != '.' && chBoard[i][j] != '*'){
                    if(map1.containsKey(chBoard[i][j])){
                        map2.put(chBoard[i][j], new int[]{i, j});
                    }else{
                        map1.put(chBoard[i][j], new int[]{i, j});
                    }
                }
            }

        }

        /* TODO : 우선순위 큐 써라 delList 세팅하는거. */
        PriorityQueue<Character> delPq = new PriorityQueue<>();
        Set<Character> offeredPq = new HashSet<>();
        while(true){
            for(Character key : map1.keySet()){
                if(!offeredPq.contains(key)){
                    int[] pos1 = map1.get(key);
                    int[] pos2 = map2.get(key);
                    if(canSimulate(pos1, pos2, chBoard)){
                        delPq.offer(key);
                        offeredPq.add(key);
                    }
                }
            }
            int pqSize = delPq.size();
            int mSize = map1.size();
            if(pqSize == 0 && mSize != 0){
                return "IMPOSSIBLE";
            }
            if(pqSize == 0 && mSize == 0){
                break;
            }

            Character delKey = delPq.poll();
            int[] pos1 = map1.get(delKey);
            int[] pos2 = map2.get(delKey);
            map1.remove(delKey);
            map2.remove(delKey);
            chBoard[pos1[0]][pos1[1]] = '.';
            chBoard[pos2[0]][pos2[1]] = '.';
            answer.append(delKey);

        }

        return answer.toString();
    }

    private boolean canSimulate(int[] pos1, int[] pos2, char[][] board){

        if(pos1[0] == pos2[0] || pos1[1] == pos2[1]){
            return isLineClear(pos1, pos2, board, false);
        }else{
            /* two pass */
            if(pos1[1] > pos2[1]){
                int[] tp = pos1;
                pos1 = pos2;
                pos2 = tp;
            }
            boolean gase, sega;
            gase = (isLineClear(pos1, new int[]{pos1[0], pos2[1]}, board, true)
             && isLineClear(pos2, new int[]{pos1[0], pos2[1]}, board, true));
            sega = (isLineClear(pos1, new int[]{pos2[0], pos1[1]}, board, true)
             && isLineClear(pos2, new int[]{pos2[0], pos1[1]}, board, true));
            return(gase || sega);
        }
    }

    private boolean isLineClear(int[] pos1, int[] pos2, char[][] board, boolean isTwoPass){
        int[] npos1 = pos1.clone();
        int[] npos2 = pos2.clone();
        if(pos1[0] == pos2[0]){
            /* one pass - 가로 */
            if(npos1[1] > npos2[1]){
                int tp = npos1[1];
                npos1[1] = npos2[1];
                npos2[1] = tp;
            }
            for(int j = npos1[1] + 1; j < npos2[1]; j++){
                if(board[npos1[0]][j] != '.'){
                    return false;
                }
            }
            if(isTwoPass && (board[npos1[0]][npos1[1]] != '.' && board[npos2[0]][npos2[1]] != '.')){
                return false;
            }
        }else if(npos1[1] == npos2[1]){
            /* one pass - 세로*/
            if(npos1[0] > npos2[0]){
                int tp = npos1[0];
                npos1[0] = npos2[0];
                npos2[0] = tp;
            }
            for(int i = npos1[0] + 1; i < npos2[0]; i++){
                if(board[i][npos1[1]] != '.'){
                    return false;
                }
            }
            if(isTwoPass && (board[npos1[0]][npos1[1]] != '.' && board[npos2[0]][npos2[1]] != '.')){
                return false;
            }
        }
        return true;
    }

}
