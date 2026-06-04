package com.algorithm.greedy;

public class WallPainter {

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int maxPaintedIndex = 0; // 현재까지 페인트가 칠해진 가장 먼 구역의 인덱스

        for (int i = 0; i < section.length; i++) {
            // 현재 구역이 이미 이전에 칠해진 범위(maxPaintedIndex)보다 뒤에 있다면
            if (section[i] > maxPaintedIndex) {
                answer++; // 롤러질 횟수 추가
                // 현재 위치부터 m미터만큼 칠해지므로, 칠해진 마지막 구역 갱신
                // (section[i] 구역을 포함하여 m개를 칠하므로 section[i] + m - 1)
                maxPaintedIndex = section[i] + m - 1;
            }
        }

        return answer;
    }
}
