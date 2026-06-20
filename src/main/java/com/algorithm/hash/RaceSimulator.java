package com.algorithm.hash;

import java.util.HashMap;

public class RaceSimulator {

    public String[] solution(String[] players, String[] callings) {
        // 1. 선수의 이름으로 현재 등수를 O(1)만에 찾기 위한 해시맵 선언
        HashMap<String, Integer> playerMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i); // {선수 이름 : 배열 인덱스}
        }

        // 2. 해설진이 이름을 부를 때마다 실시간 순위 교체 시뮬레이션
        for (String calling : callings) {
            // 추월한 선수의 현재 등수(배열 인덱스)
            int currentIdx = playerMap.get(calling);
            // 추월당할 앞 선수의 등수(배열 인덱스)
            int frontIdx = currentIdx - 1;

            // 앞 선수의 이름 추출
            String frontPlayer = players[frontIdx];

            // 3. 실제 순위 배열(players) 데이터 스왑(Swap)
            players[frontIdx] = calling;
            players[currentIdx] = frontPlayer;

            // 4. 해시맵(playerMap) 내 등수 정보 동기화 업데이트
            playerMap.put(calling, frontIdx);
            playerMap.put(frontPlayer, currentIdx);
        }

        return players;
    }
}
