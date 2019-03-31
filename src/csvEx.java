

import veicoli.Veicolo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class csvEx {
  public static void main(String[] args) {
    List<Veicolo> veicoli = new ArrayList<>();
    veicoli.add(new Veicolo("a",1));
    veicoli.add(new Veicolo("b",2));
    veicoli.add(new Veicolo("c",3));
    veicoli.add(new Veicolo("d",4));

    Veicolo.saveToCsv(new File("veicoli.csv"),veicoli);

    veicoli = Veicolo.loadFromCsv(new File("veicoli.csv"));

    System.out.println(veicoli);

  }
}
