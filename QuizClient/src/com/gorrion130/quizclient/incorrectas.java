package com.gorrion130.quizclient;

public class incorrectas {
	private int count = 0;
	private String[] incorrectas = new String[11];
	private int[] posIncorrectas = new int[11];
	
	public incorrectas() {
		
	}
	
	public void add(String incorrecta, int pos) {
		incorrectas[count] = incorrecta;
		posIncorrectas[count] = pos;
		count++;
	}
	
	public String get() {
		String text = "";
		for(int i = 0; i < count; i++) {
			text = text+"pregunta "+posIncorrectas[i]+": "+incorrectas[i]+"\n";
		}
		return text;
	}
}
