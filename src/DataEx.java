import java.io.*;

public class DataEx {
  public static void main(String[] args) {
    final String nomeFile = "fileDiProvaData";
    File file = new File(nomeFile);
    DataOutputStream dataOutput=null;

    try {
      dataOutput = new DataOutputStream(new FileOutputStream(file)) ;
      dataOutput.writeInt(101);
      dataOutput.writeInt(102);
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      try {if(dataOutput!=null)dataOutput.close();} catch (IOException e){}
    }

    DataInputStream dataInputStream=null;
    try{
      dataInputStream = new DataInputStream(new FileInputStream(nomeFile));
      int b;
      while(true){
        b = dataInputStream.readInt();
        System.out.println(b);
      }
    } catch (EOFException e){} catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {if(dataInputStream!=null)dataInputStream.close();} catch (IOException e){}
    }
  }
}
