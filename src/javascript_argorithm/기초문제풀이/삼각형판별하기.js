/*
삼각형 판별하기
길이가 서로 다른 A, B, C 세 개의 막대 길이가 주어지면 이 세 막대로 삼각형을 만들 수 있
으면 “YES"를 출력하고, 만들 수 없으면 ”NO"를 출력한다.
▣ 입력설명
첫 번째 줄에 100이하의 서로 다른 A, B, C 막대의 길이가 주어진다.
▣ 출력설명
첫 번째 줄에 “YES", "NO"를 출력한다.
▣ 입력예제 1 
6 7 11
▣ 출력예제 1
YES
▣ 입력예제 1 
13 33 17
▣ 출력예제 1
NO
*/

// 삼각형의 조건! 아래쪽에 오는 길이가 가장 길어야 하고 위에 올 두 길이의 합이 아래쪽의 길이보다 커야한다.

solution = (a, b, c) => {
  let answer = "YES";
  let max;
  let sum = a + b + c;
  if (a > b) max = a;
  else max = b;
  if (c > max) max = c;

  // 작거나 같다면 No
  if (max >= sum - max) answer = "NO";
  return answer;
};

console.log(solution(13, 33, 17));
