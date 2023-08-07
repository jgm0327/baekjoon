import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[][] colorPaper;
	private static int[] colors;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		colorPaper = new int[n][n];
		colors = new int[2];
		for(int i=0 ; i<n ; i++){
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0 ; j<n ; j++){
				colorPaper[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		recur(0, 0, n);
		System.out.println(colors[0] + "\n" + colors[1]);
		br.close();
	}

	private static void recur(int startY, int startX, int size){
		if(size == 1 || isAllSameColor(startY, startX, size)){
			colors[colorPaper[startY][startX]]++;
			return;
		}
		int half = size / 2;
		recur(startY, startX, half);
		recur(startY + half, startX, half);
		recur(startY, startX + half, half);
		recur(startY + half, startX + half, half);
	}

	private static boolean isAllSameColor(int startY, int startX, int size){
		int color = colorPaper[startY][startX];
		for(int i=startY ; i<startY + size ; i++){
			for(int j=startX ; j<startX + size ; j++){
				if(colorPaper[i][j] != color)
					return false;
			}
		}
		return true;
	}
}
