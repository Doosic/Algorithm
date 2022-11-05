package 프로그래머스.옹알이;

import java.util.Scanner;


/*
    머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다.
    조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최
    대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다.
    문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는
    단어의 개수를 return하도록 solution 함수를 완성해주세요.

    제한사항
    - 1 ≤ babbling의 길이 ≤ 100
    - 1 ≤ babbling[i]의 길이 ≤ 15
    - babbling의 원소에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
    - 문자열은 알파벳 소문자로만 이루어져 있습니다.
*/
public class Main {

    private static final String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
    private static final String[] brotherSays = { "aya", "ye", "woo", "ma"};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(babbling, brotherSays));
    }

    /*
        1.replace 함수를 통해 조카가 말할 수 있는 단어들은 -로 바꿔준다.
        2.하이픈으로 대체하는 이유는 wyeoo 같은 경우 ye를 제거후 woo를 제거할 수 있기 때문에
          공백을 넣으면 제대로 파악할 수 없기 떄문이다.
        3.2중 반복문중 안쪽 반복문이 끝나고 해당 i번째의 단어가 -로 바뀌는 작업이 끝났을때
          남은 replaceAll을 이용해 하이픈을 전부 제거후 "" 값이 남았다면 카운팅.
     */
    private static int solution(String[] babbling, String[] brotherSays){
        int answer = 0;

        for(int i = 0; i < babbling.length; i++){
            for(int j = 0; j < brotherSays.length; j++){
                babbling[i] = babbling[i].replace(brotherSays[j], "-");
            }
            babbling[i] = babbling[i].replaceAll("-", "");
            if(babbling[i].equals("")){
                answer++;
            }
        }
        return answer;
    }


}
