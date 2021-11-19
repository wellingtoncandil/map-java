/*
 * Na contagem de votos de uma eleição, são gerados vários registros
de votação contendo o nome do candidato e a quantidade de votos
(formato .csv) que ele obteve em uma urna de votação. Você deve
fazer um programa para ler os registros de votação a partir de um
arquivo, e daí gerar um relatório consolidado com os totais de cada
candidato.
 */

package ex_fixacao_generics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> urnas = new LinkedHashMap<>();

		System.out.println("Enter the file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != " ") {
				String[] fields = line.split(",");
				String name = fields[0];
				int qtd = Integer.parseInt(fields[1]);

				if (urnas.containsKey(name)) {
					int votesSoFar = urnas.get(name);
					urnas.put(name, qtd + votesSoFar);
				} else {
					urnas.put(name, qtd);
				}

				line = br.readLine();
			}

			line = br.readLine();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String key : urnas.keySet()) {
			System.out.println(key + " : " + urnas.get(key));
		}

		sc.close();
	}
}
