package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1303 {

  static String[][] soldierLocation = new String[101][101];
  static boolean[][] visited = new boolean[101][101];

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int N;
  static int M;
  static int a , b;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

     M = Integer.parseInt(st.nextToken());
     N = Integer.parseInt(st.nextToken());

    for(int i = 0; i< N; i++){
      st = new StringTokenizer(br.readLine());
      char[] charArray = st.nextToken().toCharArray();
      for(int j=0; j<charArray.length; j++){
        soldierLocation[i][j] = String.valueOf(charArray[j]);
      }
    }

//    printSoldier();


    for(int i = 0; i< N; i++){
      for(int j = 0; j< M; j++){
        String sol = soldierLocation[i][j];
        if(!visited[i][j]) {
          visited[i][j] = true;
          if (sol.equals("W")) {
            int result = dfs(i, j, sol);
            a += (result * result);
          } else if (sol.equals("B")) {
            int result = dfs(i, j, sol);
            b += (result * result);
          }
        }
      }
    }

    System.out.println(a + " " + b);

  }

  static int dfs(int i, int j, String sol){
    int res = 1;

    for(int k = 0; k < 4; k++) {
      int x = i + dx[k];
      int y = j + dy[k];

      if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y]) continue;
      if(!soldierLocation[x][y].equals(sol)) continue;

      visited[x][y] = true;
      res += dfs(x, y, sol);
    }
    return res;
  }


  static void printSoldier(){
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        System.out.print(soldierLocation[i][j]);
      }
      System.out.println();
    }
  }
}
