import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ('A' <= ch && ch <= 'Z') {
                answer.append(ch);
                continue;
            }

            if(ch == '('){
                stack.add(ch);
            }
            else if(ch == ')'){
                while(stack.peekLast() != '('){
                    answer.append(stack.pollLast());
                }
                stack.pollLast();
            }
            else if(ch == '+' || ch == '-'){
                while (!stack.isEmpty() && stack.peekLast() != '(') {
                    answer.append(stack.pollLast());
                }
                stack.add(ch);
            }
            else{
                while (!stack.isEmpty() && (stack.peekLast() == '*' || stack.peekLast() == '/')){
                    answer.append(stack.pollLast());
                }
                stack.add(ch);
            }
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pollLast());
        }

        System.out.println(answer);

        br.close();
    }
}