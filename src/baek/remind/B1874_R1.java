package baek.remind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1874_R1 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    int N = Integer.parseInt(st.nextToken());
    boolean ok = true;
    int current = 1;
    for(int i =1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      int target = Integer.parseInt(st.nextToken());

      while(current <= target) {
        stack.push(current++);
        sb.append("+").append("\n");
      }

      if(stack.peek() == target) {
        stack.pop();
        sb.append("-").append("\n");
      } else {
        ok = false;
      }

    }

    if (!ok) {
      System.out.println("NO");
    } else {
      System.out.println(sb);
    }

  }
}
