import java.util.Scanner;

class Permutation {

	String word;
	
	public String findNextPerm () {
		
		StringBuilder word = new StringBuilder(this.word);
		
		int i = word.length() - 2, 
			j = word.length() - 1;
			
		char tmp;
		
		while ( ( i >= 0 ) && ( word.charAt(i) >= word.charAt(i + 1) ) ) {
			
			i--;
			
		}
		
		System.out.println("\nНомер i = " + i);
		
		while ( ( j >= 0 ) && ( word.charAt(j) <= word.charAt(i) ) ) {
			
			j--;
			
		}
		
		tmp = word.charAt(i);
		
		word.setCharAt(i, word.charAt(j));
		
		word.setCharAt(j, tmp);
		
		System.out.println("\nНомер j = " + j);
				
		return word.toString();
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
		
		System.out.println("\nНовая строка: " + MyWord.findNextPerm(););
	
	}
	
}
