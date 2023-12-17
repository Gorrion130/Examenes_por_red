package com.gorrion130.quizclient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class QuizClient extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldIP;
	private JTextField textFieldAnswer;
	private JPanel Quiz;
	private question question = new question();
	private puntuacion puntuacion = new puntuacion();
	private network net = new network();
	private JTextField textFieldName;
	private incorrectas wrong = new incorrectas();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizClient frame = new QuizClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuizClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 476);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel StartMenu = new JPanel();
		contentPane.add(StartMenu, "name_425184482854100");
		StartMenu.setLayout(null);
		
		Quiz = new JPanel();
		Quiz.setVisible(false);
		contentPane.add(Quiz, "name_425214001844500");
		Quiz.setLayout(null);
		
		JLabel preguntaLabel = new JLabel();
		preguntaLabel.setBounds(119, 81, 510, 14);
		Quiz.add(preguntaLabel);
		
		JButton startBtn = new JButton("Comenzar");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldIP.getText().equals("") && !textFieldName.getText().equals("")) {
					if (net.connect(textFieldIP.getText()))
					{
						net.send(textFieldName.getText()+" s'ha conectat.\n");
						String chunk = "";
						Boolean loop = true;
						while (loop) {
							try {
								chunk = net.receive();
							} catch (IOException e1) {
							}
							if (chunk.equals("end")) {
								loop = false;
							} else {
								question.addPregunta(chunk);
							}
						}	
						loop = true;
						chunk = "";
						while (loop) {
							try {
								chunk = net.receive();
							} catch (IOException e1) {
							}
							if (chunk.equals("end")) {
								loop = false;
							} else {
								question.addRespuesta(chunk);
							}
						}
						question.next();
						preguntaLabel.setText(question.getPregunta());
						Quiz.setVisible(true);
						StartMenu.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Introdueix l'ip correctament");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Emplena tots els camps");
				}
			}
		});
		startBtn.setBounds(325, 259, 101, 23);
		StartMenu.add(startBtn);
		
		textFieldIP = new JTextField();
		textFieldIP.setToolTipText("192.168.1...");
		textFieldIP.setBounds(225, 153, 286, 20);
		StartMenu.add(textFieldIP);
		textFieldIP.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Introdueix la ip:");
		lblNewLabel.setBounds(325, 128, 89, 14);
		StartMenu.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introdueix el teu nom:");
		lblNewLabel_1.setBounds(325, 184, 146, 14);
		StartMenu.add(lblNewLabel_1);
		
		textFieldName = new JTextField();
		textFieldName.setToolTipText("Posa el teu nom aqui");
		textFieldName.setBounds(225, 212, 286, 20);
		StartMenu.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setBounds(119, 154, 510, 20);
		Quiz.add(textFieldAnswer);
		textFieldAnswer.setColumns(10);
		
		JLabel puntuacion_1 = new JLabel("0");
		puntuacion_1.setBounds(29, 22, 27, 14);
		Quiz.add(puntuacion_1);
		
		JButton btnNewButton = new JButton("Valida-ho");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldAnswer.getText().equalsIgnoreCase(question.getRespuesta())) {
					JOptionPane.showMessageDialog(null, "Correcte");
					puntuacion.acierto();
					question.next();
					preguntaLabel.setText(question.getPregunta());
					textFieldAnswer.setText("");
					puntuacion_1.setText(String.valueOf(puntuacion.getPuntuacion()));
				} else {
						JOptionPane.showMessageDialog(null, "Incorrecte");
						question.next();
						preguntaLabel.setText(question.getPregunta());
						wrong.add(textFieldAnswer.getText(), question.getCount()-1);
						textFieldAnswer.setText("");
				}
				if (preguntaLabel.getText().equals("")) {
					preguntaLabel.setText("S'ha terminat");
					btnNewButton.setEnabled(false);
					textFieldAnswer.setEnabled(false);
					net.send(textFieldName.getText()+" ha encertat "+puntuacion.getPuntuacion()+"/"+String.valueOf((question.getCount() - 1))+".\nIncorrectes:\n"+wrong.get());
					net.disconnect();
				}
			}
		});
		btnNewButton.setBounds(331, 208, 89, 23);
		Quiz.add(btnNewButton);
	}
}
