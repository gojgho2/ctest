package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B24444 {

    static int n, m, v;
    static int[] visited;
    static int[][] route;
    static int order = 1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];
        route = new int[n + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            route[x][y] = 1;
            route[y][x] = 1;
        }

        bfs(v);

        for(int i=1; i<=n; i++){
          sb.append(visited[i]).append("\n");
        }


        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = order++;

        while (!q.isEmpty()) {
            Integer row = q.poll();
            for (int next = 1; next <= n; next++) {
                if (route[row][next] == 1 && visited[next] == 0) {
                    visited[next] = order++;
                    q.add(next);
                }
            }
        }

    }
}
