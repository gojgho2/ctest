package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10845 {
//15
//  push 1
//  push 2
//  front
//  back
//  size
//  empty
//  pop
//  pop
//  pop
//      size
//  empty
//      pop
//  push 3
//  empty
//      front
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int idx = 1;
    int[] q = new int[10001];
    int front = 0;
    int back = 0;
    StringBuilder sb = new StringBuilder();

    while(N-- > 0) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      if (command.contains("push")) {
        int a = Integer.parseInt(st.nextToken());
        q[back++] = a; // 맨뒤 넣고 back 증가
        continue;
      }

      switch (command) {
        case "front":
          if(front == back) {
            sb.append("-1").append("\n");
          }else {
            sb.append(q[front]).append("\n");
          }
          break;
        case "back":
          if(front == back) {
            sb.append("-1").append("\n");
          } else {
            sb.append(q[back - 1]).append("\n");
          }
          break;
        case "size":
          sb.append(back - front).append("\n");
          break;
        case "pop":
          if(front == back) {
            sb.append("-1").append("\n");
          } else {
            sb.append(q[front++]).append("\n");
          }
        break;
        case "empty":
          if (front == back) {
            sb.append("1").append("\n");
          } else {
            sb.append("0").append("\n");
          }
        break;
      }

    }

    System.out.println(sb.toString());

  }
}
