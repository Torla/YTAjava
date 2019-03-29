import animals.Insect;

import java.util.LinkedList;

public class SerEx {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add("a");
		list.add("b");
		list.add("c");
		Insect insect= new Insect("zanzara",list);
		System.out.println(insect);
		insect.save(new java.io.File("insect"));

		insect=null;

		insect = Insect.load(new java.io.File("insect"));

		Insect insect1 = new Insect(insect);

		System.out.println(insect);
	}
}
