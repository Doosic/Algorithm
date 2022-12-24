package 자바알고리즘문제풀이.Array.큰수출력하기;

import java.util.*;

/*
    설명
    N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
    (첫 번째 수는 무조건 출력한다)

    입력
    첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.

    출력
    자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
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
    }

    private static ArrayList<Integer> solution(int n, int[] nArr){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nArr[0]);
        for(int i = 1; i < n; i++){
            if(nArr[i - 1] < nArr[i]){
                list.add(nArr[i]);
            }
        }
            return list;
    }
}
