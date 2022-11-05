package 자바알고리즘문제풀이.String.팰린드롬;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }

    private static String solution(String str){
        // 대문자로 변경후, replaceAll 정규식을 통해 영어 대문자를 제외하고 전부 제거
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String builder = new StringBuilder(str).reverse().toString();
        // 비교
        if (str.equals(builder)){
            return "YES";
        }
        return "NO";
    }
}

