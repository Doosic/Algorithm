package java_argorithm.inflearn.algorithm.array.봉우리;

import java.util.Scanner;

/*
    설명
    지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
    각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
    격자의 가장자리는 0으로 초기화 되었다고 가정한다.
    만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.

    입력
    첫 줄에 자연수 N이 주어진다.(2<=N<=50)
    두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

    출력
    봉우리의 개수를 출력하세요.

    예제 입력
    5
    5 3 7 2 3
    3 7 1 6 1
    7 2 5 3 4
    4 3 6 4 1
    8 7 3 5 2

    출력
    10

 */
public class Main {

    private static int solution(int n, int[][] arr){
        // dx = {왼쪽, 0, 오른쪽, 0}
        // dy = {0, 아래, 0, 위}
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                boolean flag = true;
                for(int k = 0; k < 4; k++){
                    // 상,하,좌,우 검사
                    // 1.격자판의 범위 바깥을 조사하면 안되기 때문에 nx가 0보다 크고 n보다 작을때
                    // 2.ny가 0보다 크고 n보다 작을때 즉, 배열의 범위 바깥을 나가지 않은 상태일때
                    // nx가 -1이라면 arr[-1][0] 이 되는꼴이다. 그 반대로 arr[5][0]도 마찬가지다 배열의 범위는 0~4까지다.
                    // ny도 마찬가지. nx가 좌우로 벗어나지 않게, ny상,하로 벗어나지 않게 조건 체크
                    // 모든 조건을 통과 후 현재 값보다 상,하,좌,우의 값중 하나가 더 크다면 false
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                        if(arr[nx][ny] >= arr[i][j]){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag){
                    answer ++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));



    /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() + 2;
        int[][] arr = new int[n][n];

        내가 풀이했던 방법!
        1.가장 바깥쪽은 0으로 둘러야한다.
        2.상,하 0으로 두르는법: i == 0, i == n -1 같을때에 0을 넣는다.
        3.좌,우 0으로 두르는법: j == 0, j == n -1 같을때에 0을 넣는다.
    */
//    for(int i = 0; i < n; i++){
//        for(int j = 0; j < n; j++){
//            if(i == 0 || i == (n-1) || j == 0 || j == (n-1)){
//                arr[i][j] = 0;
//            }else{
//                arr[i][j] = sc.nextInt();
//            }
//        }
//    }
//        System.out.println(solution(n, arr));
    }


    /*
        내가 풀이했던 방법!
        1.i == 0, i == n-1 일때는 상,하,좌,우를 검사하지 않는다.
        2.j == 0, j == n-1 일때는 상,하,좌,우를 검사하지 않는다.
        3.위 조건을 만족후 현재 위치에서 i-1(상), i+1(하), j-1(좌), j+1(우) 를 검사하여 조건 만족시 봉우리 체크
     */
//    private static int solution(int n, int[][] arr){
//        int answer = 0;
//        int currentNum, up, down, left, right = 0;
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                if(i != 0 && i != (n-1) && j != 0 && j != (n-1)){
//                    currentNum = arr[i][j];
//                    up = arr[i-1][j];
//                    down = arr[i+1][j];
//                    left = arr[i][j-1];
//                    right = arr[i][j+1];
//                    if(currentNum > up && currentNum > down && currentNum > left && currentNum > right){
//                        answer += 1;
//                    }
//                }
//            }
//        }
//        return answer;
//    }

}
