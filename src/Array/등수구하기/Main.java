package Array.등수구하기;

import java.util.Scanner;

/*
    설명
    N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
    같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
    즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

    입력
    첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.

    출력
    입력된 순서대로 등수를 출력한다.

    입력
    5
    87 89 92 100 76

    예시 출력
    4 3 2 1 5

 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArr = new int[n];

        for(int i = 0; i < n; i++){
            nArr[i] = sc.nextInt();
        }

        for(int x : solution(nArr, n)){
            System.out.print(x + " ");
        }
    }

    /*
        이중 for문을 이용하는 풀이는 쉬웠다. 그러나 더 좋은방법은 없을까?
        1.0등은 없기 때문에 첫 번째 반복문이 시작될때는 항상 1을 넣어준다.
        2.같은 점수일때는 등수를 같게 표기하기 때문에 < 또는 > 를 사용한다.
        3.i보다 큰 j값이 나올때마다 등수를 하나씩 더해줘 뒤로 밀리게한다.
    */
    private static int[] solution(int[] nArr, int n){
        int[] answer = new int[n];

        for(int i = 0; i < n; i++){
            answer[i] = 1;
            for(int j = 0; j < n; j++){
                if(nArr[i] < nArr[j]){
                    answer[i] += 1;
                }
            }
        }
        return answer;
    }
}
