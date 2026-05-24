package com.algorithm.sorting;

import java.util.Arrays;

public class KthNumber {

    public int[] solution(int[] array, int[][] commands) {
        // 결과를 저장할 배열 생성 (명령어 개수만큼)
        int[] answer = new int[commands.length];

        for (int c = 0; c < commands.length; c++) {
            // commands의 각 원소는 [i, j, k] 형태
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];

            // 1. array의 i번째부터 j번째까지 자르기 (인덱스는 0부터 시작하므로 i-1부터 j까지)
            int[] slicedArray = Arrays.copyOfRange(array, i - 1, j);

            // 2. 잘라낸 배열 오름차순 정렬
            Arrays.sort(slicedArray);

            // 3. 정렬된 배열의 k번째 수 추출 (인덱스로는 k-1)
            answer[c] = slicedArray[k - 1];
        }

        return answer;
    }
}
