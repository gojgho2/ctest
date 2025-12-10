package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2606 {


  static List<Integer>[] graph;
  static boolean[] visited;
  static int N, M;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    graph = new List[N + 1];
    visited = new boolean[N + 1];
    M = Integer.parseInt(st.nextToken());


    for(int i = 1; i <= N; i++) {
      graph[i] = new ArrayList();
    }

    for(int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    visited[1] = true;
    int result = dfs(1);

    System.out.println(result - 1);
  }

  private static int dfs(int v) {
    int result = 1;
    List<Integer> list = graph[v];
    for(int nx : list) {
      if(!visited[nx]) {
        visited[nx] = true;
        result += dfs(nx);
      }
    }

    return result;
  }
}
