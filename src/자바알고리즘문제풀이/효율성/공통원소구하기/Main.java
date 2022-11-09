package 자바알고리즘문제풀이.효율성.공통원소구하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/*
    설명
    A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.

    입력
    첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
    두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
    세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
    네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
    각 집합의 원소는 1,000,000,000이하의 자연수입니다.

    출력
    두 집합의 공통원소를 오름차순 정렬하여 출력합니다.

    해당 문제는 손코딩까지 하라고 할 정도로 쉬운 문제라고 한다. 나는 못풀었는데 ㄷㄷ; 잘 외워두고 복습해야겠다.
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

    /*
        - 투 포인터 알고리즘을 이용한다.
        1.해당 배열들을 정렬해준다.(추후에는 정렬 알고리즘을 이용하여 정렬후 해보자)
        2.양쪽 배열을 비교할때 숫자가 작은쪽의 포인터를 증가시켜준다.
          정렬된 값이기에 큰쪽에서는 작은쪽과 같은 값이 나올수 없기 때문이다.
        3.같은 값이 나온다면 포인터의 값을 둘다 증가시켜준다.
          같은값을 찾았기에 해당 숫자들은 더 이상 비교할 필요가 없다.
        4.위와 같은 조건들로 계속 비교하다가 한쪽의 배열길이와 포인터의 값이 같아진 순간
          반복문은 종료한다. 한쪽 배열을 다 훓은 후에는 더 이상 같은 값은 찾을수 없기 때문이다.
    */
    private static ArrayList<Integer> solution(int n, int m, int[] nrr, int[] mrr){
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(nrr);
        Arrays.sort(mrr);
        int p1 = 0;
        int p2 = 0;

        while (p1<n && p2<m){
            if(nrr[p1] < mrr[p2]) p1++;
            else if(nrr[p1] > mrr[p2]) p2++;
            else {
                answer.add(nrr[p1++]);
                p2++;
            }
        }

        return answer;
    }
}
