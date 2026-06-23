package com.algorithm.matrix;

public class RobotPuppyWalk {

    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();

        // 1. 시작 지점('S')의 좌표 구하기
        int r = 0;
        int c = 0;
        for (int i = 0; i < h; i++) {
            if (park[i].contains("S")) {
                r = i;
                c = park[i].indexOf("S");
                break;
            }
        }

        // 방향 지정을 위한 상하좌우 델타 배열 (N, S, W, E 순서)
        // 북(N)은 행 감소, 남(S)은 행 증가, 서(W)는 열 감소, 동(E)은 열 증가
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // 2. 이동 명령(routes) 순차 분석
        for (String route : routes) {
            String[] split = route.split(" ");
            String dir = split[0];
            int distance = Integer.parseInt(split[1]);

            // 방향에 매칭되는 델타 인덱스 결정
            int dirIdx = 0;
            switch (dir) {
                case "N" -> {
                }
                case "S" -> dirIdx = 1;
                case "W" -> dirIdx = 2;
                case "E" -> dirIdx = 3;
            }

            // 임시 좌표 설정 (검증 중 오류 발생 시 기존 좌표를 유지하기 위함)
            int nr = r;
            int nc = c;
            boolean isSuccess = true;

            // 3. 한 칸씩 직접 이동하며 안전한지 검사
            for (int i = 0; i < distance; i++) {
                nr += dr[dirIdx];
                nc += dc[dirIdx];

                // 경계선을 벗어났거나 장애물('X')을 만났다면 실패로 간주
                if (nr < 0 || nr >= h || nc < 0 || nc >= w || park[nr].charAt(nc) == 'X') {
                    isSuccess = false;
                    break;
                }
            }

            // 4. 모든 단계를 통과했을 때만 로봇 강아지의 실제 좌표를 갱신
            if (isSuccess) {
                r = nr;
                c = nc;
            }
        }

        return new int[]{r, c};
    }
}
