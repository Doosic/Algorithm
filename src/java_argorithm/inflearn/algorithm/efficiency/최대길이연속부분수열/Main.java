package java_argorithm.inflearn.algorithm.efficiency.최대길이연속부분수열;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }

    private static int solution(int n, int k, int[] arr){
        int answer = 0;
        int lt = 0;
        int check = 0;

        for(int rt = 0; rt < n; rt++){
            if(arr[rt] == 0){
                check++;
            }

                while (check > k){
                    if(arr[lt] == 0){
                        check--;
                    }
                    lt++;
                }
            answer = Math.max((rt-lt)+1, answer);
        }
        return answer;
    }


   /* private static int solution(int n, int k, int[] arr){
        int answer = 0;
        int lt = 0;
        int check = 0;

        for(int rt = 0; rt < n; rt++){
            if(arr[rt] == 0){
                check++;
            }

            if(check > k){
                answer = Math.max((rt-1)-lt, answer);
                while (check > k){
                    lt++;
                    if(arr[lt] == 0){
                        check--;
                    }
                }
            }
        }
        return answer;
    }*/
}
