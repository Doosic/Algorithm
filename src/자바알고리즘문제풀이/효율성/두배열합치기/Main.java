package 자바알고리즘문제풀이.효율성.두배열합치기;

import java.util.ArrayList;
import java.util.Scanner;

/*
    설명
    오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.


    입력
    첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
    두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
    세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
    네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
    각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.


    출력
    오름차순으로 정렬된 배열을 출력합니다.

    쉬운 문제지만 만약 이걸 문제로 낸다면 Two pointer 알고리즘을 써서 풀수 있냐고 물어보는것이다.
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nrr = new int[n];
        for(int i = 0; i < n; i++){
            nrr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] mrr = new int[m];
        for(int i = 0; i < m; i++){
            mrr[i] = sc.nextInt();
        }

        for(int x : solution(n, m, nrr, mrr)){
            System.out.print(x + " ");
        }
    }

    private static ArrayList<Integer> solution(int n, int m, int[] nrr, int[] mrr){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        /*
            while문은 true일때 반복된다.
            p1과 p2 둘중 어느 하나라도 pointer가 범위 밖으로 벗어난다면 하나의 배열에 정렬은 끝난것이다.
            때문에 p1이 n보다 작아야하고 p2는 m보다 작아야한다는 조건으로 while문이 반복된다.

            둘의 값을 비교하여 정렬할때 한쪽 배열이 비는순간 반복문을 중지하고
            나머지 값은 answer에 넣어준다. 비교 정렬이 끝난순간 남은건 큰 값들이기 때문이다.

            연산자는 후위 증감연산자를 사용해야 첫 값이 0이 들어간다
            i = 0
            ++i = 1
            i++ = 0 이다.
        */
        while (p1<n && p2<m) {
           if(nrr[p1] < mrr[p2]) answer.add(nrr[p1++]);
           else answer.add(mrr[p2++]);
        }
        while (p1<n) answer.add(nrr[p1++]);
        while (p2<m) answer.add(mrr[p2++]);

        return answer;
    }
}
