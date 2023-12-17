package com.gorrion130.quizserver;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.lang.Thread;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JOptionPane;

public class QuizServer extends JFrame {

	private JPanel contentPane;
	private static JTextField textFieldQuestion1;
	private static JTextField textFieldAnswer1;
	private static JTextField textFieldQuestion2;
	private static JTextField textFieldAnswer2;
	private static JTextField textFieldQuestion3;
	private static JTextField textFieldAnswer3;
	private static JTextField textFieldQuestion4;
	private static JTextField textFieldAnswer4;
	private static JTextField textFieldQuestion5;
	private static JTextField textFieldAnswer5;
	private static JTextField textFieldQuestion6;
	private static JTextField textFieldAnswer6;
	private static JTextField textFieldQuestion7;
	private static JTextField textFieldAnswer7;
	private static JTextField textFieldQuestion8;
	private static JTextField textFieldAnswer8;
	private static JTextField textFieldQuestion9;
	private static JTextField textFieldAnswer9;
	private static JTextField textFieldQuestion10;
	private static JTextField textFieldAnswer10;
	private static Boolean status;
	private static JTextArea textArea;
	private network net;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizServer frame = new QuizServer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnknownHostException 
	 */
	public QuizServer() throws UnknownHostException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 465);
		setResizable(false);
		contentPane = new JPanel();
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel preguntasPanel = new JPanel();
		getContentPane().add(preguntasPanel, "name_591805999525700");
		preguntasPanel.setLayout(null);

		JPanel logPanel = new JPanel();
		logPanel.setVisible(false);
		getContentPane().add(logPanel, "name_591815785638900");
		logPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logPanel.setVisible(true);
				preguntasPanel.setVisible(false);
				status = true;
				net = new network();
				net.start();
			}
		});
		btnNewButton.setBounds(337, 365, 89, 23);
		preguntasPanel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Pregunta 1:");
		lblNewLabel_1.setBounds(34, 41, 69, 14);
		preguntasPanel.add(lblNewLabel_1);
		
		textFieldQuestion1 = new JTextField();
		textFieldQuestion1.setBounds(113, 38, 86, 20);
		preguntasPanel.add(textFieldQuestion1);
		textFieldQuestion1.setColumns(10);
		
		JLabel lblResposta = new JLabel("Resposta 1:");
		lblResposta.setBounds(34, 68, 69, 14);
		preguntasPanel.add(lblResposta);
		
		textFieldAnswer1 = new JTextField();
		textFieldAnswer1.setBounds(113, 65, 86, 20);
		preguntasPanel.add(textFieldAnswer1);
		textFieldAnswer1.setColumns(10);
		
		textFieldQuestion2 = new JTextField();
		textFieldQuestion2.setBounds(113, 111, 86, 20);
		preguntasPanel.add(textFieldQuestion2);
		textFieldQuestion2.setColumns(10);
		
		JLabel lblPregunta = new JLabel("Pregunta 2:");
		lblPregunta.setBounds(34, 114, 69, 14);
		preguntasPanel.add(lblPregunta);
		
		JLabel lblResposta_1 = new JLabel("Resposta 2:");
		lblResposta_1.setBounds(34, 139, 69, 14);
		preguntasPanel.add(lblResposta_1);
		
		textFieldAnswer2 = new JTextField();
		textFieldAnswer2.setBounds(113, 136, 86, 20);
		preguntasPanel.add(textFieldAnswer2);
		textFieldAnswer2.setColumns(10);
		
		textFieldQuestion3 = new JTextField();
		textFieldQuestion3.setBounds(113, 181, 86, 20);
		preguntasPanel.add(textFieldQuestion3);
		textFieldQuestion3.setColumns(10);
		
		JLabel lblPregunta_1 = new JLabel("Pregunta 3:");
		lblPregunta_1.setBounds(34, 184, 69, 14);
		preguntasPanel.add(lblPregunta_1);
		
		JLabel lblResposta_2 = new JLabel("Resposta 3:");
		lblResposta_2.setBounds(34, 207, 69, 14);
		preguntasPanel.add(lblResposta_2);
		
		textFieldAnswer3 = new JTextField();
		textFieldAnswer3.setBounds(113, 204, 86, 20);
		preguntasPanel.add(textFieldAnswer3);
		textFieldAnswer3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pregunta 4:");
		lblNewLabel_2.setBounds(34, 248, 69, 14);
		preguntasPanel.add(lblNewLabel_2);
		
		textFieldQuestion4 = new JTextField();
		textFieldQuestion4.setBounds(113, 245, 86, 20);
		preguntasPanel.add(textFieldQuestion4);
		textFieldQuestion4.setColumns(10);
		
		JLabel label = new JLabel("Resposta 4:");
		label.setBounds(34, 273, 69, 14);
		preguntasPanel.add(label);
		
		textFieldAnswer4 = new JTextField();
		textFieldAnswer4.setBounds(113, 270, 86, 20);
		preguntasPanel.add(textFieldAnswer4);
		textFieldAnswer4.setColumns(10);
		
		JLabel lblPregunta_2 = new JLabel("Pregunta 5:");
		lblPregunta_2.setBounds(302, 114, 69, 14);
		preguntasPanel.add(lblPregunta_2);
		
		textFieldQuestion5 = new JTextField();
		textFieldQuestion5.setBounds(381, 111, 86, 20);
		preguntasPanel.add(textFieldQuestion5);
		textFieldQuestion5.setColumns(10);
		
		JLabel lblResposta_3 = new JLabel("Resposta 5:");
		lblResposta_3.setBounds(302, 139, 69, 14);
		preguntasPanel.add(lblResposta_3);
		
		textFieldAnswer5 = new JTextField();
		textFieldAnswer5.setBounds(381, 136, 86, 20);
		preguntasPanel.add(textFieldAnswer5);
		textFieldAnswer5.setColumns(10);
		
		JLabel lblPregunta_3 = new JLabel("Pregunta 6:");
		lblPregunta_3.setBounds(302, 184, 69, 14);
		preguntasPanel.add(lblPregunta_3);
		
		JLabel lblResposta_4 = new JLabel("Resposta 6:");
		lblResposta_4.setBounds(302, 207, 69, 14);
		preguntasPanel.add(lblResposta_4);
		
		textFieldQuestion6 = new JTextField();
		textFieldQuestion6.setBounds(381, 181, 86, 20);
		preguntasPanel.add(textFieldQuestion6);
		textFieldQuestion6.setColumns(10);
		
		textFieldAnswer6 = new JTextField();
		textFieldAnswer6.setBounds(381, 204, 86, 20);
		preguntasPanel.add(textFieldAnswer6);
		textFieldAnswer6.setColumns(10);
		
		JLabel lblPregunta_4 = new JLabel("Pregunta 7:");
		lblPregunta_4.setBounds(531, 41, 69, 14);
		preguntasPanel.add(lblPregunta_4);
		
		JLabel lblResposta_5 = new JLabel("Resposta 7:");
		lblResposta_5.setBounds(531, 68, 69, 14);
		preguntasPanel.add(lblResposta_5);
		
		textFieldQuestion7 = new JTextField();
		textFieldQuestion7.setBounds(610, 38, 86, 20);
		preguntasPanel.add(textFieldQuestion7);
		textFieldQuestion7.setColumns(10);
		
		textFieldAnswer7 = new JTextField();
		textFieldAnswer7.setBounds(610, 65, 86, 20);
		preguntasPanel.add(textFieldAnswer7);
		textFieldAnswer7.setColumns(10);
		
		JLabel lblPregunta_5 = new JLabel("Pregunta 8:");
		lblPregunta_5.setBounds(531, 114, 69, 14);
		preguntasPanel.add(lblPregunta_5);
		
		JLabel lblResposta_6 = new JLabel("Resposta 8:");
		lblResposta_6.setBounds(531, 139, 69, 14);
		preguntasPanel.add(lblResposta_6);
		
		textFieldQuestion8 = new JTextField();
		textFieldQuestion8.setBounds(610, 111, 86, 20);
		preguntasPanel.add(textFieldQuestion8);
		textFieldQuestion8.setColumns(10);
		
		textFieldAnswer8 = new JTextField();
		textFieldAnswer8.setBounds(610, 136, 86, 20);
		preguntasPanel.add(textFieldAnswer8);
		textFieldAnswer8.setColumns(10);
		
		JLabel lblPregunta_6 = new JLabel("Pregunta 9:");
		lblPregunta_6.setBounds(531, 184, 69, 14);
		preguntasPanel.add(lblPregunta_6);
		
		JLabel lblResposta_7 = new JLabel("Resposta 9:");
		lblResposta_7.setBounds(531, 207, 69, 14);
		preguntasPanel.add(lblResposta_7);
		
		textFieldQuestion9 = new JTextField();
		textFieldQuestion9.setBounds(610, 181, 86, 20);
		preguntasPanel.add(textFieldQuestion9);
		textFieldQuestion9.setColumns(10);
		
		textFieldAnswer9 = new JTextField();
		textFieldAnswer9.setBounds(610, 204, 86, 20);
		preguntasPanel.add(textFieldAnswer9);
		textFieldAnswer9.setColumns(10);
		
		JLabel lblPregunta_7 = new JLabel("Pregunta 10:");
		lblPregunta_7.setBounds(531, 248, 77, 14);
		preguntasPanel.add(lblPregunta_7);
		
		JLabel lblResposta_8 = new JLabel("Resposta 10:");
		lblResposta_8.setBounds(531, 270, 77, 14);
		preguntasPanel.add(lblResposta_8);
		
		textFieldQuestion10 = new JTextField();
		textFieldQuestion10.setBounds(610, 245, 86, 20);
		preguntasPanel.add(textFieldQuestion10);
		textFieldQuestion10.setColumns(10);
		
		textFieldAnswer10 = new JTextField();
		textFieldAnswer10.setBounds(610, 270, 86, 20);
		preguntasPanel.add(textFieldAnswer10);
		textFieldAnswer10.setColumns(10);
		
		JButton btnDetindre = new JButton("Detindre");
		btnDetindre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preguntasPanel.setVisible(true);
				logPanel.setVisible(false);
				status = false;
				try {
					net.getSs().close();
				} catch (IOException e1) {
				}
			}
		});
		btnDetindre.setBounds(337, 365, 89, 23);
		logPanel.add(btnDetindre);
		
		JLabel lblNewLabel = new JLabel("IP:");
		lblNewLabel.setBounds(97, 30, 46, 14);
		logPanel.add(lblNewLabel);
		
		JLabel labelIP = new JLabel(InetAddress.getLocalHost().getHostAddress());
		labelIP.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelIP.setBounds(10, 55, 216, 39);
		logPanel.add(labelIP);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(211, 11, 558, 343);
		//logPanel.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(211, 11, 562, 343);
		logPanel.add(scrollPane);
	}

	public static JTextField getTextFieldQuestion1() {
		return textFieldQuestion1;
	}

	public static JTextField getTextFieldAnswer1() {
		return textFieldAnswer1;
	}

	public static JTextField getTextFieldQuestion2() {
		return textFieldQuestion2;
	}

	public static JTextField getTextFieldAnswer2() {
		return textFieldAnswer2;
	}

	public static JTextField getTextFieldQuestion3() {
		return textFieldQuestion3;
	}

	public static JTextField getTextFieldAnswer3() {
		return textFieldAnswer3;
	}

	public static JTextField getTextFieldQuestion4() {
		return textFieldQuestion4;
	}

	public static JTextField getTextFieldAnswer4() {
		return textFieldAnswer4;
	}

	public static JTextField getTextFieldQuestion5() {
		return textFieldQuestion5;
	}

	public static JTextField getTextFieldAnswer5() {
		return textFieldAnswer5;
	}

	public static JTextField getTextFieldQuestion6() {
		return textFieldQuestion6;
	}

	public static JTextField getTextFieldAnswer6() {
		return textFieldAnswer6;
	}

	public static JTextField getTextFieldQuestion7() {
		return textFieldQuestion7;
	}

	public static JTextField getTextFieldAnswer7() {
		return textFieldAnswer7;
	}

	public static JTextField getTextFieldQuestion8() {
		return textFieldQuestion8;
	}

	public static JTextField getTextFieldAnswer8() {
		return textFieldAnswer8;
	}

	public static JTextField getTextFieldQuestion9() {
		return textFieldQuestion9;
	}

	public static JTextField getTextFieldAnswer9() {
		return textFieldAnswer9;
	}

	public static JTextField getTextFieldQuestion10() {
		return textFieldQuestion10;
	}

	public static JTextField getTextFieldAnswer10() {
		return textFieldAnswer10;
	}

	public static void addLog(String message) {
		textArea.setText(textArea.getText()+message+"\n");
	}

	public static Boolean getStatus() {
		return status;
	}
}
