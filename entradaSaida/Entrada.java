package entradaSaida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Entrada {
	public FileReader entrada;
	public BufferedReader buffer;
	
	public Entrada(String arquivo){
		try {
			entrada = new FileReader(new File(arquivo));
			buffer = new BufferedReader(entrada);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado");			
		} 
	}
	
	public String nextJogo(){
		try {
			while (!buffer.ready());
			return buffer.readLine();
		} catch (IOException e) {
			System.out.println("Arquivo com formato errado");
			return null;
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
