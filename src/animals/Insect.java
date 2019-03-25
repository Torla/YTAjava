package animals;

import java.io.*;
import java.util.LinkedList;

public class Insect implements Animal, Serializable {
	private String name;
	private LinkedList<String> waysOfAnnoyingHumans;

	public Insect(String name, LinkedList<String> waysOfAnnoyingHumans) {
		this.name = name;
		this.waysOfAnnoyingHumans = waysOfAnnoyingHumans;
	}

	public void save(File file){
		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(this);
			os.close();
		}
		catch(IOException e) {e.printStackTrace();}
	}

	public static Insect load(File file) {
		ObjectInputStream os;
		Object obj=null;
		try {
			os = new ObjectInputStream(new FileInputStream(file));
			obj = os.readObject();
			os.close();
		}
		catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
		return (Insect) obj;
	}

	@Override
	public String toString() {
		return name + " " + waysOfAnnoyingHumans.toString();
	}
}
