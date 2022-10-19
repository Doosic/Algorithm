package Array.보이는학생;

import java.util.Scanner;

/*
    설명
    선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
    선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)

    입력
    첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.

    출력
    선생님이 볼 수 있는 최대학생수를 출력한다.
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++){
            nArr[i] = sc.nextInt();
        }
        System.out.println(solution(nArr));
        /*
            1.맨앞의 학생의 키를 담아둔다.
            2.answer은 맨앞의 학생은 무조건 보인다는 가정하에 1을 default값으로 가진다.
            2.이전 학생보다 키가 크다면 해당 학생의 키를 담아두고 count += 1
         */
    }

    private static int solution(int[] nArr){
        int answer = 1;
        int student = nArr[0];
        for (int i = 1; i < nArr.length; i++){
            if(student < nArr[i]){
                student = nArr[i];
                answer += 1;
            }
        }
        return answer;
    }

}
