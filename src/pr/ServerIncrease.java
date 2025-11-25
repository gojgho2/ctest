package pr;

import java.util.*;
import java.util.stream.Collectors;

public class ServerIncrease {

  // 최대 이용자수 m
  // 서버한대가 운영가능한 시간 k

  public static void main(String[] args) {

    int[] players = new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1};
    int m = 1;
    int k = 1;
    List<Integer> collect = Arrays.stream(players).
        boxed()
        .collect(Collectors.toList());
    System.out.println(collect);

    int res = solution(players, m, k);

    System.out.println(res);

  }

  public static int solution(int[] players, int m, int k) {
    int result = 0;
    int[] record = new int[100];

    for (int i = 0; i < players.length; i++) {

      int player = players[i];

      if(player == 0) continue;

      int serverIncrease = getServerIncrease(player, record, m, k, i);
      result+=serverIncrease;
    }


    return result;
  }

  public static int getServerIncrease(int player, int[] record, int m, int k, int i) {
    int expectedIncrease = player / m;

    int currentIncrease = record[i];

    int res = Math.max((expectedIncrease - currentIncrease), 0);

    for(int s = i; s < i+k; s++) {
      record[s] += res;
    }

    return res;
  }

}
