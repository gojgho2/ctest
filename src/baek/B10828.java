package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10828 {

//  정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//
//  명령은 총 다섯 가지이다.
//
//  push X: 정수 X를 스택에 넣는 연산이다.
//      pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//  size: 스택에 들어있는 정수의 개수를 출력한다.
//      empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
//  top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.


  /**
   * INPUT
   *
   * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
   */

  public static void main(String[] args) throws IOException {

    // 버퍼 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    // 스택을 배열로 직접 구현 (최대 N)

    int[] stack = new int[N];
    int size = 0; // 스택에 있는 원소 갯수 top 인덱스 역할

    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch(command) {
        case "push":
          int x = Integer.parseInt(st.nextToken());
          stack[size] = x;
          size++;
          break;
        case "pop":
          if(size == 0) {
            sb.append(-1).append("\n");
          } else {
            sb.append(stack[size - 1]).append("\n");
            size--;
          }
          break;
        case "size":
          sb.append(size).append("\n");
          break;
        case "empty":
          sb.append(size == 0 ? 1 : 0).append("\n");
          break;
        case "top":
          if (size == 0) {
            sb.append(-1).append("\n");
          } else {
            sb.append(stack[size -1]).append("\n");
          }
          break;
      }

    }

    System.out.println(sb);

  }
}
