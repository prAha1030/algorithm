package com.algorithm.math;

public class CokeExchange {

    public int solution(int a, int b, int n) {
        int totalNewColas = 0; // 상빈이가 총 받은 콜라 수

        // 보유 중인 빈 병 n이 마트에 주어야 하는 개수 a 이상일 때만 반복
        while (n >= a) {
            int newColas = (n / a) * b;  // 1. 이번에 새로 교환 받은 콜라 수
            int remainingBottles = n % a; // 2. 마트에 주지 못하고 남은 빈 병 수

            totalNewColas += newColas;    // 총 획득량에 더하기
            n = newColas + remainingBottles; // 3. 다음 턴에 쓸 수 있는 전체 빈 병 수 갱신
        }

        return totalNewColas;
    }
}
