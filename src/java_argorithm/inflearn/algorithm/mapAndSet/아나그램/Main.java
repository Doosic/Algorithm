package java_argorithm.inflearn.algorithm.mapAndSet.아나그램;

import java.util.HashMap;
import java.util.Scanner;

/*
    설명
    Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
    예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
    알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
    길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.

    입력
    첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
    단어의 길이는 100을 넘지 않습니다.

    출력
    두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.

    예시 입력1
    AbaAeCe
    baeeACA

    Yes

    예시 입력2
    abaCC
    Caaab

    No


*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstStr = sc.next();
        String secondStr = sc.next();
        System.out.println(solution(firstStr, secondStr));
    }

    /*
        내가 풀이한 방법
        1.두 단어들은 길이가 같다. 그러므로 같은 길이의 반복문에 돌려도된다.
        2.두 단어들을 Hash맵에 담아 해당 키값이 몇번 나왔는지 숫자를 저장해준다. ex) a : 3, c : 2, E : 1
        3.두 단어가 순서는 다르지만 구성이 완전 같다면 한쪽의 키값을 뽑아가며 반복문을 돌렸을때에 두 HashMap의 value는
          모두 같게 나와야 한다.
        4.그러므로 한번이라도 다르게 나온다면 answer = "NO" 로 값을 초기화 해준다.
        5.answer에 default값은 "YES"로 한다.
    */
    private static String solution(String first, String second){
        String answer = "YES";
        HashMap<Character, Integer> fMap = new HashMap();
        HashMap<Character, Integer> sMap = new HashMap();
        char[] fArr = first.toCharArray();
        char[] sArr = second.toCharArray();

        for(int i = 0; i < first.length(); i++){
            fMap.put(fArr[i], fMap.getOrDefault(fArr[i], 0)+1);
            sMap.put(sArr[i], sMap.getOrDefault(sArr[i], 0)+1);
        }

        for(Character x : fMap.keySet()){
            if(sMap.get(x) != fMap.get(x)){
                answer = "NO";
            }
        }

        return answer;
    }
}
