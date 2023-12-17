package com.gorrion130.quizclient;

public class question {
	private int count = 0;
	private int nextPregunta = 0;
	private int nextRespuesta = 0;
	
	private String preguntas[] = new String[11];
	private String respuestas[] = new String[11];
	private String pregunta;
	private String respuesta;
	
	public question() {
		preguntas[10] = "";
	}
	
	public void next() {
		if (count < preguntas.length) {
			pregunta = preguntas[count];
			respuesta = respuestas[count];
			count++;
		} else {
			pregunta = "";
			respuesta = "";
		}
	}
	
	public int questionNum() {
		return preguntas.length;
	}

	public String getPregunta() {
		return pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}
	
	
	public int getCount() {
		return count;
	}

	public String[] getPreguntas() {
		return preguntas;
	}

	public void addPregunta(String pregunta) {
		this.preguntas[nextPregunta] = pregunta;
		nextPregunta++;
	}

	public void addRespuesta(String respuesta) {
		this.respuestas[nextRespuesta] = respuesta;
		nextRespuesta++;
	}

}
