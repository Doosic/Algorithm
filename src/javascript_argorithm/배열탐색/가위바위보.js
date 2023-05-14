/**
 * 가위 바위 보
A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, 
B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다. 
가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
예를 들어 N=5이면

▣ 출력설명
각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
▣ 입력예제 1 
5
2 3 3 1 3
1 1 2 2 3
▣ 출력예제 1
A
B
A
B
D
 */

// 어떠한 경우를 따질때에는 어떠한 기준을 잡아서 분류를 하는지가 가장 중요하다!
const solution = (a, b, n) => {
  for (let i = 0; i < n; i++) {
    if (a[i] === b[i]) console.log("D");
    else if (a[i] - b[i] === 1) console.log("A");
    else if (b[i] - a[i] === 1) console.log("B");
    else if (a[i] - b[i] === 2 && a[i] < b[i]) console.log("A");
    else console.log("B");
  }
};

const n = 5;
const a = [2, 3, 3, 1, 3];
const b = [1, 1, 2, 2, 3];
console.log(solution(a, b, n));

const solutionSecond = (a, b, n) => {
  let answer = "";
  for (let i = 0; i < n; i++) {
    if (a[i] === b[i]) answer += "D" + " ";
    else if (a[i] === 1 && b[i] === 3) answer += "A" + " ";
    else if (a[i] === 2 && b[i] === 1) answer += "A" + " ";
    else if (a[i] === 3 && b[i] === 2) answer += "A" + " ";
    else answer += "B" + " ";
  }
  return answer;
};

const nSecond = 5;
const aSecond = [2, 3, 3, 1, 3];
const bSecond = [1, 1, 2, 2, 3];
console.log(solutionSecond(aSecond, bSecond, nSecond));
