package com.algorithm.string;

public class JadenCase {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        // 문장의 첫 글자는 무조건 대문자 대상이므로 true로 시작
        boolean isFirst = true;

        // 문자열을 한 글자씩 순회하며 처리
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                // 공백을 만나면 그대로 결과에 추가하고, 다음 글자가 첫 글자가 되도록 플래그 설정
                answer.append(ch);
                isFirst = true;
            } else {
                // 공백이 아닌 문자를 만났을 때
                if (isFirst) {
                    // 첫 글자라면 대문자로 변환하여 추가
                    answer.append(Character.toUpperCase(ch));
                    isFirst = false; // 첫 글자가 지나갔으므로 플래그 해제
                } else {
                    // 첫 글자가 아니라면 소문자로 변환하여 추가
                    answer.append(Character.toLowerCase(ch));
                }
            }
        }

        return answer.toString();
    }
}
