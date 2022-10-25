package leetcode.checkValidString;

import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> bracket = new Stack<>();
        Stack<Integer> asterisk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                bracket.push(i);
            } else if ('*' == s.charAt(i)) {
                asterisk.push(i);
            } else {
                if (!bracket.isEmpty()) {
                    bracket.pop();
                } else if (!asterisk.isEmpty()) {
                    asterisk.pop();
                } else {
                    return false;
                }
            }
        }

        while (!bracket.isEmpty()) {
            if (asterisk.isEmpty()) {
                return false;
            }

            int asteriskIdx = asterisk.pop();
            int bracketIdx = bracket.pop();

            if (bracketIdx > asteriskIdx) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString("(*))"));
    }
}
