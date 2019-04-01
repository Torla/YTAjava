package veicoli;

public class Moto extends Veicolo{
  Integer tempi;
  Integer rapporti;

  public Moto(String targa, Integer cilindrata, String anno, Integer tempi, Integer rapporti) {
    super(targa, cilindrata, anno);
    this.tempi = tempi;
    this.rapporti = rapporti;
  }


  @Override
  protected String csvString() {
    return String.format("%s,m,%d,%d",super.csvString(),tempi,rapporti);
  }

  @Override
  public String toString() {
    return super.toString() + " tempi:" + tempi + " rapp:" + rapporti;
  }
}
