package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1874 {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    Queue<Integer> q = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    for(int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int input = Integer.parseInt(st.nextToken());
      q.add(input);
    }


    for(int i=1;i<=N;i++) {
      stack.push(i);
      sb.append("+").append("\n");

      while (!q.isEmpty() && !stack.isEmpty() && stack.peek().intValue() == q.peek().intValue()) {
        q.poll();
        stack.pop();
        sb.append("-").append("\n");
      }
    }



    if(!q.isEmpty()) {
      System.out.println("NO");
    }else{
      System.out.println(sb);
    }
  }
}
