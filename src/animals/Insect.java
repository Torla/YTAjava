package animals;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.io.*;
import java.util.LinkedList;

public class Insect implements Animal, Serializable {
	public String name;
	private LinkedList<String> waysOfAnnoyingHumans;




	public Insect(String name, LinkedList<String> waysOfAnnoyingHumans) {
		this.name = name;
		this.waysOfAnnoyingHumans = waysOfAnnoyingHumans;
	}

	public Insect(Insect insect){
		this.name=insect.name;
		//this.waysOfAnnoyingHumans = new LinkedList<>(insect.waysOfAnnoyingHumans);
	  this.waysOfAnnoyingHumans = insect.waysOfAnnoyingHumans;
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
		ObjectInputStream os=null;
		Object obj=null;
		try {
			os = new ObjectInputStream(new FileInputStream(file));
			obj = os.readObject();
		}
		catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
		finally {if(os!=null) try {os.close();} catch (IOException e) {}}
		return (Insect) obj;
	}

	@Override
	public String toString() {
		return name + " " + waysOfAnnoyingHumans.toString();
	}

	@Override
	public boolean equals(Object obj) {
	  // se null torno falso
		if(obj==null) return false;
		// controllo che obj sia instanza di insetto
		if(! (obj instanceof Insect)) return false;
		Insect insect = (Insect) obj;
		//if the class extend now you call super
		if(!name.equals(insect.name)) return false;
		if(!waysOfAnnoyingHumans.equals(insect.waysOfAnnoyingHumans)) return false;
		return true;
	}

	@Override
	public int hashCode() {
		//not a good implementation of hash
		return name.hashCode() + waysOfAnnoyingHumans.hashCode();
	}
}
