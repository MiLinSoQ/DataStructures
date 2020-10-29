import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {
	
	public static ArrayList<String> readStringFromFile(String filePath) {
		
		ArrayList<String> words = new ArrayList<>();
		
		if (filePath == null || filePath == "") return words;
		
		Scanner scanner;
		
		try {
			
			File file = new File(filePath);
			if (!file.exists()) return words;
			
			FileInputStream fis = new FileInputStream(file);
			scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
			scanner.useLocale(Locale.ENGLISH);
			
		} catch (Exception e) {
			System.out.println(String.format("Cannot open %s", filePath));
			return words;
		}
		
		while (scanner.hasNextLine()) {
			String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); )
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else {
					i++;
				}
		}
		return words;
	}
	
    private static int firstCharacterIndex(String s, int start){

        for( int i = start ; i < s.length() ; i ++ )
            if( Character.isLetter(s.charAt(i)) )
                return i;
        return s.length();
    }
}