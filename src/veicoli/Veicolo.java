package veicoli;

import javax.xml.crypto.Data;
import java.io.*;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Veicolo implements Serializable {
  private String targa;
  private Integer cilindrata;
  Year annoFabbricazione;

  static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy");

  public Veicolo(String targa, Integer cilindrata,String anno) {
    this.targa = targa;
    this.cilindrata = cilindrata;
    this.annoFabbricazione = Year.parse(anno);

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
    return "targa:" + targa + " cil:" +cilindrata + " anno di fabbricazione:" + annoFabbricazione.format(formatter);
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
    return targa.hashCode() + cilindrata;
  }

  protected String csvString(){
    return String.format("%s,%d,%s",targa,cilindrata,annoFabbricazione);
  }

  public static void saveToCsv(File file, List<Veicolo> list){
    BufferedWriter bufferedWriter=null;
    try {
      bufferedWriter = new BufferedWriter(new FileWriter(file));
      for(Veicolo veicolo:list){
        bufferedWriter.write(veicolo.csvString());
        bufferedWriter.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      if(bufferedWriter!=null) try {
        bufferedWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static List<Veicolo> loadFromCsv(File file){
    List<Veicolo> ret = new ArrayList<>();
    Scanner scanner=null;
    Veicolo v=null;

    try {
      scanner = new Scanner(new BufferedReader(new FileReader(file)));
      scanner.useDelimiter(",|\\r");
      while(scanner.hasNext()){
        String targa = scanner.next();
        Integer cilindrata = scanner.nextInt();
        String anno = scanner.next();
        String tipo = scanner.next();
        if(tipo.equals("m")){
          Integer tempi = scanner.nextInt();
          Integer rapporti = scanner.nextInt();
          v = new Moto(targa,cilindrata,anno,tempi,rapporti);
        }
        else if(tipo.equals("a")){
          Integer numPorte = scanner.nextInt();
          v = new Automobile(targa,cilindrata,anno,numPorte);
        }
        else {
          v = new Veicolo(targa, cilindrata, anno);
        }
        ret.add(v);
        scanner.nextLine();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    finally {
      if(scanner!=null)scanner.close();
    }
    return ret;
  }



}
