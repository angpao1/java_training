package th.co.extosoft.trainning;

import java.util.HashMap;

public class TestHashMap {

	public static void main(String args[]) {
		
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("0","Jack");
		hm.put("1","Angpao");
		hm.put("2","Jame");
		hm.put("3","Jern");
		hm.put("4","Kim");
		hm.put("5","Nui");
		hm.put("6","Fluke");
		
		System.out.println("Vector Size --> " + hm.size());
		
		String data = "";
		for(int i = 0; i < hm.size(); i++) {
			data = (String)hm.get("" + i);
			System.out.println("Name[" + i + "] --> " + data);
		}
		
	}
}
