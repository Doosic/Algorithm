/**
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 
문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시
오. 단 반복횟수가 1인 경우 생략합니다.
▣ 입력설명
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
▣ 출력설명
첫 줄에 압축된 문자열을 출력한다.
▣ 입력예제 1 
KKHSSSSSSSE
▣ 출력예제 1
K2HS7E
*/

// 해당 str[i]의 데이터와 다음 str[i+1] 데이터를 비교하여 같다면 count++
// 다르다면 count가 1일경우에는 str[i]를 answer에 더해주고 2이상일 경우 str[i] + count를 해준다.
// 자바에서는 인덱스 아웃 오브 바운스 에러가 나지만 자바스크립트에서는 undefind가 나와서 간단하게 처리가 가능하다.
const solution = (str) => {
  let answer = "";
  let count = 1;

  for (let i = 0; i < str.length; i++) {
    if (str[i] === str[i + 1]) {
      count++;
    } else {
      answer += count === 1 ? str[i] : str[i] + count;
      count = 1;
    }
  }
  return answer;
};

const str = "KKHSSSSSSSE";
console.log(solution(str));
