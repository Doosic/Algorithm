/**
 * 중복문자제거
소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하
세요.
제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
▣ 입력설명
첫 줄에 문자열이 입력됩니다.
▣ 출력설명
첫 줄에 중복문자가 제거된 문자열을 출력합니다.
▣ 입력예제 1 
ksekkset
▣ 출력예제 1
kset
 */

// Set을 이용한 풀이
const solution = (str) => {
  let answer = "";
  let setMap = new Set();
  for (let x of str) {
    setMap.add(x);
  }

  for (let x of setMap) {
    answer += x;
  }
  return answer;
};

const str = "ksekkset";
console.log(solution(str));

// indexOf: 첫 문자가 등장하는 위치
// 반복문을 돌며 자기 자신이 처음 등장한 위치와 반복문의 횟수가 일치하는 지점이 첫 등장이다.
const solutionIndexOf = (str) => {
  let answer = "";
  for (let i = 0; i < str.length; i++) {
    if (i === str.indexOf(str[i])) answer += str[i];
  }
  return answer;
};

console.log(solutionIndexOf(str));

// indexOf 를 사용하여 같은 문자가 몇개 등장하느닞도 파악할 수 있다.
const solutionIndexOfChars = (str) => {
  let answer = 0;
  let pos = str.indexOf("k");
  while (pos != -1) {
    answer++;
    pos = str.indexOf("k", pos + 1);
  }
  return answer;
};
