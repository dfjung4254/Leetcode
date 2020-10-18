package interview;

import java.util.ArrayList;
import java.util.List;

public class Solve1 {

    public int[] solution(int[] a, int[] b, int[] c){

        List<Integer> list = new ArrayList<>();

        int[] pointer = new int[3];
        int[] size = new int[3];
        size[0] = a.length;
        size[1] = b.length;
        size[2] = c.length;

        while(!isAllChecked(pointer, size)){

            int na = a[pointer[0]];
            int nb = b[pointer[1]];
            int nc = c[pointer[2]];

            if(na == nb && nb == nc){
                list.add(a[pointer[0]]);
            }

            boolean[] minIndex = getMinIndex(pointer, a, b, c);
            addMinIndex(pointer, size, minIndex);

        }

        int[] answer = new int[list.size()];
        int i = 0;
        for(int num : list){
            answer[i++] = num;
        }

        return answer;
    }

    private boolean isAllChecked(int[] pointer, int[] size){
        for(int i = 0; i < pointer.length; i++){
            if(pointer[i] < size[i] - 1){
                return false;
            }
        }
        return true;
    }

    private boolean[] getMinIndex(int[] pointer, int[] a, int[] b, int[] c){
        /* 0, 1, 2 중 가장 작은 인덱스를 리턴함 */
        boolean ret[] = new boolean[3];
        int na = a[pointer[0]];
        int nb = b[pointer[1]];
        int nc = c[pointer[2]];
        if(na <= nb && na <= nc){
            ret[0] = true;
        }
        if(nb <= na && nb <= nc){
            ret[1] = true;
        }
        if(nc <= na && nc <= nb){
            ret[2] = true;
        }

        return ret;
    }

    private void addMinIndex(int[] pointer, int[] size, boolean[] minIndex){
        for(int i = 0; i < minIndex.length; i++){
            if(minIndex[i] && pointer[i] < size[i] - 1){
                pointer[i]++;
            }
        }
    }

}
