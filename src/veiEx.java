import veicoli.Veicolo;

import java.io.File;

public class veiEx {
  public static void main(String[] args) {
    // instanzio un veicolo
    Veicolo veicolo = new Veicolo("er900na",80);
    // dichiaro il File
    File file = new File("veicolo");
    // chiamo il metodo save passandoli
    veicolo.save(file);

    veicolo = null;

    veicolo = Veicolo.load(file);

    System.out.println(veicolo.getTarga());
  }
}
