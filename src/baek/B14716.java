package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14716 {
  static int M;
  static int N;
  static int[][] visited;
  static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
  static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

  static int[][] mp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());

    N = Integer.parseInt(st.nextToken());
    visited = new int[M][N];

    mp = new int[M][N];

    for(int i=0; i<M; i++) {
      StringTokenizer line = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        mp[i][j] = Integer.parseInt(line.nextToken());
      }
    }

    int result = getResult(mp);

    System.out.println(result);
  }

  private static int getResult(int[][] mp) {
    int result = 0;
    for(int i=0; i<mp.length; i++) {
      for(int j=0; j<mp[i].length; j++) {
        if(mp[i][j]==1 && visited[i][j]==0) {
          go(i, j);
          result++;
        }
      }
    }
    return result;
  }

  private static void go(int row, int col) {
    visited[row][col] = 1;

    for(int k=0; k<8; k++) {
      if(row + dx[k] >= M || col + dy[k] >= N || row + dx[k] < 0 || col + dy[k] < 0) continue;
      if(mp[row + dx[k]][col + dy[k]] == 1 && visited[row + dx[k]][col + dy[k]]==0) {
        go(row + dx[k], col + dy[k]);
      }
    }

  }
}
