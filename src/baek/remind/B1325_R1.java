package baek.remind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1325_R1 {


  static List<Integer>[] graph;
  static int visitId = 0;
  static int[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int M = Integer.parseInt(st.nextToken());

    graph = new List[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[b].add(a);
    }

    StringBuilder sb = new StringBuilder();

    visited = new int[N + 1];
    int[] count = new int[N + 1];
    int max = -1;

    for (int i = 1; i <= N; i++) {
      visitId++;
      count[i] = bfs(i);

      if(count[i] > max) {
        max = count[i];
      }
    }

    for (int i = 1; i <= N; i++) {
      if(count[i] == max) {
        sb.append(i).append(' ');
      }
    }

    if(sb.charAt(sb.length() - 1) == ' ') {
      sb.setLength(sb.length() - 1);
    }

    System.out.println(sb);
  }


  static int bfs(int i) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.add(i);
    visited[i] = visitId;
    int cnt = 1;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for(int nx : graph[cur]) {
        if (visited[nx] != visitId) {
          visited[nx] = visitId;
          cnt++;
          q.add(nx);
        }
      }
    }
    return cnt;
  }


}
