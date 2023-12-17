package com.gorrion130.quizclient;

public class question {
	private int count = 0;
	
	private String preguntas[] = {"Que año colon descubrio america?", "Que significas las siglas ARN?", "Que significas las siglas RAE?","2+2"};
	private String respuestas[] = {"1492", "Acido Ribonucleico", "Real Academia Española", "4"};
	private String pregunta = preguntas[count];
	private String respuesta = respuestas[count];
	
	public question() {
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
}
