package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FifaController implements IFifaController {

	private Pilha<String> stack;
	private List<String> lista = new ArrayList<String>();

	public FifaController() {
		stack = new Pilha<>();
	}

	@Override
	public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		File arq = new File(caminho, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] dados = linha.split(",");
				if (dados[5].equals("Brazil")) {
					stack.push(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo invalido.");
		}
		return stack;
	}

	@Override
	public void desmpilhaBonsBrasileiros(Pilha<String> pilha) throws IOException {
		while (!stack.isEmpty()) {
			String jogador = pilha.pop();
			String[] dados = jogador.split(",");

			if (Integer.parseInt(dados[7]) > 80) {
				System.out.println("Nome: " + dados[2] + " / Overall: " + dados[7]);
			}
		}

	}

	public List<String> listaRevelacoes(String caminho, String nome) throws IOException {
		File arq = new File(caminho, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] dados = linha.split(",");
				if (dados[3].equals("Age")) {
				} else {
					if (Integer.parseInt(dados[3]) <= 20) {
						lista.add(linha);
					}
				}

				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo invalido.");
		}
		return lista;
	}

	public void buscaListaBonsJovens(List<String> lista) throws IOException {
		for (int i = lista.size() - 1; i >= 0; i--) {
			String jogador = lista.get(i);
			String[] dados = jogador.split(",");
			if (Integer.parseInt(dados[7]) > 80 && Integer.parseInt(dados[3]) <= 20) {
				System.out.println("Nome: " + dados[2] + " / Idade: " + dados[3] + " / Overall: " + dados[7]);
			}
		}
	}

}
