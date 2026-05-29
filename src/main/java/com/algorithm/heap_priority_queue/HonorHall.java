package com.algorithm.heap_priority_queue;

import java.util.PriorityQueue;

public class HonorHall {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        // 1. 오름차순으로 숫자를 정렬해 주는 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);

            // 2. 큐의 크기가 k를 초과하면 가장 작은 값(최하위 점수)을 탈락시킴
            if (pq.size() > k) {
                pq.poll();
            }

            // 3. 현재 명예의 전당(큐)의 최하위 점수를 결과 배열에 기록
            answer[i] = pq.element();
        }

        return answer;
    }
}
