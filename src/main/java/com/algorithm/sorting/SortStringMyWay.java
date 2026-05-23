package com.algorithm.sorting;

import java.util.Arrays;

public class SortStringMyWay {

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            // 1. n번째 글자가 서로 다르면, n번째 글자를 기준으로 오름차순 정렬
            if (s1.charAt(n) != s2.charAt(n)) {
                return Character.compare(s1.charAt(n), s2.charAt(n));
            }
            // 2. n번째 글자가 같으면, 단어 전체를 사전순으로 정렬
            return s1.compareTo(s2);
        });

        return strings;
    }
}
