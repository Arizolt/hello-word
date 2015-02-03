import java.util.Scanner;
import java.io.*;


public class R4POW {

    String word;

    public void findMyWord () throws IOException{

        String str;



        int i = 0;

        BufferedReader myFile = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File("C:\\dict.txt") ), "UTF8" ) );
                                
        	System.out.println("Длина массива = " + myFile.length);

        //while ((str = myFile.readLine()) != null) {

          //  dict[i] = str;

            //i++;

        //}

        String[] dict = new String[i];

        for ( i = 0; i < dict.length; i++ ) {

            System.out.println( dict[i] );

        }

        myFile.close();

		/*try {

			do {

				str = myFile.readLine();

				System.out.println("DEBUG str = " + str);

				while ( str != null ) {

					if ( str.equals(this.word) )

						System.out.println(str);

					str = myFile.readLine();

				}

				this.findNextPerm();

				myFile.reset();

			} while ( this.word != "" );

		} finally {
			if ( myFile != null) myFile.close();
		}*/
    }

    public static String findComLet (String str1, String str2) {

        boolean[] isUsed = new boolean[str2.length()];

        StringBuilder comLet = new StringBuilder();

        for ( int i = 0; i < str1.length(); i++) {

            for (int j = 0; j < str2.length(); j++) {
                if ( ( str1.charAt(i) == str2.charAt(j) ) && ( isUsed[j] == false ) ) {
                    comLet.append( str2.charAt(j) );
                    isUsed[j] = true;
                    break;
                }
            }
        }
        return comLet.toString();

    }

    public static String findComLet (String str1, String str2, String str3) {
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

        Scanner input = new Scanner(System.in,"UTF-8");

        R4POW MyWord = new R4POW();

        String[] strIn = new String[3];

        System.out.println("Введите строки");

        for ( int i = 0; i < 3; i++ ) {
            System.out.print("Введите " + (i+1) + "строку: ");
            strIn[i] = input.nextLine();
        }

        MyWord.word = findComLet( strIn[0], strIn[1], strIn[2] );

        System.out.println("Общие буквы :" + MyWord.word );

        try {

            MyWord.findMyWord();

        } catch (IOException e) {
            System.exit(0);
        }


    }

}
