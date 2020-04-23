import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite 3 números para comparação:");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		showResult(max(a, b, c));
	}

	public static int max(int x, int y, int z) {
		if (x > y && x > z) {
			return x;
		}

		if (y > z) {
			return y;
		}

		return z;
	}

	public static void showResult(int value) {
		System.out.printf("O maior valor digitado é: %d", value);
	}
}
