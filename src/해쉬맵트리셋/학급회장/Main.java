package 해쉬맵트리셋.학급회장;

import java.util.HashMap;
import java.util.Scanner;

/*
    설명
    학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
    투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
    선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
    반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.

    입력
    첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
    두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.

    출력
    학급 회장으로 선택된 기호를 출력합니다.
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] line = sc.next().toCharArray();

        System.out.println(solution(n, line));
    }

    /*
        강사님 풀이방법
        getOrDefault() 라는 메서드를 사용하였다. 나는 있는지 몰랐는데 아쉽다.
        키값 x가 있다면 해당 값을 출력하고, 없다면 0을 출력하는데 첫 등장이기에 + 1을 해준다.
        그 뒤로 등장할때도 계속 카운팅을 해줘야 하기 떄문에 +1을 붙여두면 된다.

        정답 확인도 map.keySet() 으로 반복문을 돌려준다.
        다만 map.get(key) > map.getOrDefault(answer, 0) 라는 조건을 사용하여
        처음에는 answer이 아무 값으로 초기화도 안되어있기 때문에 처음 나온값(map.get(key))이 더 크다.
        그렇기에 answer은 첫번째 반복에서 무조건 처음 나온 값으로 초기화되고 그 이후에는
        다음에 나오는 값들과 계속 크기를 비교하여 가장큰 값을가진 key만 answer에 들어가게 해준다.

        강사와 완전 같은 풀이는 아니다. 응용버전이랄까나...?
     */
    private static char solution(int n, char[] arr) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Character key : map.keySet()) {
            if (map.get(key) > map.getOrDefault(answer, 0)) {
                answer = key;
            }
        }
        return answer;
    }

    /*
        해쉬맵을 이용한 풀이
        1.map.get(app[i]): 해당 알파뱃이 null 이라면, 아직 map에 값이 들어가지 않았다면
          map.put(arr[i], 1) 해당 알파뱃이 처음 등장한것이므로 1을 체크해둔다.
        2.첫 등장이 아니기 때문에 null이 아니라면 map.put() 을 사용하여
          map.put(arr[i](무언가의 알파뱃), map.get(arr[i])+1(해당 알파뱃의 저장되어 있던 값 + 1))
          값을 1씩 더해준다.
        3.map.keySet()메서드를 이용하여 반복문을 통해 key값을 하나씩 꺼내주고
        4.map.get(key)를 이용하여 가장 큰 벨류값을 가졌을때의 key값을 answer에 저장해주면 된다.
    */
/*    private static char solution(int n, char[] arr){
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){

            if(map.get(arr[i]) != null){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        int temp = 0;
        for(Character key : map.keySet()){
            if(map.get(key) > temp){
                answer = key;
                temp = map.get(key);
            }
        }
        return answer;
    }*/
}
