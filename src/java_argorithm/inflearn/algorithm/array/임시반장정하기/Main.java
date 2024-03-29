package java_argorithm.inflearn.algorithm.array.임시반장정하기;

import java.util.Scanner;

/*
    설명
    김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
    김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
    그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
    그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
    예를 들어 학생 수가 5명일 때의 표를 살펴보자.

    위 경우에 4번 학생을 보면 3번 학생과 2학년 때 같은 반이었고, 3번 학생 및 5번 학생과 3학년 때 같은 반이었으며,
    2번 학생과는 4학년 때 같은 반이었음을 알 수 있다. 그러므로 이 학급에서 4번 학생과 한번이라도
    같은 반이었던 사람은 2번 학생, 3번 학생과 5번 학생으로 모두 3명이다.
    이 예에서 4번 학생이 전체 학생 중에서 같은 반이었던 학생 수가 제일 많으므로 임시 반장이 된다.
    각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.

    입력
    첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
    둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
    주어지는 정수는 모두 1 이상 9 이하의 정수이다.


    출력
    첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
    단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][6];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 5; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[][] arr){
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j =1; j <= n; j++){
                for(int k = 1; k <= 5; k++){
                    if(arr[i][k] == arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max){
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }




    /*
        내가 풀이한거.... runtimeError가 계속 나온다. 이유는 모르겠다.
        그런데 다른 사람들도 runtimeError가 나오는 사람이 많다고 한다.
        무슨 예제를 돌린후 runtimeError 가 나왔는지라도 알면 내꺼에서 돌려본탠데....
        문제 풀이를 보니 배열에 사용하는건 1~5번인데 0번을 만들어두었다.
        문제에 5개의 정수가 빈칸 하나를 사이에 두고 주어진다. 의 빈칸이 필요한것 같다.

        1.각 학생의 학년별 반을 먼저 체크한다. 즉, [j][i]의 형태다. 세로로 체크
        2.1번 학생과 나머지 학생의 반이 같은지 체크, 2번 학생과 나머지 학생의 반이 같은지 체크.....~
        3.자기 자신과 같은지는 체크하면 안되기에 j != k 가 다를때만 체크한다.
        4.자기 자신의 반과 같은 학생들을 모두 0으로 체킹해주고, 자신도 같은 반이였던 학생을
          찾은것이기에 0으로 바꾼다. 다만 k 반복문을 돌던중 변경하게되면 같은반이였던 학생이 여러명일경우
          본인이 바로 0으로 변하기에 찾을수 없다.
        5.플레그 변수를 만들어 같은반이 였던 학생이 한명이라도 나온다면 k 반복문이 끝난후 변경해준다.
        6.끝으로 본인이 0이라면 반복문을 돌 필요는 없다.
        7.0이 가장 많은 학생이 반장이된다. 다만 여러명이 같다면 가장 작은 번호만 출력한다.

    */
//    private static int solution(int n, int[][] arr){
//        int answer = 0;
//        for(int i = 0; i < 5; i++){
//            for(int j = 0; j < n; j++){
//                if(arr[j][i] != 0){
//                boolean flag = false;
//                    for(int k = 0; k < n; k++){
//                        if(j != k && arr[j][i] == arr[k][i]){
//                            flag = true;
//                            arr[k][i] = 0;
//                        }
//                    }
//                    if(flag){
//                        arr[j][i] = 0;
//                    }
//                }
//            }
//        }
//
//        int[] check = new int[n];
//        for(int i = 0; i < 5; i++){
//            for(int j = 0; j < n; j++){
//                if(arr[i][j] == 0){
//                    check[i] += 1;
//                }
//            }
//            if(check[i] > answer){
//                answer = i + 1;
//            }
//        }
//        return answer;
//    }
}
