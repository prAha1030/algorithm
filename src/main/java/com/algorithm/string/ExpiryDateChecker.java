package com.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpiryDateChecker {

    public int[] solution(String today, String[] terms, String[] privacies) {
        // 1. 오늘 날짜를 총 '일(Day)' 수로 변환
        int todayTotalDays = convertToDays(today);

        // 2. 약관 종류별 유효기간(달 수)을 해시맵에 저장
        HashMap<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            String type = splitTerm[0];
            int months = Integer.parseInt(splitTerm[1]);
            termMap.put(type, months);
        }

        // 파기할 개인정보 번호를 담을 가변 리스트
        List<Integer> expiredList = new ArrayList<>();

        // 3. 개인정보 배열을 순회하며 만료 여부 체크
        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");
            String collectDate = splitPrivacy[0];
            String type = splitPrivacy[1];

            // 수집 일자를 총 '일(Day)' 수로 변환
            int collectTotalDays = convertToDays(collectDate);
            // 약관에 따른 유효기간(달 수)을 '일' 단위로 환산하여 더함 (1달 = 28일)
            int expiryTotalDays = collectTotalDays + (termMap.get(type) * 28);

            // 4. 오늘 날짜가 만료일 이상(같거나 지난 경우)이면 파기 대상
            if (todayTotalDays >= expiryTotalDays) {
                expiredList.add(i + 1); // 개인정보 번호는 1번부터 시작하므로 i + 1
            }
        }

        // 5. List를 정수 배열(int[])로 변환하여 반환
        int[] answer = new int[expiredList.size()];
        for (int i = 0; i < expiredList.size(); i++) {
            answer[i] = expiredList.get(i);
        }

        return answer;
    }

    // "YYYY.MM.DD" 형태의 문자열을 총 '일(Day)' 수 정수로 변환하는 헬퍼 메서드
    private int convertToDays(String date) {
        String[] splitDate = date.split("\\."); // 점(.)은 정규식 예약어이므로 이스케이프 필요
        int year = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int day = Integer.parseInt(splitDate[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }
}
