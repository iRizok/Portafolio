import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int num,fib,fib2;
  
        do{
            System.out.print("Introduce numero mayor que 1: ");
            num= sc.nextInt();
        }while(num<=1);
  
        System.out.println("Los " + num + " primeros números de la serie fibonacci son:");                 

        fib=1;
        fib2=1;

        System.out.print(fib + " ");
        for(int i=2;i<=num;i++){
            System.out.print(fib2 + " ");
            fib2 = fib + fib2;
            fib = fib2 - fib;
        }
        System.out.println();
    }

}
