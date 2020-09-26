package programmers;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Cache_linkedHashSet {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedHashSet<String> cache = new LinkedHashSet<>();
        int curSize = 0;

        for(String city : cities){
            String loweredCity = city.toLowerCase();
            if(cache.contains(loweredCity)){
                /* hit */
                answer += 1;
                cache.remove(loweredCity);
                cache.add(loweredCity);
            }else{
                /* miss */
                answer += 5;
                if(curSize >= cacheSize){
                    /* change cache with LRU algorithm */
                    Iterator<String> iter = cache.iterator();
                    while(iter.hasNext()){
                        iter.next();
                        iter.remove();
                        cache.add(loweredCity);
                        break;
                    }
                }else{
                    /* no full cache */
                    curSize++;
                    cache.add(loweredCity);
                }
            }

        }

        return answer;
    }

}
