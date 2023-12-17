package com.gorrion130.quizclient;

import java.net.*;
import java.io.*;

public class network {
	private Socket so;
	private DataInputStream input;
	private DataOutputStream output;
	
	public network() {
	}
	
	public Boolean connect(String ip) {
		Boolean sucess;
		try {
			so = new Socket(ip, 8444);
			input = new DataInputStream(so.getInputStream());
			output = new DataOutputStream(so.getOutputStream());
			sucess = true;
		} catch(Exception e) {
			sucess = false;
		}
		return sucess;
	}
	
	public void disconnect() {
		try {
			input.close();
			output.close();
			so.close();
		} catch(IOException e) {
		}
	}
	
	public void send(String message) {
		try {
			output.writeUTF(message);
		} catch(IOException e) {
		}
	}
	
	public String receive() throws IOException {	
		return input.readUTF();
	}
}
