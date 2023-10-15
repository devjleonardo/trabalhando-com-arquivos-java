package _7_exercico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import _7_exercico.entities.Produto;

public class Program {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Produto> produtos = new ArrayList<>();

		System.out.println("Enter file path: ");
		String sourceFileStr = scanner.nextLine();

		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		
		boolean sucesso = new File(sourceFolderStr + "\\out").mkdir();
		
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			String produtoCsv = br.readLine();
			
			while (produtoCsv != null) {
				String[] campos = produtoCsv.split(",");
				String nome = campos[0];
				double preco = Double.parseDouble(campos[1]);
				int quantiodade = Integer.parseInt(campos[2]);

				produtos.add(new Produto(nome, preco, quantiodade));

				produtoCsv = br.readLine();
			}

			try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFileStr))) {
				for (Produto produto : produtos) {
					bufferedWriter.write(produto.getNome() + "," + String.format("%.2f", produto.total()));
					bufferedWriter.newLine();
				}
				System.out.println(targetFileStr + " CRIADO!");
			} catch (IOException e) {
				System.out.println("Erro ao gravar arquivo: " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo: " + e.getMessage());
		}

		scanner.close();
	}
}
