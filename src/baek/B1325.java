package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1325 {


  static List<Integer>[] graph;
  static int[] answers;

  static int cnt;
  static int[] visited;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Integer N = Integer.parseInt(st.nextToken());
    Integer M = Integer.parseInt(st.nextToken());

    graph = new List[N + 1];
    answers = new int[N + 1];

    for(int i=1;i<=N;i++) {
      graph[i] = new ArrayList<>();
    }

    for(int i=1;i<=M;i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      graph[y].add(x);
    }

    for(int i=1;i<=N;i++) {
      visited = new int[N + 1];
      visited[i] = 1;
      cnt = 0;
      dfs(i);
      answers[i] = cnt;
    }

    int mx = Integer.MIN_VALUE;
    StringBuilder sb = new StringBuilder();
    for(int i=1;i<=N;i++) {

      if(mx < answers[i]) {
        mx = answers[i];
        sb = new StringBuilder();
        sb.append(i).append(" ");
      } else if (mx == answers[i]){
        sb.append(i).append(" ");
      }

    }

    System.out.println(sb.substring(0, sb.length()-1));
  }


  static void dfs(int i) {

    for(int nx : graph[i]) {
      if(visited[nx] == 0) {
        visited[nx] = 1;
        cnt++;
        dfs(nx);
      }
    }
  }
}
