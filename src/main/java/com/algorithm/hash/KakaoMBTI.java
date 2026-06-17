package com.algorithm.hash;

import java.util.HashMap;

public class KakaoMBTI {

    public String solution(String[] survey, int[] choices) {
        // 1. 성격 유형별 점수를 저장할 해시맵 초기화
        HashMap<Character, Integer> scoreMap = new HashMap<>();
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (char type : types) {
            scoreMap.put(type, 0);
        }

        // 2. 각 질문과 선택지를 순회하며 점수 누적
        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];

            // 4번(모르겠음)은 점수가 없으므로 건너뜀
            if (choice == 4) continue;

            char disagreeType = survey[i].charAt(0); // 비동의 캐릭터 (왼쪽)
            char agreeType = survey[i].charAt(1);    // 동의 캐릭터 (오른쪽)

            if (choice < 4) {
                // 1, 2, 3번 선택지 -> 비동의(왼쪽) 캐릭터에 점수 부여 (3점, 2점, 1점)
                int score = 4 - choice;
                scoreMap.put(disagreeType, scoreMap.get(disagreeType) + score);
            } else {
                // 5, 6, 7번 선택지 -> 동의(오른쪽) 캐릭터에 점수 부여 (1점, 2점, 3점)
                int score = choice - 4;
                scoreMap.put(agreeType, scoreMap.get(agreeType) + score);
            }
        }

        // 3. 지표별 점수를 비교하여 최종 성격 유형 조합
        // 1번 지표: R vs T
        return String.valueOf(scoreMap.get('R') >= scoreMap.get('T') ? 'R' : 'T') +
                // 2번 지표: C vs F
                (scoreMap.get('C') >= scoreMap.get('F') ? 'C' : 'F') +
                // 3번 지표: J vs M
                (scoreMap.get('J') >= scoreMap.get('M') ? 'J' : 'M') +
                // 4번 지표: A vs N
                (scoreMap.get('A') >= scoreMap.get('N') ? 'A' : 'N');
    }
}
