package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B1021 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    Deque<Integer> stack = new ArrayDeque<>();

    for(int i=1; i<=N; i++) {
      stack.addLast(i);
    }
    st = new StringTokenizer(br.readLine());
    int count = 0;
    for(int i=1; i<=M; i++) {
      int findNum = Integer.parseInt(st.nextToken());
      int idx = 0;
      for(int num : stack) {
        if(num == findNum) {
          break;
        }
        idx++;
      }

      int left = idx;
      int right = stack.size() - idx;
      if(left <= right) {
        for(int j=0; j<left; j++) {
          stack.addLast(stack.pollFirst());
          count++;
        }
      }else {
        for(int j=0; j<right; j++) {
          stack.addFirst(stack.pollLast());
          count++;
        }
      }

      stack.pollFirst();
    }

    System.out.println(count);


  }

}
