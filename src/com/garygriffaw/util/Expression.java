package com.garygriffaw.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final List<Character> leftBrackets = Arrays.asList('(', '[', '{', '<');
    private final List<Character> rightBrackets = Arrays.asList(')', ']', '}', '>');

    public boolean isBalanced(String input) {
        if(input == null)
            return true;

        Stack<Character> stack = new Stack<>();

        for(char chr : input.toCharArray()) {
            if(isLeftBracket(chr))
                stack.push(chr);
            else if(isRightBracket(chr)) {
                if(stack.empty()) return false;

                char pop = stack.pop();
                if(!bracketsMatch(pop, chr)) return false;
            }
        }

        return stack.empty();
    }

    private boolean isLeftBracket(Character chr) {
        return leftBrackets.contains(chr);
    }

    private boolean isRightBracket(Character chr) {
        return rightBrackets.contains(chr);
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
