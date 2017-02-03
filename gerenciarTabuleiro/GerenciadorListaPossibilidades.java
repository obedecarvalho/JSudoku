package gerenciarTabuleiro;

import entidades.Casa;
import entidades.Tabuleiro;

public class GerenciadorListaPossibilidades {
	
	public static void calcularPossibilidades(Tabuleiro tabuleiro){
		Casa [][] casas = tabuleiro.getTabuleiro();
		for (int linha = 0; linha < 9; linha++){
			for (int coluna = 0; coluna < 9; coluna++){
				if (casas[linha][coluna].getValor() == 0){
					GerenciadorListaPossibilidades.calcularPossibilidadeCasa(tabuleiro, linha, coluna);
				}
			}
		}
		
	}
	
	public static void removerPossibilidadeResolvida(int linha, int coluna, int possibilidade, Tabuleiro tabuleiro){
		if (possibilidade == -1) return;
		GerenciadorListaPossibilidades.removerPossibilidadeResolvidaLinha(linha, possibilidade, tabuleiro);
		GerenciadorListaPossibilidades.removerPossibilidadeResolvidaColuna(coluna, possibilidade, tabuleiro);
		GerenciadorListaPossibilidades.removerPossibilidadeResolvidaSubtabela(
				ValidarTabuleiro.calcularSubtabela(linha, coluna), 
				possibilidade, tabuleiro);
		tabuleiro.getTabuleiro()[linha][coluna].getPossibilidades().clear();
	}
	
	public static void resolverPossibilidadeUnica(Tabuleiro tabuleiro){
		Casa [][] casas = tabuleiro.getTabuleiro();
		boolean alteracao = true;
		while (alteracao){
			alteracao = false;
		
			for (int linha = 0; linha < 9; linha++){
				for (int coluna = 0; coluna < 9; coluna++){
					if (casas[linha][coluna].getPossibilidades().size() == 1){
						alteracao = true;
						casas[linha][coluna].setValorPossibilidade(0);
						GerenciadorListaPossibilidades.removerPossibilidadeResolvida(linha, coluna, 
								tabuleiro.getPossibilidadeCasa(linha, coluna, 0), tabuleiro);
					}
				}
			}
		}
	}
	
	private static void calcularPossibilidadeCasa(Tabuleiro tabuleiro, int linha, int coluna){
		for (int valor = 1; valor < 10; valor++){
			tabuleiro.setCasa(linha, coluna, valor);
			if (ValidarTabuleiro.casaValida(linha, coluna, tabuleiro)){
				tabuleiro.setPossibilidadeCasa(linha, coluna, valor);
			}
		}
		tabuleiro.setCasa(linha, coluna, 0);
		return;
	}	
	
	private static void removerPossibilidadeResolvidaLinha(int linha, int possibilidade, Tabuleiro tabuleiro){
		Casa [] casas = tabuleiro.getTabuleiro()[linha];
		for (int coluna = 0; coluna < 9; coluna++){
			casas[coluna].removerPossibilidade(possibilidade);
		}
		return;
	}
	
	private static void removerPossibilidadeResolvidaColuna(int coluna, int possibilidade, Tabuleiro tabuleiro){
		Casa [][] casas = tabuleiro.getTabuleiro();
		for (int linha = 0; linha < 9; linha++){
			casas[linha][coluna].removerPossibilidade(possibilidade);
		}
		return;
	}

	private static void removerPossibilidadeResolvidaSubtabela(int subtabela, int possibilidade, Tabuleiro tabuleiro){
		Casa [][] casas = tabuleiro.getTabuleiro();
		int inicioLinha = ValidarTabuleiro.linhaInicialSubtabela(subtabela);
		int inicioColuna = ValidarTabuleiro.colunaInicialSubtabela(subtabela);
		for (int linhaSubtabela = inicioLinha; linhaSubtabela < inicioLinha + 3; linhaSubtabela++){
			for (int colunaSubtabela = inicioColuna; colunaSubtabela < inicioColuna + 3; colunaSubtabela++){
				casas[linhaSubtabela][colunaSubtabela].removerPossibilidade(possibilidade);
			}
		}
		return;
	}

}
