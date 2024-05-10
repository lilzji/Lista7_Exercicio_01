package view;

import java.io.IOException;

import controller.FifaController;
import controller.IFifaController;

public class Main {

	public static void main(String[] args) {
		IFifaController fifaCont = new FifaController();
		String caminho = "C:\\TEMP";
		String nome = "data.csv";
		try {
			var pilha = fifaCont.empilhaBrasileiros(caminho, nome);
			fifaCont.desmpilhaBonsBrasileiros(pilha);
			var lista = fifaCont.listaRevelacoes(caminho, nome);
			fifaCont.buscaListaBonsJovens(lista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
