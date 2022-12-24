package 자바알고리즘문제풀이.String.문자찾기;

/*
    * 설명
    한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
    대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.

    * 입력
    첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
    문자열은 영어 알파벳으로만 구성되어 있습니다.

    * 출력
    첫 줄에 해당 문자의 개수를 출력한다.

    * 예시 입력 1
      Computercooler

    * 예시 출력 1
      2

*/

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // 1.입력받은 문자중 첫번째 문자를 가져온다.
        char c = sc.next().charAt(0);
        System.out.println(searchCharacter(str, c));
        sc.close();
    }

    private static int searchCharacter(String str, char t){
        int answer = 0;
        // 2.대소문자 구분없이 가져와야 하기 때문에 UpperCase 를 이용한다.
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        // 3.forEach 문을 사용하는데 그냥 문자열을 넣어주면 char 로 받을 수 없기에
        //   toCharArray() 메서드를 통해 문자 배열로 바꿔준다.
        for (char x : str.toCharArray()){
            if (x == t){
                answer ++;
            }
        }
        return answer;
    }
}
