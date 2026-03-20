import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }

        return result.toString();
    }
}