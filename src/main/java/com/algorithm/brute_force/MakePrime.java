package com.algorithm.brute_force;

public class MakePrime {

    public int solution(int[] nums) {
        int answer = 0;

        // 1. 3개의 숫자를 중복 없이 고르는 3중 반복문 (완전 탐색)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    // 2. 세 수의 합이 소수이면 카운트 증가
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    // 3. 소수 판별 함수 (O(√N) 최적화 기법)
    private boolean isPrime(int num) {
        if (num < 2) return false;

        // 제곱근까지만 나누어떨어지는지 확인
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
