package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2164 {


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new LinkedList<Integer>();

    for(int i = 1; i<= N; i++) {
      q.add(i);
    }

    while(q.size() > 1) {
      // q 에서 한번 버린다.
      // 그다음 꺼낸건 다시 넣는다.
      // 위 조건이 될떄까지 반복한다.
      q.poll();
      Integer poll = q.poll();
      q.add(poll);
    }

    System.out.println(q.poll());


  }
}
