package baek.remind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B24444_R2 {

  static int N, M, START;
  static List<Integer>[] graph;
  static boolean[] visited;
  static int[] result;
  static int order = 1;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    START = Integer.parseInt(st.nextToken());
    visited = new boolean[N+1];
    result = new int[N+1];
    graph = new List[N+1];
    for(int i=1; i<=N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i =1 ; i<=M; i++) {
        st = new StringTokenizer(br.readLine());
        Integer a = Integer.parseInt(st.nextToken());
        Integer b = Integer.parseInt(st.nextToken());
        graph[a].add(b);
        graph[b].add(a);
    }

    for(int i=1; i<=N; i++) {
      Collections.sort(graph[i]);
    }

    result[START] = order;
    bfs(START);

    for(int i=1; i<=N; i++) {
      System.out.print(result[i] + "\n");
    }
  }

  private static void bfs(int start) {
    visited[start] = true;
    Queue<Integer> q = new LinkedList<>();
    q.add(start);

    while(!q.isEmpty()) {
      Integer poll = q.poll();

      for(Integer nx : graph[poll]) {
        if(!visited[nx]) {
          visited[nx] = true;
          q.add(nx);
          result[nx] = ++order;
        }
      }

    }
  }
}
