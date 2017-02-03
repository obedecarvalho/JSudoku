package solucao;

import java.util.ArrayList;

import entidades.Tabuleiro;
import gerenciarTabuleiro.GerenciadorListaPossibilidades;
import gerenciarTabuleiro.ValidarTabuleiro;

public class Backtracking {
	
	//public static String resolver(Tabuleiro tabuleiro){		
	public static void resolver(Tabuleiro tabuleiro){
		int casaDisponivel = ValidarTabuleiro.proximaCasaVazia(0, -1, tabuleiro);
		Tabuleiro tabuleiroClone = tabuleiro.clone();
		if (!Backtracking.backtrackingRecursivo(tabuleiroClone, casaDisponivel / 9, casaDisponivel % 9)) System.out.println("Nao ha solucao");
	}
	
	private static boolean backtrackingRecursivo(Tabuleiro tabuleiro, int linha, int coluna) {
		int casaDisponivel;	
		Tabuleiro tabuleiro_bk;
		ArrayList<Integer> possibilidades = (ArrayList<Integer>) tabuleiro.getTabuleiro()[linha][coluna].getPossibilidades().clone();
		for (Integer pos : possibilidades){
			tabuleiro_bk = tabuleiro.clone();
			tabuleiro_bk.setCasa(linha, coluna, pos);
			GerenciadorListaPossibilidades.removerPossibilidadeResolvida(linha, coluna, pos, tabuleiro_bk);
			/*
			try {
				Thread.sleep(200);
				System.out.println(tabuleiro.mostrar());
			} catch (InterruptedException e) {}			
			*/
			if (ValidarTabuleiro.casaValida(linha, coluna, tabuleiro_bk)){
				casaDisponivel = ValidarTabuleiro.proximaCasaVazia(linha, coluna, tabuleiro_bk);				
				if (casaDisponivel != -1){
					if (Backtracking.backtrackingRecursivo(tabuleiro_bk, casaDisponivel/9, casaDisponivel%9)) return true;
				} else {
					if (ValidarTabuleiro.tabuleiroCompleto(tabuleiro_bk)){
						System.out.println(tabuleiro_bk.mostrar());
						return true;
					} else {
						return false;
					}
				}
					
			}

		}
		return false;
			
	}
	
	
}