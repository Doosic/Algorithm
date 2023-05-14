// forEach, map, filter, reduce
// function forEach(predicate, thisArg)

const a = [10, 11, 12, 13, 14, 15];
// a.forEach(
//   (v, i) => {
//     // 만들어진 인자의 콜백함수의 내부이다.
//     console.log(v, i, this);
//   },
//   [1, 2]
// );

// 원본 배열과 길이가 같다. 조건에 만족하지 못하는 회차에는 undefined가 들어있다.
let answer = a.map(
  (v, i) => {
    if (v % 2 == 0) return v * v;
  },
  [1, 2]
);
console.log(answer);
