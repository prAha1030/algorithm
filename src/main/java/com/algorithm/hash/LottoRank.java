package com.algorithm.hash;

import java.util.HashSet;

public class LottoRank {

    public int[] solution(int[] lottos, int[] win_nums) {
        // 1. 당첨 번호를 HashSet에 넣어 조회 속도를 O(1)로 최적화
        HashSet<Integer> winSet = new HashSet<>();
        for (int num : win_nums) {
            winSet.add(num);
        }

        int zeroCount = 0; // 알아볼 수 없는 번호(0)의 개수
        int matchCount = 0; // 확실하게 일치하는 번호의 개수

        // 2. 민우의 로또 번호를 순회하며 0의 개수와 맞은 개수 카운트
        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            } else if (winSet.contains(num)) {
                matchCount++;
            }
        }

        // 3. 최고 맞은 개수와 최저 맞은 개수 계산
        int maxMatch = matchCount + zeroCount;
        int minMatch = matchCount;

        // 4. 맞은 개수를 순위로 변환 (7에서 맞은 개수를 빼면 순위가 나옴, 단 1개 이하로 맞으면 6등)
        int maxRank = Math.min(7 - maxMatch, 6);
        int minRank = Math.min(7 - minMatch, 6);

        return new int[]{maxRank, minRank};
    }
}
