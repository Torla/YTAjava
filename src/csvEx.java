

import veicoli.Veicolo;

import java.io.File;
import java.text.NumberFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class csvEx {
  public static void main(String[] args) {
    List<Veicolo> veicoli = new ArrayList<>();
    veicoli.add(new Veicolo("a",1,"1995"));
    veicoli.add(new Veicolo("b",2,"1989"));
    veicoli.add(new Veicolo("c",3,"2008"));
    veicoli.add(new Veicolo("d",4,"2009"));

    Veicolo.saveToCsv(new File("veicoli.csv"),veicoli);

    veicoli = Veicolo.loadFromCsv(new File("veicoli.csv"));

    System.out.println(veicoli);



  }
}
