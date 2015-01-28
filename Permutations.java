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
		
		if (i == -1) {
			
			MyWord.word = "";
			
			return "";
			
		}
		
		while ( ( j >= 0 ) && ( word.charAt(j) <= word.charAt(i) ) ) {
			
			j--;
			
		}
		
		System.out.println("\nНомер j = " + j);
		
		tmp = word.charAt(i);
		
		word.setCharAt(i, word.charAt(j));
		
		word.setCharAt(j, tmp);
		
		StringBuilder tmpStr = new StringBuilder(word);
		
		tmpStr.delete(0, i+1);

		tmpStr.reverse();
		
		word.delete(i+1, word.length() );
		
		word.append(tmpStr);
		
		System.out.println("word = " + word);
		
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
		
		while ( MyWord.word != "") {
			
			MyWord.findNextPerm();
			System.out.println(MyWord.word);
			
		}
		
	
	}
	
}
