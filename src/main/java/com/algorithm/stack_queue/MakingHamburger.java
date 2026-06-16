package com.algorithm.stack_queue;

import java.util.ArrayList;

public class MakingHamburger {

    public int solution(int[] ingredient) {
        int answer = 0;

        // 1. 재료를 순서대로 쌓을 스택 역할의 리스트 생성
        ArrayList<Integer> stack = new ArrayList<>();

        // 2. 재료를 하나씩 스택에 투입
        for (int ing : ingredient) {
            stack.add(ing);

            // 3. 재료가 4개 이상 쌓였을 때마다 상단 4개의 패턴 검사
            int size = stack.size();
            if (size >= 4) {
                // 뒤에서부터 4개 조사: 빵(1) - 야채(2) - 고기(3) - 빵(1) 순서인지 확인
                if (stack.get(size - 4) == 1 &&
                        stack.get(size - 3) == 2 &&
                        stack.get(size - 2) == 3 &&
                        stack.get(size - 1) == 1) {

                    answer++; // 햄버거 완성

                    // 4. 완성된 햄버거 재료 4개를 스택에서 제거
                    // 뒤에서부터 지워야 인덱스 붕괴 및 데이터 시프팅 비용이 발생하지 않음
                    stack.remove(size - 1);
                    stack.remove(size - 2);
                    stack.remove(size - 3);
                    stack.remove(size - 4);
                }
            }
        }

        return answer;
    }
}
