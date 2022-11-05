package 자바알고리즘문제풀이.String.문장속단어;
/*
    설명
    한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
    문장속의 각 단어는 공백으로 구분됩니다.

    입력
    첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.

    출력
    첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
    단어를 답으로 합니다.
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));

    }
    /*
        indexOf(" ")를 이용하여 공백의 위치를 찾는다.
        while 문을 이용하여 계속 순회하는데 indexOf(" ")는
        해당 값을 찾지 못했을때에는 -1을 리턴하는것을 이용

        pos는 반복문을 돌며 " "이 존재하는 index의 값을
        리턴해주는데 substring으로 (0, 공백index); 이용해 공백전의 단어까지
        나오게 해준다.
        ex) it is a super string
            int pos(2) = str.indexOf(" ")
            it = str.substring(0, pos(2));
    */
    private static String solution(String str){
        String answer = "";
        int m = Integer.MIN_VALUE;
        int pos = Integer.MIN_VALUE;
        while((pos = str.indexOf(" ")) != -1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            // len >= m 가 아닌 ">" 를 사용하는 이유는 맨 앞쪽에 위치한 단어를 답으로 하기 때문에
            // 같은 길이를 가진게 나온다면 뒤에것으로 뒤바뀐다.
            if(len > m){
                m = len;
                answer = tmp;
            }
            // 앞서 확인한 문자를 잘라준다. substring 0부터 자르는게 아닌 1부터 자른다.
            str = str.substring(pos + 1);
        }
        // 마지막 단어는 공백이 없어 확인을 못하기에 남은 단어가 더 크다면 답이다.
        if(str.length() > m){
            answer = str;
        }
        String text = "it is a live";
        return answer;
    }


    /*
        1.공백을 기준으로 배열에 담아 반복문을 돌며 길이가 긴것을 구한다.
        2.m에는 0이 담겨있고 len 에는 반복문을 돌며 문자의 길이가 들어간다.
        3.m보다 len 이 크다면 m에는 len 을 담아 길이가 긴 문자를 담아주고 answer 에 해당 문자를 넣는다.
        4.반복문을 계속 돌며 m보다 len 이 큰것을 찾고 다 마친후에는 결과값을 준다.
    */
    private static String solution2(String str){
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for (String x : s){
            int len = x.length();
            if (len > m){
                m = len;
                answer = x;
            }
        }
        return answer;
    }
}
