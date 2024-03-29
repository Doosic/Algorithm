package java_argorithm.inflearn.algorithm.array.피보나치수열;

import java.util.Scanner;

/*
    설명
    1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
    2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

    입력
    첫 줄에 총 항수 N(3<=N<=45)이 입력된다.

    출력
    첫 줄에 피보나치 수열을 출력합니다
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int x : solution(n)){
            System.out.print(x + " ");
        }
    }

    // 만약 배열을 쓰지말고 for 문 만을 사용해야 할 때는 temp 를 사용하며 풀이하면 된다.
    // 앞뒤 변경하면서 풀이
    private static int[] solution(int n){
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i = 2; i < n; i++){
            answer[i] = answer[i - 2] + answer[i - 1];
        }
        return answer;
    }
}
