package baek.remind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1325_R2 {


  static List<Integer>[] graph;
  static int visitId = 0;

  static int[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    int M = Integer.parseInt(st.nextToken());

    graph = new List[N + 1];

    for(int i= 1; i<=N; i++) {
      graph[i] = new ArrayList<>();
    }

    for(int i = 0; i< M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[b].add(a);
    }


    StringBuilder sb = new StringBuilder();

    visited = new int[N + 1];
  }
}
