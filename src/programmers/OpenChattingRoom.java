package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChattingRoom {

    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();

        /* uid , nickName */
        Map<String, String> map = new HashMap<>();

        for(String cmdLine : record){
            String[] splitCmd = cmdLine.split(" ");
            String cmd = splitCmd[0];
            String uid = splitCmd[1];
            if("Enter".equals(cmd) || "Change".equals(cmd)){
                String nickName = splitCmd[2];
                map.put(uid, nickName);
            }

        }

        for(String cmdLine : record){
            String[] splitCmd = cmdLine.split(" ");
            String cmd = splitCmd[0];
            String uid = splitCmd[1];
            if("Enter".equals(cmd)){
                list.add(map.get(uid) + "님이 들어왔습니다.");
            }else if("Leave".equals(cmd)){
                list.add(map.get(uid) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

}
