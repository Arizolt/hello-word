import java.util.Scanner;

class Permutation {

	String word;
	
	public String findNextPerm () {
		
		StringBuilder word = new StringBuilder(this.word);
		
		int i = word.length() - 2, 
			j = word.length() - 1;
			
		char tmp;
		
		System.out.println("i = " + i);
		
		while ( ( i >= 0 ) && ( word.charAt(i) >= word.charAt(i + 1) ) ) {
			
			i--;
			
		}
		
		if (i == -1) {
			
			return "";
			
		}
		
		System.out.println("\nНомер i = " + i);
		
		while ( ( j >= 0 ) && ( word.charAt(j) <= word.charAt(i) ) ) {
			
			j--;
			
		}
		
		System.out.println("\nНомер j = " + j);
		
		tmp = word.charAt(i);
		
		word.setCharAt(i, word.charAt(j));
		
		word.setCharAt(j, tmp);
		
		this.word = word.toString();
				
		return this.word;
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
		
		//System.out.println("\nНовая строка: " + MyWord.findNextPerm());
		
		MyWord.findNextPerm();
		
		System.out.println("\nНовая строка: " + MyWord.word);
	
	}
	
}
