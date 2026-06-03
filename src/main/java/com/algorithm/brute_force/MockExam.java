package com.algorithm.brute_force;

import java.util.ArrayList;
import java.util.List;

public class MockExam {

    public int[] solution(int[] answers) {
        // 1. 수포자 삼인방의 정답 찍기 패턴 정의
        int[] player1 = {1, 2, 3, 4, 5};
        int[] player2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] player3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 각 플레이어별 맞힌 개수 누적 배열
        int[] scores = new int[3];

        // 2. 전체 정답지를 돌며 모듈러 연산(%)으로 각 수포자의 정답 여부 체크
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == player1[i % player1.length]) scores[0]++;
            if (answers[i] == player2[i % player2.length]) scores[1]++;
            if (answers[i] == player3[i % player3.length]) scores[2]++;
        }

        // 3. 세 명 중 최고 점수 계산
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        // 4. 최고 점수를 획득한 우승자 선별 (동점자 처리용 가변 리스트 생성)
        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                winners.add(i + 1); // 1번, 2번, 3번 수포자이므로 index + 1
            }
        }

        // 5. List 객체를 원시 int[] 배열로 변환하여 반환
        int[] answer = new int[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            answer[i] = winners.get(i);
        }

        return answer;
    }
}
