package com.algorithm.greedy;

import java.util.Arrays;

public class GymSuit {

    public int solution(int n, int[] lost, int[] reserve) {
        // 1. 인덱스 매칭을 편하게 하기 위해 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 체육수업을 들을 수 있는 초기 학생 수 (전체 - 도난당한 학생)
        int answer = n - lost.length;

        // 2. [함정 해결] 여벌이 있는데 도난당한 학생은 빌려줄 수도 없고, 빌릴 필요도 없음 (자기 거 입음)
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++; // 수업 들을 수 있는 인원 복구
                    lost[i] = -1; // 처리 완료 마킹
                    reserve[j] = -1; // 처리 완료 마킹
                    break;
                }
            }
        }

        // 3. 실제로 체육복 빌려주기 (그리디)
        for (int k : lost) {
            if (k == -1) continue; // 이미 해결된 학생 스킵

            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == -1) continue; // 이미 빌려준 학생 스킵

                // 앞번호(lost[i] - 1)나 뒷번호(lost[i] + 1) 학생에게만 빌릴 수 있음
                if (reserve[j] == k - 1 || reserve[j] == k + 1) {
                    answer++; // 수업 들을 수 있는 인원 증가
                    reserve[j] = -1; // 빌려준 상태로 변경
                    break; // 다음 도난 학생으로 이동
                }
            }
        }

        return answer;
    }
}
