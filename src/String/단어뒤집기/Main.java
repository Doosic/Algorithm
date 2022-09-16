package String.단어뒤집기;

/*
    설명
    N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.

    입력
    첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
    두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.

    출력
    N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strArr = new String[n];
        for(int i = 0; i < n; i++){
            strArr[i] = sc.next();
        }
        for (String x : solution(strArr, n)){
            System.out.println(x);
        }
        sc.close();
    }

    private static ArrayList<String> solution(String[] str, int n) {
        ArrayList<String>  answer = new ArrayList<>();
        // 문자의 끝과 끝을 교환하는 방법이다. 글자가 홀수라 5개라면 가운대는 교환할 필요가 없다.
        for(String x : str){
            char[] s = x.toCharArray();
            int lt = 0;
            // length()는 0부터가 아닌 1부터 Count
            int rt = x.length() -1;
            while(lt < rt){
                // 1.가장 작은것을 tmp변수에 담는다.
                char tmp = s[lt];
                // 2.배열의 길이는 5이다. 배열 0번에 5번의것을 담는다.
                s[lt] = s[rt];
                // 3.배열 5번에 가장 작은것을 담아뒀던 tmp를 넣는다. 끝과 끝 교환 완료
                s[rt] = tmp;
                // 4.lt++ 은 0 -> 1로 다음단어, rt-- 는 5 -> 4로 이전 단어
                lt++;
                rt--;
                // 0 -> 1 , 5 -> 4
                // 1 -> 2 , 4 -> 3
                // 2 -> 3 , 3 -> 2 는 lt(3) < rt(2) = false 이므로 반복문 종료
            }
            // valueOf는 Static으로 선언된 클래스 메서드이다.
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }


    /*
        - Builder 사용하여 뒤집기 및 Builder를 사용하는 이유(이유는 한번더 공부하기)
        String은 String끼리 더하거나 replace를 사용하면
        새로운 객체가 생성된다. 불변객체인 String은 그 자체의 값을 변경할 수 없기에
        새로 만들어 대입하는 것이다. 그러나 StringBuilder는 객체를 수정하고 뭔가를 만드는
        것을 처음만든 객체 하나만을 가지고 한다. 그래서 객체를 계속 만들지 않아도되서 메모리가 가벼워진다.
    */
    private static ArrayList<String> solution2(String[] str, int n) {
        ArrayList<String>  answer = new ArrayList<>();
        // StringBuilder 객체를 만들고, String을 뒤집고, toString으로 builder에서 string으로 변환
        for(String x : str){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }
}
