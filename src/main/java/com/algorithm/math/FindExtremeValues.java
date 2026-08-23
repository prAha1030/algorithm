package com.algorithm.math;

public class FindExtremeValues {

    public String solution(String s) {
        // 1. 공백 딜리미터를 기준으로 문자열을 잘라 숫자 풀 생성
        String[] numbers = s.split(" ");

        // 2. 음수 대응형 안전 초기화: 첫 요소를 기본 비교군으로 선점
        int firstNum = Integer.parseInt(numbers[0]);
        int min = firstNum;
        int max = firstNum;

        // 3. 인덱스 1번부터 끝까지 순회하며 O(N) 최적 대소 갱신
        for (int i = 1; i < numbers.length; i++) {
            int current = Integer.parseInt(numbers[i]);

            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }
        }

        // 4. 요구 규격 포맷에 맞추어 결합 문자열 출력
        return min + " " + max;
    }
}
