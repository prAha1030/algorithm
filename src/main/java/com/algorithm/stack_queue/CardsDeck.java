package com.algorithm.stack_queue;

public class CardsDeck {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 각 카드 뭉치의 현재 가리키는 인덱스(포인터)
        int idx1 = 0;
        int idx2 = 0;

        // goal 배열의 단어를 하나씩 순서대로 확인
        for (String word : goal) {
            // 1. 첫 번째 카드 뭉치에서 뽑을 수 있는 경우
            if (idx1 < cards1.length && word.equals(cards1[idx1])) {
                idx1++; // 다음 카드로 포인터 이동
            }
            // 2. 두 번째 카드 뭉치에서 뽑을 수 있는 경우
            else if (idx2 < cards2.length && word.equals(cards2[idx2])) {
                idx2++; // 다음 카드로 포인터 이동
            }
            // 3. 둘 다 불가능한 경우 (순서가 어긋남)
            else {
                return "No";
            }
        }

        // 모든 단어를 순서대로 만들었다면 "Yes"
        return "Yes";
    }
}
