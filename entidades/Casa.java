package entidades;

import java.util.ArrayList;

public class Casa {
	
	private int valor;
	private boolean mutavel;
	private ArrayList<Integer> possibilidades;
	
	public Casa (int valor, boolean mutavel){
		this.valor = valor;
		this.mutavel = mutavel;
		if (this.mutavel)
			this.possibilidades = new ArrayList<Integer>();		
	}
	
	public int getValor(){
		return this.valor;
	}
	
	public boolean getMutavel(){
		return this.mutavel;
	}
	
	public ArrayList<Integer> getPossibilidades(){
		return this.possibilidades;
	}
	
	public void setValor(int valor){
		if (this.mutavel)
			this.valor = valor;
		return;
	}
	
	public int getPossibilidadePosicao(int posicao){
		if (this.mutavel && this.possibilidades != null && posicao < possibilidades.size())
			return this.possibilidades.get(posicao);
		return -1;
	}
	
	public boolean setValorPossibilidade(int posicao){
		if (this.mutavel && (posicao < this.possibilidades.size())){
			this.valor = this.possibilidades.get(posicao);
			return true;
		}
		return false;
	}
	
	public void addPossibilidade(Integer possibilidade){
		if (this.mutavel && this.possibilidades != null)
			this.possibilidades.add(possibilidade);
		else if (this.possibilidades == null){
			this.possibilidades = new ArrayList<>();
			this.possibilidades.add(possibilidade);
		}
		return;
	}
	
	public void setPossibilidades(ArrayList<Integer> possibilidades){
		if (this.mutavel)
			this.possibilidades = possibilidades;
		return;
	}
	
	public void removerPossibilidade(Integer possibilidade){
		if (this.mutavel && this.possibilidades != null)
			this.possibilidades.remove(possibilidade);
		return;
	}
	
	public Casa clone (){
		Casa casaClone = new Casa(this.valor, this.mutavel);
		casaClone.setPossibilidades((ArrayList<Integer>)this.possibilidades.clone());
		return casaClone;
	}
	
}
