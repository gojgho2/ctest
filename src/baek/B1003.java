package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B1003 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    Map<Integer, Fibo> map = new HashMap<Integer, Fibo>();

    Fibo fibo = new Fibo(1, 0);
    Fibo fibo1 = new Fibo(0, 1);

    map.put(0, fibo);
    map.put(1, fibo1);

    for(int i=2; i<=40; i++) {
      if(!map.containsKey(i)) {
        map.put(i, new Fibo(map.get(i-1).x + map.get(i-2).x, map.get(i-1).y + map.get(i-2).y));
      }
    }

    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());

      sb.append(map.get(M).getResult()).append('\n');
    }

    System.out.println(sb);
  }

  static class Fibo {
    int x;
    int y;

    public Fibo(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Fibo{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }

    public int x() {
      return x;
    }

    public int y() {
      return y;
    }

    public String getResult() {
      return x + " " + y;
    }
  }

}
