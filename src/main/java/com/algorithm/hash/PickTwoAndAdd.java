package com.algorithm.hash;

import java.util.Arrays;
import java.util.HashSet;

public class PickTwoAndAdd {

    public int[] solution(int[] numbers) {
        // 1. 중복을 제거하기 위해 HashSet 사용
        HashSet<Integer> set = new HashSet<>();

        // 2. 서로 다른 인덱스의 두 수를 더하는 완전 탐색 (이중 반복문)
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // 3. Set을 배열로 변환
        int[] answer = new int[set.size()];
        int index = 0;
        for (int num : set) {
            answer[index++] = num;
        }

        // 4. 오름차순 정렬
        Arrays.sort(answer);

        return answer;
    }
}
