package com.algorithm.math;

public class KnightWeaponary {

    public int solution(int number, int limit, int power) {
        int totalWeight = 0;

        // 1번부터 number번 기사까지 순회
        for (int i = 1; i <= number; i++) {
            // 1. i번 기사의 약수 개수 구하기
            int count = getDivisorCount(i);

            // 2. 제한수치(limit)를 초과했는지 검사하여 최종 공격력 결정
            if (count > limit) {
                totalWeight += power;
            } else {
                totalWeight += count;
            }
        }

        return totalWeight;
    }

    // O(√N) 성능으로 약수의 개수를 구하는 최적화 메서드
    private int getDivisorCount(int n) {
        int count = 0;

        // 제곱근까지만 루프를 돌며 약수를 찾음
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    count += 1; // 제곱근일 경우 1개만 카운트 (예: 4의 제곱근 2)
                } else {
                    count += 2; // 대칭되는 약수가 존재하므로 2개 카운트
                }
            }
        }

        return count;
    }
}
