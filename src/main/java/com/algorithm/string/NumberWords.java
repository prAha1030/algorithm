package com.algorithm.string;

public class NumberWords {

    public int solution(String s) {
        // 0부터 9까지의 영단어를 배열 인덱스와 매칭되도록 배열로 정의
        String[] words = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        // 배열을 순회하며 s에 포함된 영단어를 해당 인덱스(숫자) 문자열로 치환
        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], Integer.toString(i));
        }

        // 최종 치환된 문자열을 정수(int)로 변환하여 반환
        return Integer.parseInt(s);
    }
}
