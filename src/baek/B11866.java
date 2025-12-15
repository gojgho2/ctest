package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11866 {

  public static void main(String[] args) throws IOException {
    String in = new BufferedReader(new InputStreamReader(System.in)).readLine();

    StringTokenizer st = new StringTokenizer(in);

    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new LinkedList<>();

    for(int i=1; i<=n; i++) {
      q.add(i);
    }
    int flag = 1;
    while(!q.isEmpty()) {


      if(flag == k) {
        Integer poll = q.poll();
        sb.append(poll).append(", ");
        flag = 1;
      } else {
        flag++;
        q.add(q.poll());
      }


    }

    String substring = sb.substring(0, sb.length() - 2);
    System.out.printf("<%s>%n", substring);
  }
}
