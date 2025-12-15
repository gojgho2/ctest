package test;

import java.util.concurrent.ThreadLocalRandom;

public class IdTest {
  private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
      .toCharArray();
  private static final int BASE = BASE62.length;



  public static void main(String[] args) {

    for(int i=0; i<100; i++) {
      System.out.println(generate10());
    }
  }

  public static String generate(int length) {
    StringBuilder sb = new StringBuilder(length);
    ThreadLocalRandom random = ThreadLocalRandom.current();
    for (int i = 0; i < length; i++) {
      int idx = random.nextInt(BASE);
      sb.append(BASE62[idx]);
    }
    return sb.toString();
  }

  public static String generate10() {
    return generate(10);
  }
}
