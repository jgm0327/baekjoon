import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong(), m = sc.nextLong();
		int answer = 1;
		
		while (m > n) {
			answer++;
			if(m % 10 == 1)m /= 10;
			else if(m % 2 == 0)m /= 2;
			else break;
		}
		System.out.println(m == n ? answer : -1);
	}
}
