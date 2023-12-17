package com.gorrion130.quizserver;

import java.net.*;
import java.lang.Thread;

public class network extends Thread {
	private ServerSocket ss;
	private Socket so;
	
	public network() {
	}
	
	public void run() {
		while (QuizServer.getStatus()) {
			try {
				ss = new ServerSocket(8444);
				so = ss.accept();
				if (QuizServer.getStatus()) {
					cliente cli = new cliente(so);
					cli.start();
					ss.close();
				}
			} catch(Exception e) {
			}
		}
	}

	public ServerSocket getSs() {
		return ss;
	}
}
