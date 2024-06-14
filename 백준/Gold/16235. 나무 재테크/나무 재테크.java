import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{

    private static int n, answer;
    private static int[][] map, nourishment;
    private static final int[] dy = {-1,-1,0,1,1,1,0,-1}, dx = {0,1,1,1,0,-1,-1,-1};
    private static ArrayDeque<Integer>[][] trees;
    private static boolean[][] exist;
    private static Queue<int[]> treePosition;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        map = new int[n + 1][n + 1];
        nourishment = new int[n + 1][n + 1];

        for(int i = 1 ; i<=n ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            for(int j=1 ; j<=n ; j++){
                nourishment[i][j] = Integer.parseInt(tokenizer.nextToken());
                map[i][j] = 5;
            }
        }

        trees = new ArrayDeque[n + 1][n + 1];
        for(int i=0 ; i<=n ; i++){
            trees[i] = new ArrayDeque[n + 1];
            for(int j=0 ; j<=n ; j++){
                trees[i][j] = new ArrayDeque<>();
            }
        }

        treePosition = new ArrayDeque<>();
        exist = new boolean[n + 1][n + 1];
        for(int i=0 ; i<m ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            int age = Integer.parseInt(tokenizer.nextToken());

            trees[y][x].add(age);
            treePosition.add(new int[]{y, x});
            exist[y][x] = true;
        }

        answer = m;
        while(k-- > 0){
            spring();
            fall();
            winter();
        }

        System.out.println(answer);
    }

    private static void spring(){
        int size = treePosition.size();

        for(int i=0 ; i<size ; i++){
            int[] pos = treePosition.poll();

            int y = pos[0], x = pos[1];

            int treeCount = trees[y][x].size();

            int deadTree = 0;
            
            for(int tree=0 ; tree<treeCount ; tree++){
                int age = trees[y][x].pollLast();

                if(map[y][x] < age){
                    deadTree += (age / 2);
                    answer--;
                    continue;
                }

                map[y][x] -= age;
                trees[y][x].addFirst(age + 1);
            }

            map[y][x] += deadTree;

            if(trees[y][x].isEmpty()){
                exist[y][x] = false;
                continue;
            }

            treePosition.add(pos);
        }
    }

    private static void fall(){
        int size = treePosition.size();

        while(size -- > 0){
            int[] pos = treePosition.poll();
            int y = pos[0], x = pos[1];

            for(int age : trees[y][x]){
                if(age % 5 != 0)
                    continue;

                for(int d = 0 ; d < 8 ; d++){
                    int ny = y + dy[d], nx = x + dx[d];

                    if(1 > ny || ny > n || 1 > nx || nx > n)
                        continue;
                    
                    trees[ny][nx].add(1);
                    answer++;

                    if(exist[ny][nx])
                        continue;
                    
                    exist[ny][nx] = true;
                    treePosition.add(new int[]{ny, nx});
                }
            }
            treePosition.add(pos);
        }
    }

    private static void winter(){
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++){
                map[i][j] += nourishment[i][j];
            }
        }
    }
}