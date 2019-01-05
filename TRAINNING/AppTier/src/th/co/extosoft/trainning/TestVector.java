package th.co.extosoft.trainning;

import java.util.Vector;

public class TestVector {

	public static void main(String args[]) {
		
		Vector<String> vec = new Vector<String>();
		vec.add("Jack");
		vec.add("Angpao");
		vec.add("Jame");
		vec.add("Jern");
		vec.add("Kim");
		vec.add("Nui");
		vec.add("Fluke");
		
		System.out.println("Vector Size --> " + vec.size());
		
		String data = "";
		for(int i = 0; i < vec.size(); i++) {
			data = (String)vec.get(i);
			System.out.println("Name[" + i + "] --> " + data);
		}
		
	}
	
}
