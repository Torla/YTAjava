import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ScannerEx {
	public static void main(String[] args) {

		List<Integer> listNumber = new ArrayList<>();
		List<Character> listOp = new LinkedList<>();
		Scanner s=null;
		try{
			String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
			s= new Scanner(line);
			s.useDelimiter("\\s*");
			while(s.hasNext()) {
				listNumber.add(s.nextInt());
				listOp.add(s.next().charAt(0));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (NoSuchElementException e){
			System.out.println("Invalid Input");
		}
		finally{if(s!=null) s.close();}
		Integer current=0;
		Integer result = listNumber.get(current++);
		for(Character op:listOp){
			switch (op){
				case '+':
					result+=listNumber.get(current++);
					break;
				case '-':
					result-=listNumber.get(current++);
					break;
				case '=':
					System.out.print(result);
					break;
				default:
					System.out.println("invalid input");
			}
		}
	}
}
