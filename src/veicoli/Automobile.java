package veicoli;


public class Automobile extends Veicolo {

  private Integer numPorte;


  public Automobile(String targa, Integer cilindrata,String anno,Integer numPorte) {
    super(targa, cilindrata,anno);
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
  @Override
  protected String csvString() {
    return String.format("%s,a,%d",super.csvString(),numPorte);
  }

  @Override
  public String toString() {
    return super.toString() + " numPorte:" + numPorte;
  }
}
