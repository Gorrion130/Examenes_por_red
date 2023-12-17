package com.gorrion130.quizclient;

import java.awt.BorderLayout;
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
import java.awt.event.ActionEvent;

public class QuizClient extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldIP;
	private JTextField textFieldAnswer;
	private JPanel Quiz;
	private question question = new question();
	private puntuacion puntuacion = new puntuacion();
	
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel StartMenu = new JPanel();
		contentPane.add(StartMenu, "name_425184482854100");
		StartMenu.setLayout(null);
		
		JButton startBtn = new JButton("Start");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quiz.setVisible(true);
				StartMenu.setVisible(false);
			}
		});
		startBtn.setBounds(325, 239, 89, 23);
		StartMenu.add(startBtn);
		
		textFieldIP = new JTextField();
		textFieldIP.setToolTipText("192.168.1...");
		textFieldIP.setBounds(223, 184, 286, 20);
		StartMenu.add(textFieldIP);
		textFieldIP.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Introduce la ip:");
		lblNewLabel.setBounds(325, 128, 89, 14);
		StartMenu.add(lblNewLabel);
		
		Quiz = new JPanel();
		Quiz.setVisible(false);
		contentPane.add(Quiz, "name_425214001844500");
		Quiz.setLayout(null);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setBounds(119, 154, 510, 20);
		Quiz.add(textFieldAnswer);
		textFieldAnswer.setColumns(10);
		
		JLabel puntuacion_1 = new JLabel("");
		puntuacion_1.setBounds(29, 22, 46, 14);
		Quiz.add(puntuacion_1);
		
		JLabel preguntaLabel = new JLabel(question.getPregunta());
		question.next();
		preguntaLabel.setBounds(119, 81, 510, 14);
		Quiz.add(preguntaLabel);
		
		JButton btnNewButton = new JButton("Validar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldAnswer.getText().equalsIgnoreCase(question.getRespuesta())) {
					JOptionPane.showMessageDialog(null, "Correcto");
					puntuacion.acierto();
					question.next();
					preguntaLabel.setText(question.getPregunta());
					puntuacion_1.setText(String.valueOf(puntuacion.getPuntuacion()));
					if (preguntaLabel.getText().equals("")) {
						preguntaLabel.setText("Se termino");
						btnNewButton.setEnabled(false);
					}
				} else {
						JOptionPane.showMessageDialog(null, "Incorrecto");
				}
			}
		});
		btnNewButton.setBounds(331, 208, 89, 23);
		Quiz.add(btnNewButton);
	}
}
