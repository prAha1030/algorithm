package com.algorithm.hash;

import java.util.HashMap;

public class NearestCharacter {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        // 문자와 해당 문자의 가장 최근 인덱스를 저장할 해시맵
        HashMap<Character, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 이전에 나온 적이 있다면 현재 인덱스 - 직전 인덱스
            if (lastSeen.containsKey(ch)) {
                answer[i] = i - lastSeen.get(ch);
            } else {
                // 처음 나온 문자라면 -1
                answer[i] = -1;
            }

            // 현재 문자의 위치를 최신 인덱스로 업데이트
            lastSeen.put(ch, i);
        }

        return answer;
    }
}
