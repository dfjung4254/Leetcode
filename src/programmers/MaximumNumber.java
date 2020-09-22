package programmers;

import java.util.Arrays;

public class MaximumNumber {

    public String solution(int[] numbers) {

        String[] strNumbers = Arrays.stream(numbers)
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);

        Arrays.sort(strNumbers, (a, b) -> {
            long concatA = Long.parseLong(a + b);
            long concatB = Long.parseLong(b + a);
            return Long.compare(concatB, concatA);
        });

        StringBuilder sb = new StringBuilder();
        for(String str : strNumbers){
            sb.append(str);
        }

        return (sb.length() != 0 && sb.charAt(0) == '0') ? "0" : sb.toString();
    }

}
