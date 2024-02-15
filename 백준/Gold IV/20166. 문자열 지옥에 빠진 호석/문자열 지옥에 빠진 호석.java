import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static char[][] board;
    private static int[] dy = {-1,-1,-1,0,1,1,1,0}, dx = {-1,0,1,1,1,0,-1,-1};
    private static Map<String, Integer> count;
    private static List<String> words;
    private static int n, m, k, max_value;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        board = new char[n][m];
        for(int i=0 ; i<n ; i++){
            String values = br.readLine();
            for(int j=0 ; j<m ; j++){
                board[i][j] = values.charAt(j);
            }
        }

        /* 위 코드는 입력 부분입니다. */

        words = new ArrayList<>();
        count = new HashMap<>();
        max_value = 0;
        while(k-- > 0){
            String word = br.readLine();
            words.add(word);
            count.put(word, 0);
            max_value = Math.max(max_value, word.length());
        }
        
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                String key = board[i][j] + "";
                if(count.containsKey(key)){
                    count.replace(key, count.get(key) + 1);
                }
                bfs(i, j);
            }
        }
        
        StringBuilder answer = new StringBuilder();

        for(String key : words){
            answer.append(count.get(key)).append("\n");
        }

        System.out.println(answer);
    }

    private static void bfs(int y, int x){
        Queue<Word> que = new LinkedList<>();

        que.add(new Word(y, x, new StringBuilder(board[y][x]+"")));

        while(!que.isEmpty()){
            Word word = que.poll();

            String key = word.path.toString();

            for(int i=0 ; i<8 ; i++){
                int ny = word.y + dy[i], nx = word.x + dx[i];
                // 음수 처리
                if(ny < 0)ny = n - 1;
                if(nx < 0)nx = m - 1;

                // n이 됐을 때 대비
                ny %= n;
                nx %= m;

                StringBuilder sb = new StringBuilder(key);
                sb.append(board[ny][nx]+"");

                if(count.containsKey(sb.toString())){
                    count.put(sb.toString(), count.get(sb.toString()) + 1);
                }

                if(sb.length() > max_value)continue;

                que.add(new Word(ny, nx, sb));
            }
        }
    }

    static class Word{
        int y, x;
        StringBuilder path;

        public Word(int y, int x, StringBuilder path){
            this.y = y;
            this.x = x;
            this.path = path;
        }
    }
}
