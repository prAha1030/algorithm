package com.algorithm.string;

public class DigitPartner {

    public String solution(String X, String Y) {
        // 1. X와 Y에 등장하는 0~9 숫자의 빈도를 저장할 배열 선언
        int[] countX = new int[10];
        int[] countY = new int[10];

        // 2. 각 문자열을 순회하며 숫자의 빈도 계산
        for (char c : X.toCharArray()) {
            countX[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            countY[c - '0']++;
        }

        // 3. 가장 큰 수를 만들어야 하므로 9부터 0까지 역순으로 공통 숫자 추출
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            // 두 숫자의 빈도 중 최솟값만큼 공통으로 짝지을 수 있음
            int matches = Math.min(countX[i], countY[i]);
            sb.append(String.valueOf(i).repeat(Math.max(0, matches)));
        }

        // 4. 예외 조건 처리
        String answer = sb.toString();

        // 공통 숫자가 전혀 없는 경우
        if (answer.isEmpty()) {
            return "-1";
        }
        // 가장 큰 숫자가 '0'으로 시작한다는 것은 전체가 0이라는 의미 ("000" -> "0")
        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}
