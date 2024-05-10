package controller;

import java.io.IOException;
import java.util.List;

public interface IFifaController {
	public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException;
	public void desmpilhaBonsBrasileiros(Pilha<String> pilha) throws IOException;
	public List<String> listaRevelacoes(String caminho, String nome) throws IOException;
	public void buscaListaBonsJovens(List<String> lista) throws IOException;
}
