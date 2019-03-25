
import java.io.*;

public class FileEx{

    public static void main(String[] args) {
    	final String nomeFile = "fileDiProva";
	    File file = new File(nomeFile);
	    BufferedWriter bufferedWriter;
	    try {
		    bufferedWriter = new BufferedWriter(new FileWriter(file)) ;
		    bufferedWriter.write("Prova\n");
		    bufferedWriter.close();
	    } catch (IOException e) {
		    e.printStackTrace();
	    }

	    try{
	    	BufferedReader bufferedReader = new BufferedReader(new FileReader(nomeFile));
	    	String line=null;
		    while((line = bufferedReader.readLine()) != null){
			    System.out.println(line);
		    }
	    } catch (IOException e) {
		    e.printStackTrace();
	    }
    }
}
