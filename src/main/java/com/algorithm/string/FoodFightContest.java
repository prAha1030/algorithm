package com.algorithm.string;

public class FoodFightContest {

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        // 1. 왼쪽 선수가 먹을 음식 배치 (1번 음식부터 차례대로)
        for (int i = 1; i < food.length; i++) {
            // 한 선수가 먹을 양은 (전체 음식 개수 / 2)
            int count = food[i] / 2;
            sb.append(String.valueOf(i).repeat(Math.max(0, count)));
        }

        // 2. 중앙에 물(0)을 배치하고, 오른쪽 선수의 음식은 왼쪽 음식을 뒤집어서 붙임
        String leftSide = sb.toString();
        String rightSide = sb.reverse().toString();

        return leftSide + "0" + rightSide;
    }
}
