package _6_informacoes_do_caminho_do_arquivo;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Insira o caminho da pasta: ");
		String stringDoCaminhoDaPasta = scanner.nextLine();
		
		File caminho = new File(stringDoCaminhoDaPasta);
		
		// Pega somente o nome do arquivo sem o caminho
		System.out.println("getName: " + caminho.getName());
		
		// Pega somente o caminho sem o nome do arquivo
		System.out.println("getParent: " + caminho.getParent());
		
		// Pega o caminho completo juntamente com o nome do arquivo
		System.out.println("getPath" + caminho.getPath());
		
		scanner.close();
	}

}
