package main;

import java.util.ArrayList;

public class Calculo {
	
	public static ArrayList<Integer> paresPrimeiro(ArrayList<Integer> numeros) {
		ArrayList<Integer> list = new ArrayList<>();
		if(numeros == null)
			throw new IllegalArgumentException();
		
		for(int i=0; i<numeros.size(); i++) {
			Integer num = numeros.get(i);
			
			if(num == null)
				throw new IllegalArgumentException();
			
			if(num %2 == 0) {
				list.add(num);
			}
		}
		
		for(int i=0; i<numeros.size(); i++) {
			Integer num = numeros.get(i);
			
			if(num == null)
				throw new IllegalArgumentException();
			
			if(num %2 != 0) {
				list.add(num);
			}
		}
		
		return list;
	}
}
