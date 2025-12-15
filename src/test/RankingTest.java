package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class RankingTest {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());


    int MY_RANKING = Integer.parseInt(st.nextToken());

    int[] arr = new int[N+1];

    for(int i=1; i<=N; i++) {
      arr[i] = i;
    }

    List<Integer> result = getResult(arr, MY_RANKING);
    System.out.println(result);

  }

  static List<Integer> getResult(int[] arr, int myRanking) {
    int total = arr.length - 1; // 실제 랭킹은 1 ~ total (0번은 안 씀)
    final int windowSize = 3;

    // 기본: 나를 가운데에 두려고 시도
    int start = myRanking - windowSize / 2; // 3이면 1칸 왼쪽
    int end = myRanking + windowSize / 2;   // 3이면 1칸 오른쪽

    // 왼쪽이 1보다 작으면 오른쪽으로 밀어줌
    if (start < 1) {
      end += (1 - start);
      start = 1;
    }

    // 오른쪽이 total 을 넘으면 왼쪽으로 밀어줌
    if (end > total) {
      start -= (end - total);
      end = total;
    }


    System.out.println("total = " + total);
    System.out.println("start = " + start + ", end = " + end);

    // Arrays.stream의 두 번째 인자는 "포함", 세 번째 인자는 "미포함"이므로 end+1
    return Arrays.stream(arr, start, end + 1)
        .boxed()
        .toList();
  }
}
