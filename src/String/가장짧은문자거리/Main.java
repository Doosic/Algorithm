package String.가장짧은문자거리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
    설명
    한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

    입력
    첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
    문자열의 길이는 100을 넘지 않는다.

    출력
    첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

    입력
    teachermode e
    etadetaddde e
    출력
    1 0 1 2 1 0 1 2 2 1 0
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);
        for (int x : solution(s, t)){
            System.out.print(x + " ");
        }
    }

    /*
        반복문을 돌며 오른쪽 t를 기준으로 1씩 증가시킨다. t를 만나면 다시 0부터 증가
        다시 반복문을 돌며 왼쪽 t를 기준으로 1씩 증가시킨다. 다만 해당 위치에 들어있는
        값의 크기가 더 클 경우에만 증가하고 같거나 작다면 그대로 둔다.
        t = e
        s = t e a c h e r m o d e
            0 1 2 3 4 5 6 7 8 9 10

            0 0 1 2 3 0 1 2 3 4 0 -> 오른쪽 기준 증가
            1 0 1 2 1 0 1 2 2 1 0 -> 왼쪽 기준 증가 다만 기존 숫자보다 미만일시
    */
    private static int[] solution(String s, char t){
        int[] answer = new int[s.length()];
        int point = 100;
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t){
                point = 0;
                answer[i] = point;
            }else{
                point++;
                answer[i] = point;
            }
        }
        // for문 i의 값을 s.length()로 줄수 있었다는걸 잊고있었다...
        point = 100;
        for (int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == t){
                point = 0;
            }else{
                point++;
                answer[i] = Math.min(answer[i], point);
            }
        }
        return answer;
    }
}
