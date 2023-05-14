package java_argorithm.inflearn.algorithm.string.회문문자열;

import java.util.Scanner;

/*
    설명

    앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
    문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
    단 회문을 검사할 때 대소문자를 구분하지 않습니다.

    입력
    첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.


    예시입력
    gooG
    예시출력
    YES
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution2(str));
    }

    private static String solution(String str) {
        int len = str.length();
        // 전부 대문자 또는 소문자로 변환하여 비교한다.
        str = str.toUpperCase();
        // 양쪽 끝이 같으면 되므로 길이의 반절만 돌면된다. 홀수일시 가운데는 비교하지 않아도된다. length / 2
        for (int i = 0; i < (len / 2); i++){
            // 한번이라도 일치하지않을시 NO를 return
            if(str.charAt(i) != str.charAt((str.length() - 1) - i)){
                return "NO";
            }
        }
        return "YES";
    };

    private static String solution2(String str) {
        // 빌더의 reverse 를 이용하여 뒤집어서 비교한다.
        String builder = new StringBuilder(str).reverse().toString();
        // equalsIgnoreCase 슷 사용하여 대소문자 무시
        if(str.equalsIgnoreCase(builder)){
            return "YES";
        }
        return "NO";
    };
}
