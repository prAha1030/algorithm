package com.algorithm.string;

public class BabyBabbling {

    public int solution(String[] babbling) {
        int answer = 0;

        for (String s : babbling) {
            // 1. 연속된 같은 발음이 포함되어 있다면 발음할 수 없음
            if (s.contains("ayaaya") || s.contains("yeye") || s.contains("woowoo") || s.contains("mama")) {
                continue;
            }

            // 2. 발음할 수 있는 단어들을 공백(" ") 처리
            // 빈 문자열("")로 치환하면 남은 앞뒤 문자열이 합쳐져 새로운 발음이 만들어질 수 있음
            s = s.replace("aya", " ");
            s = s.replace("ye", " ");
            s = s.replace("woo", " ");
            s = s.replace("ma", " ");

            // 3. 공백을 제거했을 때 아무것도 남지 않는다면 온전히 발음 가능한 단어
            if (s.replace(" ", "").isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}
