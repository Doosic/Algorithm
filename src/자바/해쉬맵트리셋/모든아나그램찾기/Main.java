package 해쉬맵트리셋.모든아나그램찾기;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(solution(s, t));
    }

    /*
        강사꺼를 보고 풀이하였다.
        이번에는 놓친것이 있었다.
        입력값이 중복되지 않는 값만 들어올거라는 생각을 하였던게 패착이였다.
        그렇기 때문에 개수를 카운팅 해줘야한다.
        중복을 생각하지 못하고 그냥 쭉 밀고 올랐다가 계속 틀렸다.
        중복되는 값이 있다는걸 생각하고 각 키값의 갯수를 카운팅 해줘야 함을 잊지 말자.
    */
    private static int solution(String s, String t){
        int answer = 0;
        HashMap<Character, Integer> mapT = new HashMap<>();
        HashMap<Character, Integer> mapS = new HashMap<>();
        for(char x : t.toCharArray()){
            mapT.put(x, mapT.getOrDefault(x, 0)+1);
        }

        int l = t.length() -1;
        for(int i = 0; i < l; i++){
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0)+1);
        }

        int lt = 0;
        for(int rt = l; rt < s.length(); rt++){
            mapS.put(s.charAt(rt), mapS.getOrDefault(s.charAt(rt), 0)+1);
            if(mapS.equals(mapT)){
                answer++;
            }

            mapS.put(s.charAt(lt), mapS.get(s.charAt(lt))-1);
            if(mapS.get(s.charAt(lt)) == 0){
                mapS.remove(s.charAt(lt));
            }
            lt++;
        }
        return answer;
    }
}
