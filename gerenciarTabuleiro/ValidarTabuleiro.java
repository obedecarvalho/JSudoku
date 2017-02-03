package gerenciarTabuleiro;

import java.util.ArrayList;

import entidades.Casa;
import entidades.Tabuleiro;

public class ValidarTabuleiro {
	
	public static int calcularSubtabela(int linha, int coluna){
		return ((linha / 3) * 3 + (coluna / 3));
	}
	
	public static int linhaInicialSubtabela(int subtabela){
		return ((subtabela / 3) * 3);
	}
	
	public static int colunaInicialSubtabela(int subtabela){
		return ((subtabela % 3) * 3);	
	}
	
	public static boolean tabuleiroValido(Tabuleiro tabuleiro){
		int i = 0;
		while (i < 9 && ValidarTabuleiro.colunaValida(i, tabuleiro) && ValidarTabuleiro.linhaValida(i, tabuleiro)
				&& ValidarTabuleiro.subtabelaValida(i, tabuleiro)) {
			i++;
		}
		if (i == 9)
			return true;
		return false;
	}
	
	public static boolean tabuleiroCompleto(Tabuleiro tabuleiro){
			return !tabuleiro.toString().contains("0");
	}
	
	public static int proximaCasaVazia(int linha, int coluna, Tabuleiro tabuleiro){
		Casa [][] casas = tabuleiro.getTabuleiro();
		int proxColuna = coluna + 1;
		for (int proxLinha = linha; proxLinha < 9; proxLinha++){
			for (;proxColuna < 9; proxColuna++){
				if (casas[proxLinha][proxColuna].getValor() == 0){
					return proxLinha * 9 + proxColuna;
				}
			}
			proxColuna = 0;
		}
		return -1;
	}
	
	public static boolean casaValida(int linha, int coluna, Tabuleiro tabuleiro){
		return	ValidarTabuleiro.colunaValida(coluna, tabuleiro) &&
				ValidarTabuleiro.linhaValida(linha, tabuleiro) &&
				ValidarTabuleiro.subtabelaValida(calcularSubtabela(linha, coluna), tabuleiro);
	}
	
	private static boolean linhaValida(int linha, Tabuleiro tabuleiro){
		
		ArrayList<Integer> valores = new ArrayList<Integer>();
		Casa [] colunas = tabuleiro.getTabuleiro()[linha];
		
		for (int coluna = 0; coluna < 9; coluna++){
			int valor = colunas[coluna].getValor();
			if (valor == 0) {
				continue;
			} else if (valores.contains(valor)){
				return false;	
			} else {
				valores.add(valor);		
			}
		}		
		return true;		
	}
	
	private static boolean colunaValida(int coluna, Tabuleiro tabuleiro){
		
		ArrayList<Integer> valores = new ArrayList<Integer>();
		Casa [][] casas = tabuleiro.getTabuleiro();
		
		for (int linha = 0; linha < 9; linha++){
			int valor = casas[linha][coluna].getValor();
			if (valor == 0) {
				continue;
			} else if (!valores.contains(valor)){
				valores.add(valor);
			} else {
				return false;				
			}
		}		
		return true;		
	}
	
	private static boolean subtabelaValida(int subtabela, Tabuleiro tabuleiro){
		
		ArrayList<Integer> valores = new ArrayList<Integer>();
		Casa [][] casas = tabuleiro.getTabuleiro();
		int inicioLinha = ValidarTabuleiro.linhaInicialSubtabela(subtabela);
		int inicioColuna = ValidarTabuleiro.colunaInicialSubtabela(subtabela);
		for (int linha = inicioLinha; linha < inicioLinha + 3; linha++){
			for (int coluna = inicioColuna; coluna < inicioColuna +3 ; coluna++){
				int valor = casas[linha][coluna].getValor();
				if (valor == 0) {
					continue;
				} else if (!valores.contains(valor)){
					valores.add(valor);
				} else {
					return false;				
				}
			}
		}

		return true;		
	}

}
