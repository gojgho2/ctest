package test.my;

import java.nio.charset.StandardCharsets;

public class MyString implements Comparable<MyString> {

  private byte[] string;


  public MyString() {

  }
  public MyString(String str) {
    this.string = str.getBytes();
  }

  public String getString() {
    return string == null ? "" : new String(string);
  }

  public void setString(String str) {
    this.string = str.getBytes(StandardCharsets.UTF_8);
  }

  public int length() {
    return string == null ? 0 : string.length;
  }

  @Override
  public int compareTo(MyString o) {
    return string.length - o.length();
  }
}
