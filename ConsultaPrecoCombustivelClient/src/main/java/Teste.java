import java.io.File;

public class Teste {

	public static void main(String[] args) {
		long tempo = System.currentTimeMillis();
		System.out.println(tempo);
		File directory = new File("D:\\teste_files\\");
		
		File[] files = directory.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			if(files[i].isFile()) {
				ThreadFile thread = new ThreadFile();
				thread.setCaminhoDestino("D:\\teste_files\\processed\\");
				thread.setFile(files[i]);
				thread.run();
			}
		}
		
		tempo = System.currentTimeMillis() - tempo;
		System.out.println(tempo);
	}

}
