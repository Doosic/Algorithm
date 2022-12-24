/*
최솟값 구하기
7개의 수가 주어지면 그 숫자 중 가장 작은 수를 출력하는 프로그램을 작성하세요.
▣ 입력설명
첫 번째 줄에 7개의 수가 주어진다.
▣ 출력설명
첫 번째 줄에 가장 작은 값을 출력한다.
▣ 입력예제 1 
5 3 7 11 2 15 17
▣ 출력예제 1
2
*/

solution = (arr) => {
  let answer,
    min = Number.MAX_SAFE_INTEGER;

  // for문을 도는 방법도 있지만 forEach문을 사용해보고 싶었다.
  arr.forEach((element) => {
    min = Math.min(min, element);
  });
  answer = min;
  return answer;
};

const arr = [5, 3, 7, 11, 2, 15, 17];
console.log(solution(arr));
