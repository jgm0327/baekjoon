import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static int n, m, answer;
	private static List<int[]> chickenHouses, houses;
	private static boolean[][] open;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		answer = Integer.MAX_VALUE;
		open = new boolean[n][n];
		
		chickenHouses = new ArrayList<>();
		houses = new ArrayList<>();
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ;j++) {
				int data = sc.nextInt();
				if(data == 2)chickenHouses.add(new int[] {i, j});
				else if(data == 1)houses.add(new int[] {i, j});
			}
		}
		closed(0, 0);
		System.out.println(answer);
	}
	
	private static void calcDist() {
		int comp = 0, tmp;
		for(int[] house : houses) {
			int y = house[0], x = house[1];
			tmp = Integer.MAX_VALUE;
			for(int[] chickenHouse : chickenHouses) {
				int cy = chickenHouse[0], cx = chickenHouse[1];
				if(!open[cy][cx])continue;
				tmp = Math.min(tmp, (Math.abs(y - cy) + Math.abs(x - cx)));
			}
			comp += tmp;
		}
		answer = Math.min(comp, answer);
	}
	
	private static void closed(int depth, int start) {
		if(depth == m) {
			return;
		}
		for(int i=start ; i<chickenHouses.size() ; i++) {
			int[] cur = chickenHouses.get(i);
			int y = cur[0], x = cur[1];
			open[y][x] = true;
			calcDist();
			closed(depth + 1, i + 1);
			open[y][x] = false;
		}
	}
}
