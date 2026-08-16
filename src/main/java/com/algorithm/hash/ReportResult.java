package com.algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ReportResult {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 1. 중복 신고를 원천 차단하기 위해 report 배열을 HashSet으로 변환
        HashSet<String> uniqueReport = new HashSet<>(Arrays.asList(report));

        // 2. [신고당한 사람 : 자신을 신고한 사람들의 목록] 매핑 해시맵 구축
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        // 유저마다 메일 수령 인덱스를 O(1)로 찾기 위한 ID-인덱스 맵
        HashMap<String, Integer> idIdxMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new HashSet<>());
            idIdxMap.put(id_list[i], i);
        }

        // 3. 중복이 제거된 신고 기록을 풀어서 매핑 맵에 누적
        for (String r : uniqueReport) {
            String[] split = r.split(" ");
            String from = split[0]; // 신고한 유저
            String to = split[1];   // 신고당한 유저

            // 신고당한 유저의 신고자 명단 셋에 추가
            reportMap.get(to).add(from);
        }

        // 4. 신고자 명단 셋의 크기가 k 이상인 대상을 찾아서 메일 횟수 누적
        for (String key : reportMap.keySet()) {
            HashSet<String> reporters = reportMap.get(key);

            // 특정 유저를 신고한 사람이 k명 이상이라면 (이용 정지 대상)
            if (reporters.size() >= k) {
                // 해당 유저를 신고했던 모든 신고자들에게 메일 1회씩 지급
                for (String reporter : reporters) {
                    int idx = idIdxMap.get(reporter);
                    answer[idx]++;
                }
            }
        }

        return answer;
    }
}
