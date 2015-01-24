import java.util.Scanner;

class Permutation {

	String set;
	
	public static void lex (int pos) {
		if (pos == len) {
			
		}
	}
	
	public static void main (String Args[]) {
		
		Scanner input = new Scanner(System.in);	
		
		Permutation MyWord = new Permutation();
		
		System.out.println("Введите строку");
		
		MyWord.set = input.nextLine();
		
		if ( MyWord.set.length() != 12 ) {
			System.out.println("Неверно введена строка");
		} else {
			System.out.println("\nВведеная строка: " + MyWord.set);
		}
	
	}
	
}
