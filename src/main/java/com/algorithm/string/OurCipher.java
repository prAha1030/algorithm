package com.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class OurCipher {

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        // 1. skip해야 할 문자들을 빠르게 조회하기 위해 List(또는 Set)에 보관
        List<Character> skipList = new ArrayList<>();
        for (char ch : skip.toCharArray()) {
            skipList.add(ch);
        }

        // 2. 'a'부터 'z'까지 중 skip에 포함되지 않는 유효한 알파벳만 순서대로 추출
        List<Character> validAlphabet = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!skipList.contains(ch)) {
                validAlphabet.add(ch);
            }
        }

        // 유효한 알파벳 풀(Pool)의 전체 크기 계산
        int poolSize = validAlphabet.size();

        // 3. 문자열 s의 각 글자를 유효 알파벳 풀 안에서 index만큼 이동
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // 현재 문자가 유효 풀의 몇 번째 인덱스에 있는지 탐색
            int currentIndex = validAlphabet.indexOf(current);

            // index만큼 뒤로 이동하되, 풀의 크기를 벗어나면 처음으로 순환하도록 나머지 연산(%) 적용
            int targetIndex = (currentIndex + index) % poolSize;

            // 변환된 문자를 결과에 추가
            answer.append(validAlphabet.get(targetIndex));
        }

        return answer.toString();
    }
}
