import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String brackets = br.readLine();
        int num_of_pieces = 0;
        /* 막대 조각의 개수를 세는 조건은 레이저로 막대를 자를때(조건 1),
           막대가 끝이 입력으로 들어왔을 때(조건 2)이다.
           조건 1의 경우에는 스택에 있는 막대들의 개수만큼 조각들이 생기고
           조건 2의 경우에는 1개의 막대 조각이 생긴다.
           주의할 점은 레이저의 입력도 처음에는 막대의 시작 입력과 동일하게 이루어지므로
           '(' 1개가 스택에 push 되는데, 이를 조각 카운팅 전에 제거해주어야 한다.
           (막대가 아닌 레이저의 '('이기 때문에 함께 카운팅되면 안됨)
        */
        for (int i=0;i<brackets.length();i++) {
            if (brackets.charAt(i) == '(') { // '(' 입력의 경우
                stack.push('('); // (스택에) 막대 깔아주기
            } else { // ')' 입력의 경우
                if (brackets.charAt(i-1) == '(') { // "()"이 입력으로 들어온다면 레이저임
                    stack.pop(); // 레이저 출현
                    num_of_pieces += stack.size(); // 스택에 쌀인 막대들 개수만큼 잘려진 조각들 생김
                } else { // 레이저가 아니라 막대 1개의 끝인 경우
                    stack.pop(); // 스택에서 막대 하나 꺼냄
                    num_of_pieces += 1; // 막대 1개 꺼냈으므로 조각 1개 추가
                }
            }
        }
        System.out.println(num_of_pieces);
        br.close();
    }
}
