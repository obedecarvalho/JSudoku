package entidades;

import java.util.ArrayList;

public class Tabuleiro {
	private Casa[][] casas = new Casa[9][9];
		
	public Tabuleiro (String tabuleiro){
		for (int i = 0; i < tabuleiro.length(); i++){
			this.casas[i/9][i%9] = new Casa(Character.getNumericValue(tabuleiro.charAt(i)), true);
		}
	}
	
	public Casa[][] getTabuleiro(){
		return this.casas;
	}
	
	public void setCasa(int linha, int coluna, int valor){
		this.casas[linha][coluna].setValor(valor);
		return;
	}
	
	public int getPossibilidadeCasa(int linha, int coluna, int posicao){
		return this.casas[linha][coluna].getPossibilidadePosicao(posicao);
	}
	
	public boolean setCasaPossibilidade(int linha, int coluna, int posicao){
		return this.casas[linha][coluna].setValorPossibilidade(posicao);
	}
	
	public void setPossibilidadeCasa(int linha, int coluna, int possibilidade){
		this.casas[linha][coluna].addPossibilidade(possibilidade);
		return;
	}
	
	public String toString(){
		StringBuilder tabuleiro = new StringBuilder();
		for (int linha = 0; linha < 9; linha++){
			for (int coluna = 0; coluna < 9; coluna++){
				tabuleiro.append(casas[linha][coluna].getValor());
			}			
		}
		return tabuleiro.toString();
	}
	
	//lugar errado
	public String mostrar(){
		StringBuilder tabuleiro = new StringBuilder();
		for (int linha = 0; linha < 9; linha++){
			if (linha%3 == 0) tabuleiro.append("----------------------------------\n");
			for (int coluna = 0; coluna < 9; coluna++){
				if (coluna%3 == 0) tabuleiro.append("| ");
				tabuleiro.append(casas[linha][coluna].getValor() + "  ");
				
			}
			tabuleiro.append("|\n");
			
		}	
		tabuleiro.append("----------------------------------\n");
		return tabuleiro.toString();
	}
	
	//lugar errado
	public void mostrarPossibilidades(){
		for (int linha = 0; linha < 9; linha++){
			for (int coluna = 0; coluna < 9; coluna++){
				System.out.println(this.casas[linha][coluna].getPossibilidades());
			}
		}
	}
	
	
	public Tabuleiro clone(){
		Tabuleiro tabuleiroClone = new Tabuleiro(this.toString());
		Casa [][] casasClone = tabuleiroClone.getTabuleiro();
		for (int linha = 0; linha < 9; linha++){
			for (int coluna = 0; coluna < 9; coluna++){
				casasClone[linha][coluna].setPossibilidades(
						(ArrayList<Integer>)this.casas[linha][coluna].getPossibilidades().clone());
			}
		}
		return tabuleiroClone;
	}
	
}
