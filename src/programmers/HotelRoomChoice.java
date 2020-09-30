package programmers;

import java.util.HashMap;
import java.util.Map;

public class HotelRoomChoice {

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        Map<Long, Long> map = new HashMap<>();
        int idx = 0;
        for(long roomNo : room_number){

            long visitedRoom = findRoot(map, roomNo);
            answer[idx++] = visitedRoom;

        }

        return answer;
    }

    private long findRoot(Map<Long, Long> map, long roomNo){

        if(map.containsKey(roomNo)){
            long val = findRoot(map, map.get(roomNo));
            map.put(roomNo, val);
            return map.get(roomNo);
        }else{
            map.put(roomNo, roomNo + 1);
            return roomNo;
        }

    }

}
