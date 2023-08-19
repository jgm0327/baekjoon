import java.util.Scanner;

class Main{
	private static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	private static int[] numbers, operations;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n];
		operations = new int[4];

		for(int i=0 ; i<n ; i++){
			numbers[i] = sc.nextInt();
		}

		for(int i=0 ; i<4 ; i++){
			operations[i] = sc.nextInt();
		}

		recur(numbers[0], 1);
		System.out.println(max);
		System.out.println(min);
		sc.close();
	}

	private static void recur(int value, int depth){
		if(depth == n){
			max = Math.max(value, max);
			min = Math.min(value, min);
			return;
		}

		if(operations[0] != 0){
			operations[0]--;
			recur(value + numbers[depth], depth + 1);
			operations[0]++;
		}
		if(operations[1] != 0){
			operations[1]--;
			recur(value - numbers[depth], depth + 1);
			operations[1]++;
		}
		if(operations[2] != 0){
			operations[2]--;
			recur(value * numbers[depth], depth + 1);
			operations[2]++;
		}
		if(operations[3] != 0){
			operations[3]--;
			recur(value / numbers[depth], depth + 1);
			operations[3]++;
		}
	}
}