import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main{
  private static int[][] board;
  private static List<int[]> zeros;
  private static boolean flag;

  public static void main(String[] args) throws IOException{
    init();
    solution();
  }

  private static void init() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    board = new int[9][9];
    zeros = new ArrayList<>();

    for(int i=0 ; i<9 ; i++){
      String[] values = br.readLine().split(" ");
      for(int j=0 ; j<9 ; j++){
        board[i][j] = Integer.parseInt(values[j]);
        if(board[i][j] == 0)zeros.add(new int[]{i, j});
      }
    }
    
    flag = false;
    br.close();
  }

  private static void solution(){
    recur(0);
    for(int i=0 ; i<9 ; i++){
      for(int j=0 ; j<9 ; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void print(){
    for(int i=0 ; i<9 ; i++){
      for(int j=0 ; j<9 ; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void recur(int idx){
    if(idx == zeros.size()){
      flag = true;
      return;
    }

    int[] cur = zeros.get(idx);
    int y = cur[0], x = cur[1];
    for(int i=1 ; i<=9 ; i++){
      if(!square(y, x, i) || !veritcal(y, x, i) || !horizon(y, x, i))continue;
      board[y][x] = i;
      recur(idx + 1);
      if(flag)return;
      board[y][x] = 0;
    }
  }

  private static boolean square(int y, int x, int target){
    int startY = (y / 3) * 3, startX = (x / 3) * 3;
    for(int i=startY ; i<startY + 3 ; i++){
      for(int j=startX ; j<startX + 3 ; j++){
        if(board[i][j] == target)return false;
      }
    }
    return true;
  }

  private static boolean veritcal(int y, int x, int target){
    for(int i=0 ; i<9 ; i++){
      if(board[i][x] == target)return false;
    }
    return true;
  }

  private static boolean horizon(int y, int x, int target){
    for(int i=0 ; i<9 ; i++){
      if(board[y][i] == target)return false;
    }
    return true;
  }
}