import java.util.Scanner;

class Permutation {

	String word;
	
	public static String findNextPerm (String word) {
		
		int i = word.length() - 2, 
			j = word.length() - 1;
		
		while ( ( i >= 0 ) && ( word.charAt(i) >= word.charAt(i + 1) ) ) {
			
			i--;
			
		}
		
		System.out.println("\nНомер i = " + i);
		
		while ( ( j >= 0 ) && ( word.charAt(j) <= word.charAt(i) ) ) {
			
			j--;
			
		}
		
		System.out.println("\nНомер j = " + j);
				
		return "ыыы";
	}
	
	public static void main (String Args[]) {
		
		Scanner input = new Scanner(System.in);	
		
		Permutation MyWord = new Permutation();
		
		System.out.println("Введите строку");
		
		MyWord.word = input.nextLine();
		
		if ( MyWord.word.length() != 5 ) {
			
			System.out.println("Неверно введена строка");
			
		} else {
			
			System.out.println("\nВведеная строка: " + MyWord.word);
			
		}
		
		MyWord.findNextPerm(MyWord.word);
	
	}
	
}
