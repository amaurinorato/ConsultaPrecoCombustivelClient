

import java.io.File;

public class ThreadFile extends Thread {
	
	private File file;
	private String caminhoDestino;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getCaminhoDestino() {
		return caminhoDestino;
	}
	public void setCaminhoDestino(String caminhoDestino) {
		this.caminhoDestino = caminhoDestino;
	}
	
	public void run() {
		File novo = new File(caminhoDestino + file.getName());
		file.renameTo(novo);
	}
	
	

}
