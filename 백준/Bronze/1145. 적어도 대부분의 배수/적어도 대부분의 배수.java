import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for(int i=0 ; i<5 ; i++) {
			arr[i] = sc.nextInt();
		}
		minMul(arr);
	}
	
	private static void minMul(final int[] arr) {
		for(int i=1 ; ; i++) {
			int cnt = 0;
			for(int j=0 ; j<5 ; j++) {
				if(i % arr[j] == 0)cnt++;
				if(cnt >= 3) {
					System.out.println(i);
					return;
				}
			}
		}
	}
	
}
