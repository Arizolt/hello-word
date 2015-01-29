import java.util.Scanner;

class Permutation {

	String word;
	
	public String findComLet (String str1, String str2) {
		
		boolean[] isUsed = new boolean[str2.length()];
		
		StringBuilder comLet = new StringBuilder();
		
		for ( int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if ( ( str1.charAt(i) == str2.charAt(j) ) && ( isUsed[j] == false ) ) {
					comLet.append( str2.charAt(j) );
					isUsed[j] = true;
				}
			}
		}
		
		return comLet.toString();
		
	}
	
	public String findComLet (String str1, String str2, String str3) {
		return findComLet( findComLet(str1,str2), str3 );
	}
	
	public String findNextPerm () {
		
		StringBuilder word = new StringBuilder(this.word);
		
		int i = word.length() - 2, 
			j = word.length() - 1;
			
		char tmp;
		
		while ( ( i >= 0 ) && ( word.charAt(i) >= word.charAt(i + 1) ) ) {
			
			i--;
			
		}
		
		if (i == -1) {
			
			this.word = "";
			
			return "";
			
		}
		
		while ( ( j >= 0 ) && ( word.charAt(j) <= word.charAt(i) ) ) {
			
			j--;
			
		}
		
		tmp = word.charAt(i);
		
		word.setCharAt(i, word.charAt(j));
		
		word.setCharAt(j, tmp);
		
		StringBuilder tmpStr = new StringBuilder(word);
		
		tmpStr.delete(0, i+1);

		tmpStr.reverse();
		
		word.delete(i+1, word.length() );
		
		word.append(tmpStr);
		
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
		
		//while ( MyWord.word != "") {
			
			MyWord.findNextPerm();
			System.out.println(MyWord.word);
			
		//}
		
		System.out.println(MyWord.findComLet(input.nextLine(), input.nextLine()));
		
	
	}
	
}
