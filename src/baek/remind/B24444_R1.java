package baek.remind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B24444_R1 {

  /**
   * 5 5 1
   * 1 4
   * 1 2
   * 2 3
   * 2 4
   * 3 4
   */
  static int n,m,v;
  static int[] visited;
  static ArrayList<Integer>[] graph;
  static int order = 1;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());

    visited = new int[n + 1];
    graph = new ArrayList[n + 1];

    for (int i=1; i<=n; i++) {
      graph[i] = new ArrayList<>();
    }

    for(int i=1; i<=m; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      graph[x].add(y);
      graph[y].add(x);

    }

    for(int i=1; i<=n; i++) {
      Collections.sort(graph[i]);
    }

    bfs(v);


    for(int i=1; i<=n; i++) {
      sb.append(visited[i]).append("\n");
    }

    System.out.println(sb);

  }

  private static void bfs(int start) {
    Queue<Integer> q = new ArrayDeque<>();
    visited[start] = order++;
    q.add(start);
    while(!q.isEmpty()) {
      Integer poll = q.poll();

      for(int next : graph[poll]) {
        if(visited[next] == 0) {
          visited[next] = order++;
          q.add(next);
        };
      }

    }

  }

}
