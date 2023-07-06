import java.util.LinkedList;
import java.util.Scanner;

public class Linkedlist {
	static LinkedList<Integer> lista = new LinkedList<Integer>();

	public static void main(String[] args) {
		int numero, numero2, a, i = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("0-agregar numero \n");
		System.out.println("1-eliminar numero \n");
		System.out.println("2-imprimir lista \n");
		System.out.println("3-salir \n");
		while (i != 1) {
			System.out.println("\n elija una opcion \n");
			a = in.nextInt();
			switch (a) {
			case 0:
				System.out.println(" inserte el numero deseado \n");
				numero2 = in.nextInt();
				add(numero2);

				break;
			case 1:
				System.out.println(" inserte el numero deseado a eliminar \n");
				numero = in.nextInt();
				eliminar(numero);
				break;
			case 2:
				System.out.println(" la lista es \n");
				System.out.print(lista);
				break;
			case 3:
				System.out.println(" salio \n");
				i = 1;
				break;
			default:
				System.out.println(" opcion no valida \n");
			}
		}
	}

	public static void add(int a) {
		if (lista.isEmpty()) {
			lista.add(a);
		}
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) < a) {
				lista.add(i, a);
				System.out.print(" se agrego el numero solicitado \n");
				System.out.print(lista);
				break;
			}

		}
	}
	public static void eliminar(int a) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) == a) {
				lista.remove(i);
				System.out.print(lista);
			}
		}
	}
}