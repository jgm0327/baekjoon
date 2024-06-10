import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    
    private static List<Integer> order;
    private static Map<Integer, Boolean>[] likes;
    private static int[][] classroom;
    private static int n;
    private static final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        classroom = new int[n][n];
        
        order = new ArrayList<>();
        likes = new HashMap[(n * n) + 1];
        
        for(int i=0 ; i<=n*n ; i++){
            likes[i] = new HashMap<>();
        }

        for(int i=0 ; i<n*n ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(stk.nextToken());
            order.add(student);

            while(stk.hasMoreTokens()){
                likes[student].put(Integer.parseInt(stk.nextToken()), true);
            }
        }

        for(int student : order){
            int[] seatPosition = seatCorrectly(student);
            int y = seatPosition[0], x = seatPosition[1];

            classroom[y][x] = student;
        }

        int answer = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                answer += calculateScore(i, j);
            }
        }
        System.out.println(answer);
    }

    private static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }

    private static int calculateScore(int y, int x){
        int ret = 0;
        int number = classroom[y][x];

        for(int i=0 ; i<4 ; i++){
            int ny = y + dy[i], nx = x + dx[i];

            if(!isIn(ny, nx) || !likes[number].containsKey(classroom[ny][nx]))
                continue;

            if(ret == 0){
                ret = 1;
                continue;
            }

            ret *= 10;
        }

        return ret;
    }

    private static int[] seatCorrectly(int number){
        int[] ret = {0,0};
        int maxBlankCount = -1, maxLikeCount = -1;

        for(int y=0 ; y<n ; y++){
            for(int x=0 ; x<n ; x++){
                if(classroom[y][x] != 0)
                    continue;
                
                int blankCount = countAround(number, y, x, false);
                int likeCount = countAround(number, y, x, true);

                if(maxLikeCount < likeCount){
                    ret = new int[]{y, x};
                    maxLikeCount = likeCount;
                    maxBlankCount = blankCount;
                }

                else if(maxLikeCount == likeCount && blankCount > maxBlankCount){
                    ret = new int[]{y, x};
                    maxBlankCount = blankCount;
                }
            }
        }

        return ret;
    }

    private static int countAround(int number, int y, int x, boolean doesLike){
        int ret = 0;

        for(int i=0 ; i<4 ; i++){
            int ny = y + dy[i], nx = x + dx[i];

            if(!isIn(ny, nx))
                continue;

            if(!doesLike && classroom[ny][nx] == 0){
                ret++;
                continue;
            }

            if(doesLike && likes[number].containsKey(classroom[ny][nx])){
                ret++;
            }
        }

        return ret;
    }
}
