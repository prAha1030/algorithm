package com.algorithm.math;

public class BinaryTransform {

    public int[] solution(String s) {
        int transformCount = 0; // 이진 변환 횟수
        int zeroCount = 0;      // 제거된 총 0의 개수

        // s가 "1"이 될 때까지 무한 반복
        while (!s.equals("1")) {
            int originalLength = s.length();
            int oneCount = 0;

            // 1. 문자열을 순회하며 '1'의 개수만 카운팅
            for (int i = 0; i < originalLength; i++) {
                if (s.charAt(i) == '1') {
                    oneCount++;
                }
            }

            // 2. 전체 길이에서 1의 개수를 빼서 제거된 0의 개수 누적
            zeroCount += (originalLength - oneCount);

            // 3. 남은 1의 개수(oneCount)를 2진법 문자열로 변환하여 s를 갱신
            s = Integer.toBinaryString(oneCount);

            // 이진 변환 횟수 증가
            transformCount++;
        }

        return new int[]{transformCount, zeroCount};
    }
}
