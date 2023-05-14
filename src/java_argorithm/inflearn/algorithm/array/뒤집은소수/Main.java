package java_argorithm.inflearn.algorithm.array.뒤집은소수;

import java.util.ArrayList;
import java.util.Scanner;

/*
    설명
    N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
    예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
    첫 자리부터의 연속된 0은 무시한다.

    입력
    첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
    각 자연수의 크기는 100,000를 넘지 않는다.

    출력
    첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArr = new int[n];
        for(int i = 0; i < n; i++){
            nArr[i] = sc.nextInt();
        }

        for(int x : solution(n, nArr)){
            System.out.print(x + " ");
        }



        /*
            - 내가 했던 풀이방법
            for(int i = 0; i < n; i++){
                nArr[i] = Integer.parseInt(new StringBuilder(sc.next()).reverse().toString());
                maxNum = nArr[i] > maxNum? nArr[i] : maxNum;
            }

            for(Object x : solution(maxNum, nArr)){
                System.out.print(x + " ");
            }
        */
    }

    /*
        - 내가 했던 풀이방법.
        1.입력받은 숫자를 바로 뒤집어 숫자로 변환후 값을 넣어준다.
        2.아레토스테네스 체 공식을 사용하기 위해 max값을 담아준다.
        3.숫자 2 ~ maxNumber 까지의 숫자 사이의 소수를 구해준다.
        4.앞서 입력받은 숫자와 소수가 담긴 리스트를 비교하여 입력은받은 숫자가 소수라면 새 list에 담아준다.

        private static ArrayList solution(int maxNum, int[] inputNums){
            int[] primes = new int[maxNum + 1];
            ArrayList prime = new ArrayList();
            ArrayList answer = new ArrayList();
            for(int i = 2; i <= maxNum; i++){
                if(primes[i] == 0){
                    prime.add(i);
                    for(int j = 0; j <= maxNum; j = j + i){
                        primes[j] = 1;
                    }
                }
            }

            for(int i = 0; i < inputNums.length; i++){
                for(int j = 0; j < prime.size(); j++){
                    if(prime.get(j).equals(inputNums[i])){
                        answer.add(inputNums[i]);
                    }
                }
            }
            return answer;
        }
    */

    /*
        - 강사 풀이방법

    */
    private static boolean isPrime(int num){
        // 1은 소수가 아니다.
        if(num == 1) return false;
        // 한번이라도 나눠지면 약수가 존재하기에 소수가 아니다.
        for(int i = 2; i < num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }


     private static ArrayList<Integer> solution(int n , int[] nArr){
        ArrayList<Integer> answer = new ArrayList<>();
         for(int i = 0; i < n; i++){
             int tmp = nArr[i];
             int res = 0;
             while (tmp > 0){
                 // 123일시 3이 t에 들어간다.
                 int t = tmp % 10;
                 // (0 * 10) + 3 = 3
                 res = res * 10+t;
                 // 123 / 10 = 12 해서 3, 30+2, 320+1 이된다.
                 tmp = tmp/10;
             }
             // 소수인지 판단.
             if(isPrime(res)){
                 answer.add(res);
             }
         }
         return answer;
     }
}
