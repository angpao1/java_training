package th.co.extosoft.trainning;

import java.util.ArrayList;

public class TestArrayList {

	public static void main(String args[]) {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("Jack");
		arrList.add("Angpao");
		arrList.add("Jame");
		arrList.add("Jern");
		arrList.add("Kim");
		arrList.add("Nui");
		arrList.add("Fluke");
		
		System.out.println("ArrayList Size --> " + arrList.size());
		
		String data = "";
		for(int i = 0; i < arrList.size(); i++) {
			data = (String)arrList.get(i);
			System.out.println("Name[" + i + "] --> " + data);
		}
	}
	
}
