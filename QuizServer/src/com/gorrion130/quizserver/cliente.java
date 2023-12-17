package com.gorrion130.quizserver;

import java.lang.Thread;
import java.net.*;

import javax.swing.JTextPane;

import java.io.*;

public class cliente extends Thread {
	
	private Socket so;
	private DataOutputStream out;
	private DataInputStream in;
	
	public cliente(Socket so) throws IOException {
		this.so = so;
		in = new DataInputStream(so.getInputStream());
		out = new DataOutputStream(so.getOutputStream());
	}
	public void run() {
		try {
			QuizServer.addLog(in.readUTF());
			out.writeUTF(QuizServer.getTextFieldQuestion1().getText());
			out.writeUTF(QuizServer.getTextFieldQuestion2().getText());
			out.writeUTF(QuizServer.getTextFieldQuestion3().getText());
			out.writeUTF(QuizServer.getTextFieldQuestion4().getText());
			out.writeUTF(QuizServer.getTextFieldQuestion5().getText());
			out.writeUTF(QuizServer.getTextFieldQuestion6().getText());
			out.writeUTF(QuizServer.getTextFieldQuestion7().getText());
			out.writeUTF(QuizServer.getTextFieldQuestion8().getText());
			out.writeUTF(QuizServer.getTextFieldQuestion9().getText());
			out.writeUTF(QuizServer.getTextFieldQuestion10().getText());
			out.writeUTF("end");
			out.writeUTF(QuizServer.getTextFieldAnswer1().getText());
			out.writeUTF(QuizServer.getTextFieldAnswer2().getText());
			out.writeUTF(QuizServer.getTextFieldAnswer3().getText());
			out.writeUTF(QuizServer.getTextFieldAnswer4().getText());
			out.writeUTF(QuizServer.getTextFieldAnswer5().getText());
			out.writeUTF(QuizServer.getTextFieldAnswer6().getText());
			out.writeUTF(QuizServer.getTextFieldAnswer7().getText());
			out.writeUTF(QuizServer.getTextFieldAnswer8().getText());
			out.writeUTF(QuizServer.getTextFieldAnswer9().getText());
			out.writeUTF(QuizServer.getTextFieldAnswer10().getText());
			out.writeUTF("end");
			QuizServer.addLog(in.readUTF());
		} catch (IOException e) {
		}
	}
}
