import java.util.Scanner;

public class Fibonacci_recursivo {

	public static void main(String[] args) {
		int num = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el numero para la serie fibonacci");
		num = sc.nextInt();
		int fibonacciNumber = getFibonacci_recursivo(num);
		System.out.println(fibonacciNumber);
	}

	public static int getFibonacci_recursivo(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return getFibonacci_recursivo(n - 1) + getFibonacci_recursivo(n - 2);
	}

}
