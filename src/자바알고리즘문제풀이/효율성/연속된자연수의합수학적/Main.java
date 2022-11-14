package 자바알고리즘문제풀이.효율성.연속된자연수의합수학적;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));

    }

    private static int solution(int n){
        int answer = 0;
        int cnt = 1;
        n--;
        while(n > 0){
            cnt++;
            n = n-cnt;
            if(n%cnt == 0) answer++;
        }

        return answer;
    }
}
