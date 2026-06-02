package com.algorithm.greedy;

import java.util.Arrays;

public class FruitVendor {

    public int solution(int k, int m, int[] score) {
        int answer = 0;

        // 1. 사과 점수를 오름차순으로 정렬
        Arrays.sort(score);

        // 2. 가장 높은 점수의 사과부터 m개씩 묶기 위해 뒤에서부터 탐색
        // 정렬된 상태이므로 m개 묶음 중 첫 번째 사과가 해당 상자의 최저 점수가 됨
        for (int i = score.length - m; i >= 0; i -= m) {
            answer += score[i] * m;
        }

        return answer;
    }
}
