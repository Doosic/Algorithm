package 자바알고리즘문제풀이.효율성.연속부분수열;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr){
        int answer = 0;
        int lt = 0;
        int sum = 0;
        for(int rt = 0; rt < n; rt++){
            sum+=arr[rt]; // 증가하고
            if(sum == m){ // 더하고
                answer++; // 확인 lt ~ rt 를 더한값 확인
            }
            while(sum >= m){
                sum -= arr[lt++];
                if(sum == m){
                    answer++;
                }
            }
        }

        return answer;
    }

    /*
        내 풀이방법 숫자 1이 적어서 계쏙 실패...
    private static int solution(int n, int m, int[] arr){
        int answer = 0;
        int p1 = 0;
        int p2 = 0;
        int sum = arr[0];

        while(n-1 > p2){
            if(sum == m){
                answer ++;
                sum -= arr[p1++];
                sum += arr[++p2];
            }else if(sum > m){
                sum -= arr[p1++];
            }else{
                sum += arr[++p2];
            }
        }
        return answer;
    }*/
}
