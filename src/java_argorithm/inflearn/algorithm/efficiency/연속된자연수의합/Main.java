package java_argorithm.inflearn.algorithm.efficiency.연속된자연수의합;

import java.util.Arrays;
import java.util.Scanner;

/*
    설명
    N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
    만약 N=15이면
    7+8=15
    4+5+6=15
    1+2+3+4+5=15
    와 같이 총 3가지의 경우가 존재한다.

    입력
    첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.

    출력
    첫 줄에 총 경우수를 출력합니다
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }

    private static int solution(int n){
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int m = n/2+1;
        int[] arr = new int[m];
        for(int i = 0; i < m; i++){
            arr[i] = i+1;
        }
        for(int rt = 0; rt < m; rt++){
            sum += arr[rt];
            if(sum == n) answer++;
            while(sum >= n){
                sum -= arr[lt++];
                if(sum == n) answer++;
            }
        }

        return answer;
    }

    /*
        아래는 내가 한 풀이다.

        연속된 자연수의 합이 포인트다.
        연속된 자연수의 합이되려면 (n/2)+1의 숫자부터 가능하다.
        ex) (15/2)+1 = 8이며, 만약 이 값이 넘을경우 8 + 9 = 17과 같이 되어 연속된 자연수의 합이 n을 넘어선다.

        - 투 포인터 알고리즘으로 해결한다.
        - n은 15이고 (n/2)+1 = 8이라고 가정한다.
        1.범위 1~8 안에 속한 각각의 숫자들이 연속된 숫자들로 합하여 n이될 가능성을 체크해준다.
        2.배열에 1~8 까지의 숫자를 담아준다.
        3.포인터 두개를 만들어준다.
        4.최상위 숫자8부터 하나씩 숫자를 더해준다.
          ex) sum = arr[p1] + arr[p2] 이때에 p1=5, p2=4 이면서 숫자의 합 즉,sum이 n보다 작다면
          --p2를 하여 숫자를 더해가는 방식이다.
        5.n과 같은 숫자가 나온다면 answer++를 해줘 경우에 수를 체크해준다.
        6.큰값과 같은값일경우에는 더 이상 해당 숫자에서는 나올 값이 없으므로
          p1의 값을 하나 빼 다음 숫자를 검사하고 p2는 p1-1로 값을 초기화 해준다.
        7.마지막으로 p2 == 0 일때는 마지막 숫자가되어 while문의 조건을 false로 만들어 종료됨으로 sum이 n과 같은지 마지막으로
          확인하며 마무리 해준다.
     */
    /*
    Main에 강사 풀이를 넣어뒀는데 인자값 arr은 1~(n/2+1)까지의 값들로 초기화된 배열이 들어온다

    private static int solution(int n, int[] arr){
        int answer = 0;
        int p1 = n/2;
        int p2 = (n/2)-1;

        int sum = arr[p1] + arr[p2];
        while(p2 > 0){
            if(sum > n){
                p1--;
                p2 = p1-1;
                sum = arr[p1] + arr[p2];
            }
            else if (sum < n){
                sum += arr[--p2];
                if(p2 == 0){
                    if (sum == n) answer ++;
                }
            }else{
                answer++;
                p1--;
                p2 = p1-1;
                sum = arr[p1] + arr[p2];
            }
        }

        return answer;
    }*/
}
