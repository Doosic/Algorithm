package Array.소수에라토스테네스체;

import java.util.Scanner;

/*
    설명
    자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
    만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.

    입력
    첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.

    출력
    첫 줄에 소수의 개수를 출력합니다.

    소수를 구하는 방법은 에라토스테네스체가 가장 빠르다.
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    /*
        1.마지막 숫자까지 비교해야하기 때문에 <= 으로 비교한다.
        2.배열에 숫자를담아 20까지 체크하려면 + 1을 해줘야한다. 0번부터 시작이기 때문
        3.i는 2부터 시작한다. 0과 1은 소수의 대상이 아니기 때문이다.
        4.배열을 지나치며 값에 0이 들어있다면 체크하고 해당 값의 배수위치에 1을 담아둔다.
        5.0이 들어있는 곳들이 나올때만 체크해주고 그 해당 숫자의 배수들을 1로 채킹해주면 소수가 파악이 된다.
    */
    private static int solution(int n){
        int answer = 0;
        int[] ch = new int[n + 1];
        for(int i = 2; i <= n; i++){
            if(ch[i] == 0){
                answer++;
                // j는 i의 배수로 돌며 약수를 파악해야한다.
                for(int j = i; j <= n; j = j+i){
                    ch[j] = 1;
                }
            }
        }
        return answer;
    }
}
