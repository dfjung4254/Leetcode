package java8.sample;

import com.google.gson.Gson;

import java.util.HashMap;

public class gsonMapTest {

  public static void main(String[] args) {

    HashMap<String, Object> map = new HashMap<>(){{
      put("sdfsdf", "234234");
    }};

    String serial = new Gson().toJson(map);

    System.out.println(serial);

  }

}
