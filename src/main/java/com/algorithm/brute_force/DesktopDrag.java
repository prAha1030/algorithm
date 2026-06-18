package com.algorithm.brute_force;

public class DesktopDrag {

    public int[] solution(String[] wallpaper) {
        // 1. 최소/최대 좌표 변수를 초기화
        // 최솟값은 가장 큰 값으로, 최댓값은 가장 작은 값으로 시작합니다.
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;

        int rows = wallpaper.length;
        int cols = wallpaper[0].length();

        // 2. 2차원 격자판을 완전 탐색하면서 파일('#')의 위치를 찾음
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (wallpaper[r].charAt(c) == '#') {
                    // 파일이 발견되면 4개 방향의 경계값을 갱신
                    minRow = Math.min(minRow, r);
                    minCol = Math.min(minCol, c);
                    maxRow = Math.max(maxRow, r);
                    maxCol = Math.max(maxCol, c);
                }
            }
        }

        // 3. 시작점은 [최소 행, 최소 열], 끝점은 [최대 행 + 1, 최대 열 + 1]
        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }
}
