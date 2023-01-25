/**
숫자만 추출
문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만
듭니다. 
만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205
이 됩니다. 
추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
▣ 입력설명
첫 줄에 숫자가 썩인 문자열이 주어집니다. 문자열의 길이는 50을 넘지 않습니다.
▣ 출력설명
첫 줄에 자연수를 출력합니다.
▣ 입력예제 1 
g0en2T0s8eSoft
▣ 출력예제 1
208
*/

const solution = (str, numberObj) => {
  let answer = "";
  for (let x of str) {
    if (numberObj[x] === true) {
      answer += x;
    }
  }
  if (answer.charAt(0) === "0") answer = answer.substring(1);
  return answer;
};

const str = "g0en2T0s8eSoft";
const numberObj = {
  0: true,
  1: true,
  2: true,
  3: true,
  4: true,
  5: true,
  6: true,
  7: true,
  8: true,
  9: true,
};
console.log(solution(str, numberObj));

// isNaN(): 숫자가 아니라면 true
const solutionSecond = (str) => {
  let answer = "";
  for (let x of str) {
    if (!isNaN(x)) answer += x;
  }
  return parseInt(answer);
};
