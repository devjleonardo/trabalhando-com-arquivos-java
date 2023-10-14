package _1_lendo_arquivo_texto_com_classes_file_e_scanner;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = null;
		
		File file = new File("C:\\in.txt");
		
		try {
			scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
	
}
