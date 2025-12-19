package baek.remind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B10866 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    Deque<Integer> stack = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();


    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();


      switch (command) {
        case "push_back":
          stack.addLast(Integer.parseInt(st.nextToken()));
          break;
        case "push_front":
          stack.addFirst(Integer.parseInt(st.nextToken()));
          break;
        case "front":
          sb.append(stack.isEmpty() ? sb.append("-1\n") : sb.append(stack.peek()).append("\n"));
          break;
        case "back":
          sb.append(stack.isEmpty() ? sb.append("-1\n") : sb.append(stack.peekLast()).append("\n"));
          break;
        case "empty":
          sb.append(stack.isEmpty() ? sb.append("1\n") : sb.append("0").append("\n"));
          break;
        case "size":
          sb.append(stack.size()).append("\n");
          break;
        case "pop_front":
          sb.append(stack.isEmpty() ? sb.append("-1\n") : sb.append(stack.pollFirst()).append("\n"));
          break;
        case "pop_back":
          sb.append(stack.isEmpty() ? sb.append("-1\n") : sb.append(stack.pollLast()).append("\n"));
          break;
      }

    }
    System.out.println(sb);

  }
}
