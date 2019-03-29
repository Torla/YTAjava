package veicoli;

import java.io.*;


public class Veicolo implements Serializable {
  private String targa;
  private Integer cilindrata;

  public Veicolo(String targa, Integer cilindrata) {
    this.targa = targa;
    this.cilindrata = cilindrata;
  }

  public String getTarga() {
    return targa;
  }

  public Integer getCilindrata() {
    return cilindrata;
  }

  public void setTarga(String targa) {
    this.targa = targa;
  }

  public void setCilindrata(Integer cilindrata) {
    this.cilindrata = cilindrata;
  }

  public void save(File file) {
    //definizione variabile (qui perchè sia visibile fuori dallo stream)
    ObjectOutputStream objectOutputStream = null;
    try {
      // apertura output stream
      objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
      // scrivo l'oggietto nello stream (quindi anche sul file)
      objectOutputStream.writeObject(this);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //chiudo lo stream (nel finally così sono sicuro che venga chiuso)
      try {
        if (objectOutputStream != null) objectOutputStream.close();
      } catch (IOException e) {
      }
    }
  }

  public static Veicolo load(File file) {
    Object object = null;
    ObjectInputStream objectInputStream = null;
    try {
      //istanzio lo stream
      objectInputStream = new ObjectInputStream(new FileInputStream(file));
      //leggo l'oggetto
      object = objectInputStream.readObject();
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
      //solito finally per chiudere lo stream
    } finally {
      try {
        if (objectInputStream != null) objectInputStream.close();
      } catch (IOException e) {
      }
    }
    return (Veicolo) object;

  }

  @Override
  public String toString() {
    return "targa:" + targa + "cil" +cilindrata;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj==null) return false;
    if(!(obj instanceof Veicolo)) return false;
    Veicolo veicolo2 = (Veicolo) obj;
    if(!targa.equals(veicolo2.targa)) return false;
    if(!cilindrata.equals(veicolo2.cilindrata))return false;
    return true;
  }
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
