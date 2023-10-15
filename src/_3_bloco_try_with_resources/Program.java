package _3_bloco_try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		String path = "c:\\in.txt";
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			String line = bufferedReader.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}
