package java_argorithm.inflearn.algorithm.array.가위바위보;

import java.util.Scanner;

/*
    설명
    A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
    가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
    예를 들어 N=5이면
    두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.

    입력
    첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
    두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
    세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.

    출력
    각 줄에 각 회의 승자를 출력합니다. 비겼을 경우에는 D를 출력합니다.
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            b[i] = sc.nextInt();
        }
        for(String temp : solution(n, a, b)){
            System.out.println(temp);
        }
    }

    /*
        한 사람을 기준으로 두는것이 풀이하기 좋다.
     */
    private static String[] solution(int n, int[] a, int[] b){
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            if(a[i] == b[i]){
                answer[i] = "D";
            }else{
                if(a[i] - b[i] == 2 || b[i] - a[i] == 2){
                    answer[i] = a[i] == 1? "A" : "B";
                }else{
                    answer[i] = a[i] > b[i] ? "A" : "B";
                }
            }
        }
        return answer;
    }
}
