package java8.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FooInt {

  RunSomethingInt runSomethingInt = num -> num + 1;

  List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

  Integer sum2 = integers.stream()
          .reduce(0, Integer::sum);



  public FooInt() {

    // 스트림
    // 1. 배열 스트림 생성
    String[] arr = new String[] {
            "a", "b", "c"
    };
    Stream<String> stream = Arrays.stream(arr);
    Stream<String> streamParallel = Arrays.stream(arr).parallel();

    Arrays.sort(arr);

    // 2. 컬렉션 스트림
    List<String> list = new ArrayList<>() {{
      add("1");
      add("2");
    }};

    List<String> list2 = Arrays.asList("1", "2");
    Stream<String> streamList = list.stream();
    Stream<String> streamParallelStream = list2.parallelStream();

    List<Long> longList = Arrays.asList(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);
    longList.stream()
            .reduce(0L, Long::sum);


  }







}
