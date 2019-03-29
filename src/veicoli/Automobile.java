package veicoli;

import java.io.ObjectInputStream;

public class Automobile extends Veicolo {

  Integer numPorte;


  public Automobile(String targa, Integer cilindrata,Integer numPorte) {
    super(targa, cilindrata);
    this.numPorte=numPorte;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj==null) return false;
    if(!(obj instanceof Automobile)) return false;
    if(!super.equals(obj)) return false;
    Automobile automobile = (Automobile) obj;
    if(!numPorte.equals(automobile.numPorte)) return false;
    return true;
  }
}
