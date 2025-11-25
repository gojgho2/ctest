package baek.remind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10828_S1 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int idx = 0;

    int[] stack = new int[N + 1];

    for(int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch (command) {
        case "push":
          int add = Integer.parseInt(st.nextToken());
          stack[idx++] = add;
          break;
        case "pop":
          if(idx == 0) {
            sb.append(-1).append("\n");
          } else {
            sb.append(stack[idx - 1]).append("\n");
            idx--;
          }
          break;
        case "size":
          sb.append(idx).append("\n");
          break;
        case "empty":
          if(idx == 0) {
            sb.append(1).append("\n");
          } else {
            sb.append(0).append("\n");
          }
          break;
        case "top":
          if(idx == 0) {
            sb.append(-1).append("\n");
          } else {
            sb.append(stack[idx - 1]).append("\n");
          }
          break;
      }
    }

    System.out.println(sb);
  }


}

