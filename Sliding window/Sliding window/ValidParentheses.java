
Problem Statement
Given a string containing:
( ) { } [ ]

Determine if the input string is valid.
Rules:
Open brackets must be closed by same type
Must be closed in correct order
Example
Input: "()[]{}"
Output: true
Input: "(]"
Output: false


Core Idea
Use a stack:
1️⃣ If opening bracket → push
2️⃣ If closing bracket → check top of stack
3️⃣ If mismatch → return false
4️⃣ If stack empty at end → valid



CODE-------

class ValidParentheses {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            else {

                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "()[]{}";
        System.out.println("Result: " + isValid(s));
    }
}
