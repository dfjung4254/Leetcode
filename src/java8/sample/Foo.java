package java8.sample;

public class Foo {

  public static void main(String[] args) {

    // 익명 내부 클래스 - anonymous inner class
    RunSomething runSomething = new RunSomething() {
      @Override
      public void doIt() {
        System.out.println("Hello");
      }
    };

    // 람다 사용 - 함수형 익명 클래스
    RunSomething runSomethingFunctional = () -> System.out.println("Hello");

    RunSomething runSomethingFunctional2 = () -> {
      System.out.println("Hello");
      System.out.println("JKH");
    };

    runSomethingFunctional2.doIt();


    // 모두 동일하게 돌아감. 코드가 줄어듬.


  }

}
