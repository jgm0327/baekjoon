import java.io.*;
import java.util.*;

class Main {
    private static int[] dy = {0,-1,1,0,0}, dx = {0,0,0,1,-1};
    private static Shark[][] sharks;
    private static int R, C, answer;

    static class Shark{
        int s, d, z;

        public Shark(int s, int d, int z){
            this.s = s;
            this.d = d;
            this.z = z;
        }

        public Shark(){
            s = d = z = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        sharks = new Shark[R][C];
        for(int i=0 ; i<R ; i++){
            for(int j=0 ; j<C ; j++){
                sharks[i][j] = new Shark();
            }
        }

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            int s = Integer.parseInt(tokenizer.nextToken());
            int d = Integer.parseInt(tokenizer.nextToken());
            int z = Integer.parseInt(tokenizer.nextToken());

            sharks[r - 1][c - 1] = new Shark(s, d, z);
        }

        for(int c=0 ; c<C ; c++){
            catchShark(c);
            moveShark();
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static void catchShark(int c){
        for(int r=0 ; r<R ; r++){
            if(sharks[r][c].z > 0){
                answer += sharks[r][c].z;
                sharks[r][c].z = 0;
                break;
            }
        }
    }

    private static void moveShark(){
        Shark[][] temp = new Shark[R][C];

        for(int i=0 ; i<R ; i++){
            for(int j=0 ; j<C ; j++){
                temp[i][j] = new Shark();
            }
        }

        for(int r=0 ; r<R; r++){
            for(int c=0 ; c<C ; c++){
                Shark shark = sharks[r][c];

                if(shark.z == 0)
                    continue;

                int[] nextPos = calculatePos(r, c, shark.d, shark.s);

                if(temp[nextPos[0]][nextPos[1]].z > shark.z){
                    continue;
                }

                temp[nextPos[0]][nextPos[1]] = new Shark(shark.s, nextPos[2], shark.z);
            }
        }

        sharks = temp;
    }

    private static int[] calculatePos(int y, int x, int d, int s){
        if(d == 1 || d == 2)s %= (R - 1) * 2;
        else s %= (C - 1) * 2;

        while(s-- > 0){
            if(!isIn(y + dy[d], x + dx[d])){
                if(d == 1)d = 2;
                else if(d == 2)d = 1;
                else if(d == 3)d = 4;
                else d = 3;
            }

            y += dy[d];
            x += dx[d];
        }

        return new int[]{y, x, d};
    }

    private static boolean isIn(int r, int c){
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}