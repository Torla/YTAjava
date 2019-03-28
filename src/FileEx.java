
  import java.io.*;

  public class FileEx{

      public static void main(String[] args) {
        final String nomeFile = "fileDiProva";
        File file = new File(nomeFile);
        BufferedWriter bufferedWriter=null;
        try {
          bufferedWriter = new BufferedWriter(new FileWriter(file)) ;
          bufferedWriter.write("Prova\n");

        } catch (IOException e) {
          e.printStackTrace();
        }
        finally {
          try {if(bufferedWriter!=null)bufferedWriter.close();} catch (IOException e){}
        }

        BufferedReader bufferedReader=null;
        try{
          bufferedReader = new BufferedReader(new FileReader(nomeFile));
          String line=null;
          while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
        finally {
          try {if(bufferedReader!=null)bufferedReader.close();} catch (IOException e){}
        }
      }
  }
