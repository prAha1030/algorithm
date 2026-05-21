package com.algorithm.string;

public class CaesarCipher {

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 1. 공백은 아무리 밀어도 공백
            if (ch == ' ') {
                sb.append(ch);
                continue;
            }

            // 2. 소문자 처리
            if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            }
            // 3. 대문자 처리
            else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }

            sb.append(ch);
        }

        return sb.toString();
    }
}
