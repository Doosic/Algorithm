package java_argorithm.inflearn.algorithm.array.멘토링;

import java.util.Arrays;
import java.util.Scanner;

/*
    설명
    현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
    멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
    선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
    만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
    M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.

    입력
    첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
    두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
    만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.

    출력
    첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[][] arr){
        int answer = 0;
        for(int i = 1; i <=n; i++){
            for(int j = 1; j<=n; j++){
                int cnt = 0;
                for(int k=0; k<m; k++){
                    int pi = 0;
                    int pj = 0;
                    for(int s = 0; s < n; s++){
                        if(arr[k][s] == i) pi = s;
                        if(arr[k][s] == j) pj = s;
                    }
                    // pi 멘토, pj 멘티. 멘토가 멘티보다 등수가 앞섰을때 카운팅
                    if(pi < pj) cnt++;
                }
                //
                if(cnt==m){
                    answer++;
                }
            }
        }

        return answer;
    }

    /*
        풀면서도 이렇게 푸는게 맞나 싶었지만 다른 방법이 떠오르지 않았다.
        내가 풀이한 방법은 반 학생수의 모든 경우에 수를 2중 배열로 만들어 놓고
        각 학생의 경우에 수를 하나씩 줄여나가는 방법으로 풀이를 했다.

        [1=1] [1=2] [1=3] [1=4]
        [2=1] [2=2] [2=3] [2=4]
        [3=1] [3=2] [3=3] [3=4]
        [4=1] [4=2] [4=3] [4=4]

        n = 학생수
        i = 가장 바깥쪽 반복문 변수
        j = 중간 반복문 변수
        k = 가장 안쪽 반복문 변수

        1.학생들의 수대로 모든 경우에 수를 포함한 이중배열[n][n]을 만든다.
        2.arr[i][j]는 1등학생부터 마지막 학생까지 순차로 확인한다. ex) 3, 4, 1, 2
        3.순차적으로 확인하며 arr[i][k]에 표식을 남겨 경우에 수를 제거해준다.
        4.이때 1등은 본인만 체크하면되고, 2등은 1등과 본인, 3등은 1등과 2등과 본인, 4등은 앞의 모두를 체크해야 하므로
          앞의 숫자를 체크하다 자기 자신과 같은 숫자가 발견되면 break를 해준다.
        5.참고로 x와 y에 -1씩 해주는 이유는 그냥 사용하면 subArr의 범위를 벗어난다. 배열은 0부터 시작한다는걸 잊지 말자.
        6.참고로 2번이나 다른 방법으로도 풀고도 복잡하다고 느끼는 풀이다.
        7.문제는 다 풀렸지만 뭔가 좋지 않은 방법으로 푼게 분명하다.
    */
/*    private static int solution(int n, int m, int[][] arr){
        int answer = 0;
        int[][] subArr = new int[n][n];
        int x = 0;
        int y = 0;

        for(int i = 0; i < m; i++){
           for(int j = 0; j < n; j++){

               x = arr[i][j] - 1;
               for(int k = 0; k < n; k++){
                   y = arr[i][k] - 1;
                    subArr[x][y] = 1;
                   if(x == (y)) break;
               }
           }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(subArr[i][j] == 0){
                    answer ++;
                }
            }
        }
        return answer;
    }*/
}

/*
    private static int solution(int n, int m, int[][] arr){
        int answer = 0;
        int[][] subArr = new int[n][n];
        int x = 0;
        int y = 0;

        for(int i = 0; i < m; i++){
            for(int j = n-1; j >= 0; j--){

                x = arr[i][j] - 1;
                for(int k = j; k >= 0; k--){
                    y = arr[i][k] - 1;
                    subArr[x][y] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(subArr[i][j] == 0){
                    answer ++;
                }
            }
        }
        return answer;
    }
 */
