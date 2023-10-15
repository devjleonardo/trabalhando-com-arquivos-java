package _5_manipulando_pastas_com_file;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String stringDoCaminho = scanner.nextLine();
		
		File caminho = new File(stringDoCaminho);
		
		System.out.println();
		
		File[] pastas = caminho.listFiles(File::isDirectory);
		System.out.println("PASTAS:");
		for (File pasta : pastas) {
			System.out.println(pasta);
		}
		
		System.out.println();
		
		File[] arquivos = caminho.listFiles(File::isFile);
		System.out.println("ARQUIVOS:");
		for (File arquivo : arquivos) {
			System.out.println(arquivo);
		}
		
		System.out.println();
		
		boolean sucesso = new File(stringDoCaminho + "\\subpasta").mkdir();
		System.out.println("Diretório criado com sucesso: " + sucesso);
		
		scanner.close();
	}

}
