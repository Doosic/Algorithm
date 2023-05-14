/**
 * N개의 자연수가 입력되면 각 자연수의 자릿수의 합을 구하고, 그 합이 최대인 자연수를 출력
하는 프로그램을 작성하세요. 자릿수의 합이 같은 경우 원래 숫자가 큰 숫자를 답으로 합니다. 
만약 235 와 1234가 동시에 답이 될 수 있다면 1234를 답으로 출력해야 합니다.
▣ 입력설명
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
각 자연수의 크기는 10,000,000를 넘지 않는다.
▣ 출력설명
자릿수의 합이 최대인 자연수를 출력한다.
▣ 입력예제 1 
7
128 460 603 40 521 137 123
▣ 출력예제 1
137
 */

// 1.각 x번째 숫자 자리수들에 합을 먼저 어떻게 구할지 생각해보자.
// 2.while문을 돌며 tmp가 0이되는 순간 종료 0 === falsy(false)와 같다.
// 3.127%10 = 7 을 sum에 담아주고 tmp/10을 통해 1의 자리수를 제거해 12로 만든다. 를 반복
// 4.sum이 max보다 클때 max의 값을 sum의 값으로 초기화 해주고 answer에 x를 담아준다.(가장 큰수)
// 5.sum과 max가 같은 경우에는 현재값 x가 answer보다 더 크다면 answer을 x로 담아준다.
const solution = (n, arr) => {
  let answer = Number.MIN_SAFE_INTEGER;
  let max = Number.MIN_SAFE_INTEGER;

  for (let x of arr) {
    let sum = 0;
    let tmp = x;

    while (tmp) {
      sum += tmp % 10;
      tmp = Math.floor(tmp / 10);
    }

    if (sum > max) {
      max = sum;
      answer = x;
    } else if (sum === max) {
      if (x > answer) answer = x;
    }
  }

  return answer;
};

const arr = [128, 460, 603, 40, 521, 137, 123];
const n = 7;
console.log(solution(n, arr));
