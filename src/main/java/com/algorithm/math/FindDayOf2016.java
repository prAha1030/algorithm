package com.algorithm.math;

public class FindDayOf2016 {

    public String solution(int a, int b) {
        // 1. 2016년 각 달의 일수 배열 (2016년은 윤년이므로 2월은 29일)
        int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 2. 요일 배열 (1월 1일이 금요일이므로, 총 일수를 7로 나눈 나머지와 매칭)
        // 1월 1일은 총 일수가 1일이며 'FRI'가 나와야 하므로 인덱스 1에 'FRI' 배치
        String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        int totalDays = 0;

        // 3. (a - 1)월까지의 모든 일수를 더함
        for (int i = 1; i < a; i++) {
            totalDays += months[i];
        }

        // 4. 이번 달의 일수 b를 더함
        totalDays += b;

        // 5. 7로 나눈 나머지에 해당하는 요일 반환
        return days[totalDays % 7];
    }
}
