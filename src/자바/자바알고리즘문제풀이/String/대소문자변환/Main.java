package 자바알고리즘문제풀이.String.대소문자변환;

/*
    설명
    대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.

    입력
    첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
    문자열은 영어 알파벳으로만 구성되어 있습니다.

    출력
    첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
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
        아스키 코드표를 이용해 풀이해도된다.
        아스키 코드표 65 ~ 90 대문자, 97 ~ 122 소문자
        소문자 -32 는 대문자이다.
    */
    private static String solution(String str) {
        String answer = "";
        // 1.x 가 97과 같거나 크고, 122와 같거나 작다 즉, 소문자이다.
        // 2.소문자 최소값 97-32 = 대문자 최소값인 65
        // 3.(x-32)를 그대로 해주면 int 로 출력되기때문에 형변환을 해줘야 한다.
        for (char x : str.toCharArray()) {
            if (x >= 97 && x <= 122) {
                answer += (char)(x-32);
            } else {
                answer += (char)(x+32);
            }
        }
        return answer;
    }
}
