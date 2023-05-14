package java_argorithm.inflearn.algorithm.string.중복문자제거;

import java.util.Scanner;

/*
    설명
    소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
    중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.

    입력
    첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.

    출력
    첫 줄에 중복문자가 제거된 문자열을 출력합니다.
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
        sc.close();
    }

    /*
        입력: ksekkset
        단어 : index 번호 : 자신이 처음 등장한 위치
        k : 0 : 0
        s : 1 : 1
        e : 2 : 2
        k : 3 : 0
        k : 4 : 0
        s : 5 : 1
        e : 6 : 2
        숫자만추출 : 7 : 7

        indexOf(): 특정 문자나 문자열이 앞에서부터 처음 발견되는 인덱스를 반환한다.
        index 번호와 자신이 처음 등장한 위치가 같다면 answer 에 문자 추가
        만약 처음 발견된게 아니라면 제낀다.
    */
    private static String solution(String str){
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }
}
