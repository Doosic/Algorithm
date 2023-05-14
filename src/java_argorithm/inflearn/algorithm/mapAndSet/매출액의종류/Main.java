package java_argorithm.inflearn.algorithm.mapAndSet.매출액의종류;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    설명
    현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
    각 구간별로 구하라고 했습니다.
    만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
    20 12 20 10 23 17 10
    각 연속 4일간의 구간의 매출종류는
    첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
    두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
    세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
    네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
    N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
    매출액의 종류를 출력하는 프로그램을 작성하세요.

    입력
    첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
    두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

    출력
    첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for(int x : solution(n, k, arr)){
            System.out.print(x + " ");
        }
    }

    /*
        - 슬라이딩 윈도우와 해쉬맵을 사용해서 풀이한다.
        1.매출액 구간만큼 HashMap에 담아주고 중복된 값이 나올시 value를 +1씩 올려준다.
          default값은 getOrDefault(?, 0)+1 이다.
        2.4번까지 체크한 후에는 해당 map의 사이즈를 answer에 담아준다.
        3.lt한칸 증가 rt한칸 증가한다. 이전 lt값의 value를 -1해주고 해당 값이 0이 된다면
          map에서 제거한다. 그리고 사이즈를 체크해주면 된다. 무한반복.
        4.사이즈를 체크해주는건 rt가 k-1이상일때 부터 체크해주기 시작하면 된다.
    */
    private static ArrayList<Integer> solution(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int lt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int rt = 0; rt < n; rt++){
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            if(rt >= k-1){
                answer.add(map.size());
                if(map.get(arr[lt]) > 1){
                    map.put(arr[lt], map.get(arr[lt]) -1);
                    lt++;
                }else if(map.get(arr[lt]) == 1){
                    map.remove(arr[lt]);
                    lt++;
                }
            }
        }

        return answer;
    }
}
