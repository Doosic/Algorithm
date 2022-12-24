package 자바알고리즘문제풀이.String.특정문자뒤집기;

import java.util.Scanner;

/*
    설명
    영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
    특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.

    입력
    첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.

    출력
    첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
        sc.close();
    }

    /*
        lt = left, rt = right
        1.문자열이라면 앞뒤를 교환하고, 특수문자라면 교환하지 않는다.
        2.Character.isAlphabetic() 을 사용해 알파뱃인지 검사한다.
        3.알파뱃이 아닐시 건너뛰어야 하기 때문에 lt++ 또는 rt-- 를 해준다.
        4.둘다 알파뱃이라면 자리교환
        5.자바알고리즘문제풀이.String 으로 반환해야하기에 자바알고리즘문제풀이.String.valueOf를 통해 변환
    */
    private static String solution(String str){
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() -1;
        while(lt < rt){
            if(!Character.isAlphabetic(s[lt])){
                lt++;
            }else if(!Character.isAlphabetic(s[rt])){
                rt--;
            }else{
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(s);
    }
}
