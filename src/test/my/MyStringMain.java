package test.my;

import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;

public class MyStringMain {

  public static void main(String[] args) {
    MyString str = new MyString();
    System.out.println(str.length());
    System.out.println(str.getString());

    str.setString("Hello Java");

    System.out.println(str.getString());
    System.out.println(str.length());
    System.out.println(str.compareTo(new MyString("Hello Java")));
  }
}
