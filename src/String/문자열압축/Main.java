package String.문자열압축;

/*
    설명

    알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
    문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
    단 반복횟수가 1인 경우 생략합니다.

    입력
    첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

    출력
    첫 줄에 압축된 문자열을 출력한다
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
        sc.close();
    }

    /*
        1.이전 값과 다음값을 비교한다.
        2.같다면 count +1, 다르다면 answer에 해당문자 추가
        3.만약 count가 1 이상이라면 해당문자 추가 및 count까지 추가
        4.주의할것은 문자열에 다음문자를 가져오기위해 +1 씩 하기 때문에
          마지막 for문에서 오류가 난다. 그렇기에 반복문 횟수는 하나 줄여주고
          마지막에 빈 문자열을 넣어서 길이를 1개 늘려준다.
    */
    private static String solution(String str) {
        String answer = "";
        str += " ";
        int count = 1;
        for (int i =0; i < str.length() - 1; i++){
            if(str.charAt(i) == str.charAt(i + 1)){
                count += 1;
            }else{
                answer += str.charAt(i);
                if(count > 1){
                    answer += count;
                    count = 1;
                }
            }
        }
        return answer;
    }
}
