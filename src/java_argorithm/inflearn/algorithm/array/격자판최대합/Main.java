package java_argorithm.inflearn.algorithm.array.격자판최대합;

import java.util.Scanner;

/*
    설명
    5*5 격자판에 아래와 같이 숫자가 적혀있습니다.
    N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력합니다.
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nArr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                nArr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, nArr));
    }

    /*
        강사가 풀이한 방법
        핵심 풀이방법은 내가 풀이한것과 같기에 아래의 내가 풀이한 방법 주석참고.
    */
    private static int solution(int n, int[][] nArr){
        int answer = 0;
        int height = 0;
        int width = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                width += nArr[i][j];
                height += nArr[j][i];
            }
            answer = Math.max(answer, width);
            answer = Math.max(answer, height);
        }
        height = 0;
        width = 0;
        for(int i  = 0; i < n; i++){
            height += nArr[i][i];
            width += nArr[n - i - 1][n - i - 1];
        }

        answer = Math.max(answer, height);
        answer = Math.max(answer, width);
        return answer;
    }

    /*
        이 아래는 내가 풀이한 방법... 강사가 푼게 더 낫다.
        n은 5로 가정한다.
        1.이중 반복문으로 문제를 풀이한다.
        2.가로합은 [0][j] 0번째 배열안의 배열에 총합
        3.세로합은 [j][0] 각 배열의 0번째 값의 총합
        3.i와 j가 일치할때의 합을 구한다.(대각선)
        4.첫 라인 대각선 i == j , 끝라인 대각선 (n - i - 1) == (n - j - 1) n은 줄어들어야 한다.
        5.끝라인 대각선 구할때 n은 -1을 해줘야한다. 입력받은 n은 배열의 범위를 벗어나기 때문이다.
          ex) n이 5일시 0 ~ 4 그러나 배열에 n번을 가져오려하면 5번 인덱스는 없기에 에러발생
    */
//    private static int solution(int n, int[][] nArr){
//        int[] height = new int[n];
//        int[] width = new int[n];
//        int[] diagonal = new int[2];
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                width[i] += nArr[i][j];
//                height[i] += nArr[j][i];
//                if(i == j){
//                    diagonal[0] += nArr[i][j];
//                }
//                int ni = n - i - 1;
//                int nj = n - j - 1;
//                if(ni == nj){
//                    diagonal[1] += nArr[ni][nj];
//                }
//            }
//        }
//
//        int answer = 0;
//        answer = maxNumber(width);
//        answer = Math.max(answer, maxNumber(height));
//        answer = Math.max(answer, maxNumber(diagonal));
//        return answer;
//    }
//
//    private static int maxNumber(int[] nums){
//        int maxNum = 0;
//        for(int i = 0; i < nums.length; i++){
//            maxNum = Math.max(maxNum, nums[i]);
//        }
//        return maxNum;
//    }

}
