package pr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServerIncreaseS1 {

  // 최대 이용자수 m
  // 서버한대가 운영가능한 시간 k


  public static void main(String[] args) {

    int result = 0;
    int[] players = new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1};
    int m = 1;
    int k = 1;

    int[] record = new int[24 + k];


    for (int i=0; i<players.length; i++) {
      int player = players[i];

      if(player == 0) continue;



      result += getServerIncrease(player, record, m, k, i);
    }

    System.out.println(result);
  }

  private static int getServerIncrease(int player, int[] record, int m, int k, int i) {
    int expectedIncrease = player / m;

    int currentQuantity = record[i];

    int res = Math.max((expectedIncrease - currentQuantity), 0);

    for(int s = i; s < i + k; s++) {
      record[s] += res;
    }
    return res;
  }

}
