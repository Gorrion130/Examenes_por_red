package com.gorrion130.quizclient;

public class puntuacion {
	private int puntuacion = 0;
	
	public void acierto() {
		puntuacion++;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
}
