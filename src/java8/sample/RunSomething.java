package java8.sample;

// java 가 제공해주는 어노테이션
// 어노테이션을 선언함으로써 더욱더 인터페이스를 견고하게 운용가능.
@FunctionalInterface
public interface RunSomething {

  // 인터페이스에서 추상 메서드가 1개 이면 함수형 인터페이스
  void doIt();

  // 여기서 추상 메서드가 하나 더 추가된다면 함수형 인터페이스는 아니다.
  // 아래 주석을 해제한다면 함수형 인터페이스가 아니게 되니
  // 상단의 어노테이션에서 컴파일 오류가 발생할 것.
  // void doAgain();


  static void printName() {
    System.out.println("KH");
  }

  default void printAge() {
    System.out.println("29");
  }

}
