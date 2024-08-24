import java.io.*;
import java.util.*;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(tokenizer.nextToken());
    int m = Integer.parseInt(tokenizer.nextToken());

    tokenizer = new StringTokenizer(br.readLine());

    StringBuilder answer = new StringBuilder();

    //(3-3+1)

    ArrayDeque<int[]> deque = new ArrayDeque<>();

    for(int i=0 ; i<n ; i++){
      int number = Integer.parseInt(tokenizer.nextToken());

      while(!deque.isEmpty() && deque.peekLast()[0] > number){
        deque.pollLast();
      }

      while(!deque.isEmpty() && i - m >= deque.peek()[1]){
        deque.poll();
      }

      deque.add(new int[]{number, i});

      answer.append(deque.peek()[0]).append(" ");
    }

    System.out.println(answer);
    
    br.close();
  }
}