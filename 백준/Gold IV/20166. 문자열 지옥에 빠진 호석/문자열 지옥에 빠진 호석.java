import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static char[][] board;
    private static int[] dy = {-1,-1,-1,0,1,1,1,0}, dx = {-1,0,1,1,1,0,-1,-1};
    private static Map<String, Integer> count;
    private static Set<String> words;
    private static int n, m, k, cnt;
    
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

        words = new LinkedHashSet<>();
        count = new HashMap<>();
        while(k-- > 0){
            String word = br.readLine();
            words.add(word);
            count.put(word, 0);
        }

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
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
        boolean[][][] visit = new boolean[n][m][8];
        Queue<Word> que = new LinkedList<>();

        que.add(new Word(y, x, new StringBuilder(board[y][x]+"")));

        while(!que.isEmpty()){
            Word word = que.poll();

            for(int i=0 ; i<8 ; i++){
                int ny = word.y + dy[i], nx = word.x + dx[i];
                if(ny < 0)ny = n - 1;
                if(nx < 0)nx = m - 1;

                ny %= n;
                nx %= m;

                if(visit[ny][nx][i])continue;

                visit[ny][nx][i] = true;
                StringBuilder sb = new StringBuilder(word.path.toString());
                sb.append(board[ny][nx]+"");

                if(count.containsKey(sb.toString())){
                    count.put(sb.toString(), count.get(sb.toString()) + 1);
                    continue;
                }

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
