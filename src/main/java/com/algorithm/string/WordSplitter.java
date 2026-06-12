package com.algorithm.string;

public class WordSplitter {

    public int solution(String s) {
        int answer = 0;

        char x = s.charAt(0); // 1. 기준이 되는 첫 글자 설정
        int countX = 0;       // x의 빈도수
        int countOther = 0;   // x가 아닌 다른 글자의 빈도수

        for (int i = 0; i < s.length(); i++) {
            // 새롭게 분리된 이후라면 다음 첫 글자를 기준 x로 갱신
            if (countX == 0 && countOther == 0) {
                x = s.charAt(i);
            }

            // 2. 글자 대조 후 카운팅 증가
            if (s.charAt(i) == x) {
                countX++;
            } else {
                countOther++;
            }

            // 3. 처음으로 두 횟수가 같아지는 순간 문자열 분리
            if (countX == countOther) {
                answer++;
                countX = 0;     // 카운터 초기화
                countOther = 0; // 카운터 초기화
            }
        }

        // 4. 루프가 끝났는데 잔여 카운트가 남아있다면 마지막 덩어리 1개 추가
        if (countX != 0 || countOther != 0) {
            answer++;
        }

        return answer;
    }
}
