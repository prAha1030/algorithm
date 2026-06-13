package com.algorithm.hash;

import java.util.HashMap;

public class RoughKeyboard {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        // 1. 알파벳별 최소 클릭 횟수를 저장할 해시맵 생성
        HashMap<Character, Integer> minKeyMap = new HashMap<>();

        // 2. 모든 자판(keymap)을 순회하며 각 문자의 최소 누름 횟수 갱신
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                int clicks = i + 1; // 인덱스는 0부터 시작하므로 클릭 횟수는 i + 1

                // 이미 등록된 문자라면 더 작은 클릭 횟수로 갱신
                if (minKeyMap.containsKey(ch)) {
                    minKeyMap.put(ch, Math.min(minKeyMap.get(ch), clicks));
                } else {
                    minKeyMap.put(ch, clicks);
                }
            }
        }

        // 3. 타겟 문자열(targets)을 하나씩 확인하며 누적 클릭 횟수 계산
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalClicks = 0;
            boolean isPossible = true;

            for (int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);

                // 자판에 없는 문자가 포함되어 있다면 작성 불가능
                if (!minKeyMap.containsKey(ch)) {
                    isPossible = false;
                    break;
                }

                totalClicks += minKeyMap.get(ch);
            }

            // 작성 가능 여부에 따라 결과 배열에 매핑
            answer[i] = isPossible ? totalClicks : -1;
        }

        return answer;
    }
}
