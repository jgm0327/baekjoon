import java.util.Scanner;

public class Main {

	private static int n, r, c;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt();
		r = scanner.nextInt();
		c = scanner.nextInt();
		
		int size = (int)Math.pow(2, n);
		
		System.out.println(dfs(0, 0, size, 0));
		
		scanner.close();
	}
	
	private static int dfs(int y, int x, int size, int total) {
		if(size == 1) {
			return total;
		}
		
		int half = size / 2;
		int sum = half * half;
		
		// 2사분면
		if(y <= r && r < y + half && x <= c && c < x + half) {
			return dfs(y, x, half, total);
		}
		
		// 1사분면
		if(y <= r && r < y + half && x + half <= c && c < x + size) {
			return dfs(y, x + half, half, total + sum);
		}
		
		// 3사분면
		if(y + half <= r && r < y + size && x <= c && c < x + half) {
			return dfs(y + half, x, half, total + sum * 2);
		}
		
		// 4사분면
		if(y + half <= r && r < y + size && x + half <= c && c < x + size) {
			return dfs(y + half, x + half, half, total + sum * 3);
		}
		
		return 0;
	}
}
