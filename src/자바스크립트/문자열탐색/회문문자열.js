/**
 * 회문 문자열
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력
하는 프로그램을 작성하세요.
단 회문을 검사할 때 대소문자를 구분하지 않습니다.
▣ 입력설명
첫 줄에 정수 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다. 
▣ 출력설명
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
▣ 입력예제 1 
gooG
▣ 출력예제 1
YES
 */

// 문자열을 반으로 쪼개서 하는 풀이방법!
const solution = (str) => {
  let answer = "YES";
  str = str.toUpperCase();
  let strLen = str.length;
  let len = Math.floor(strLen / 2);
  for (let i = 0; i < len; i++) {
    if (str[i] !== str[strLen - 1 - i]) {
      answer = "NO";
    }
  }
  return answer;
};

const str = "gooG";
console.log(solution(str));

// 문자열을 뒤집어서 비교하는 방법
const solutionSub = (str) => {
  let answer = "YES";
  str = str.toLowerCase();
  if (str.split("").reverse().join("") !== str) return "NO";
  return answer;
};

console.log(solution(str));
