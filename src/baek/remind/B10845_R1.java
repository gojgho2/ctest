package baek.remind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10845_R1 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    int[] q = new int[10004];
    int front = 0;
    int back = 0;
    StringBuilder sb = new StringBuilder();

    while(N-- > 0)  {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      if(command.contains("push")) {
        int add = Integer.parseInt(st.nextToken());
        q[back++] = add;
        continue;
      }

      switch(command) {
        case "front":
          if(front == back) {
            sb.append("-1").append("\n");
          } else {
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
        case "empty":
          if(front == back) {
            sb.append("1").append("\n");
          } else {
            sb.append("0").append("\n");
          }
          break;
        case "pop":
          if(front == back) {
            sb.append("-1").append("\n");
          } else {
            sb.append(q[front++]).append("\n");
          }
        break;
      }

    }
    System.out.println(sb.toString());


  }
}
