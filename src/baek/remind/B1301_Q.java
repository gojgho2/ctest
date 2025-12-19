package baek.remind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1301_Q {
//5 5
//  WBWWW
//  WWWWW
//  BBBBB
//  BBBWW
//  WWWWW
  static int whiteCnt, blueCnt, M, N;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static String[][] arr = new String[101][101];
  static boolean[][] visited = new boolean[101][101];


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

     M = Integer.parseInt(st.nextToken());
     N = Integer.parseInt(st.nextToken());


    for(int i = 0; i < N; i++) {
      String str = br.readLine();
      for(int j=0; j < M; j++) {
        arr[i][j] =  Character.toString(str.charAt(j));
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(!visited[i][j]) {
          int count = bfs(i, j, arr[i][j]);
          if (arr[i][j].equals("W")) {
            whiteCnt += count * count;
          } else {
            blueCnt += count * count;
          }
        }
      }
    }

    System.out.println(whiteCnt + " " + blueCnt);

  }

  static int bfs(int i, int j, String str) {
    visited[i][j] = true;

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {i, j});
    int cnt = 0;

    while(!q.isEmpty()) {
      int[] curr = q.poll();
      for(int k = 0; k < 4; k++) {
        int nx = curr[0] + dx[k];
        int ny = curr[1] + dy[k];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
        if(!str.equals(arr[nx][ny])) continue;
        visited[nx][ny] = true;
        q.add(new int[] {nx, ny});
      }
      cnt++;

    }
    return cnt;
  }

  static void print() {
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        System.out.printf(arr[i][j]);
      }
      System.out.println();
    }

  }
}
