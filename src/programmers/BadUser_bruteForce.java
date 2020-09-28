package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BadUser_bruteForce {

    private Set<String> bannedList;
    private Set<String> visited;

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        bannedList = new HashSet<>();
        visited = new HashSet<>();

        /* bruteForce */
        answer = bruteForce(user_id, banned_id, 0, new String[banned_id.length]);

        return answer;
    }

    private int bruteForce(String[] user_id, String[] banned_id, int index, String[] list){

        int cnt = 0;
        if(index >= banned_id.length){

            String[] sortedList = new String[list.length];
            for(int i = 0; i < sortedList.length; i++){
                sortedList[i] = new String(list[i]);
            }
            Arrays.sort(sortedList);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < sortedList.length; i++){
                sb.append(sortedList[i]);
            }
            if(bannedList.contains(sb.toString())){
                return 0;
            }else{
                bannedList.add(sb.toString());
                return 1;
            }
        }

        String bid = banned_id[index];
        for(String uid : user_id){
            if(!visited.contains(uid) && isAvailable(uid, bid)){
                visited.add(uid);
                list[index] = uid;
                cnt += bruteForce(user_id, banned_id, index + 1, list);
                visited.remove(uid);
            }
        }

        return cnt;
    }

    private boolean isAvailable(String uid, String bid){

        int size = uid.length();
        if(size != bid.length()){
            return false;
        }
        for(int i = 0; i < size; i++){
            if(bid.charAt(i) != '*' && bid.charAt(i) != uid.charAt(i)){
                return false;
            }
        }

        return true;
    }

}
