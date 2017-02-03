package entradaSaida;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Saida {
	
	FileWriter saida;
	BufferedWriter buffer;
	public Saida(String arquivo){
		try {
			saida = new FileWriter(new File (arquivo));
			buffer = new BufferedWriter(saida);
		} catch (IOException e){
			System.out.println("Erro na abertura do arquivo de saida");
		}
	}
	
	public void salvarJogo(String jogo){
		try {
			buffer.write(jogo);
			buffer.newLine();
		} catch (IOException e){
			System.out.println("Erro na escrita do arquivo");
		}
	}
	
	public void fecharArquivo(){
		try {
			buffer.close();
		} catch (IOException e) {
			System.out.println("Arquivo com formato errado");
		}
	}

}