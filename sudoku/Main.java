package sudoku;

import entidades.Tabuleiro;
import entradaSaida.Entrada;
import entradaSaida.Saida;
import gerenciarTabuleiro.GerenciadorListaPossibilidades;
import solucao.Backtracking;

public class Main {
	
	public static void main(String[] args) {
		Entrada fonte = new Entrada("/home/obede/workspace/Sudoku/src/sudoku.txt");
		//Saida saida = new Saida("/home/obede/workspace/TrabalhoIA/src/sudokuResolvidos.txt");
		
		String jogo = fonte.nextJogo();
		
		//String jogo = "000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		//Tabuleiro tabuleiro = new Tabuleiro(jogo);
		//GerenciadorListaPossibilidades.calcularPossibilidades(tabuleiro);
		//Backtracking.resolver(tabuleiro);
		

		while (jogo != null){
			Tabuleiro tabuleiro = new Tabuleiro(jogo);
			GerenciadorListaPossibilidades.calcularPossibilidades(tabuleiro);
			/*
			try {
				Thread.sleep(200);
			} catch (InterruptedException e){}
			*/
			Backtracking.resolver(tabuleiro);
			jogo = fonte.nextJogo();
			
		}
		
		fonte.fecharArquivo();
		//saida.fecharArquivo();		
	}

}