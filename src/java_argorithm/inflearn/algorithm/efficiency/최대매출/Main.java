package java_argorithm.inflearn.algorithm.efficiency.최대매출;

import java.util.Scanner;

/*
    설명
    현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
    만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
    12 1511 20 2510 20 19 13 15
    연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
    여러분이 현수를 도와주세요.

    입력
    첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
    두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

    출력
    첫 줄에 최대 매출액을 출력합니다.
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }

       private static int solution(int n, int k, int[] arr){
        int answer = 0;
        int sum = 0;

        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        answer = sum;

        for(int i = k; i < n-k; i++){
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }


    /*
       아래는 강의를 들으며 어떤 알고리즘인지까지만 설명을 듣고
       푼것이다. 해당 알고리즘에 대해 설명을 간단하게 들어보니 쉬운 문제였다.
       그러나 해당 알고리즘을 몰랐을때는 풀지 못했었다. 슬라이딩 윈도우 알고리즘을 잘 기억하자!

   */
 /*   private static int solution(int n, int k, int[] arr){
        int answer = 0;
        int sum = 0;

        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        answer = sum;

        for(int i = k; i < n-k; i++){
            sum = (sum + arr[i]) - arr[i - k];
            answer = sum > answer ? sum : answer;
        }
        return answer;
    }*/

    /*
        왠지 문제가 쉽다 했더니
        그냥 반복문으로 풀면 타임오버다.
        슬라이딩 윈도우라는 알고리즘으로 풀이하여야 한다고 한다.
        아래와 같이 풀면 안된다...
    */
/*    private static int solution(int n, int k, int[] arr){
        int answer = 0;
        int sum = 0;
        int len = n - k;

        for(int i = 0; i < len; i++){
            for(int j = 0; j < k; j++){
                sum += arr[i+j];
            }
            answer = Math.max(answer, sum);
            sum = 0;
        }

        return answer;
    }*/
}
