package com.Platinum.PruebaBD;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class PaginaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField usr;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaLogin frame = new PaginaLogin();
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
	public PaginaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Página de Login");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(20, 11, 174, 33);
		contentPane.add(lblTitulo);
		
		JLabel lblUsr = new JLabel("Usuario");
		lblUsr.setBounds(10, 55, 55, 23);
		contentPane.add(lblUsr);
		
		usr = new JTextField();
		usr.setBounds(10, 76, 184, 20);
		contentPane.add(usr);
		usr.setColumns(10);
		
		JLabel lblPwd = new JLabel("Contraseña");
		lblPwd.setBounds(10, 120, 86, 20);
		contentPane.add(lblPwd);
		
		pwd = new JPasswordField();
		pwd.setBounds(10, 138, 184, 20);
		contentPane.add(pwd);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = 
							DriverManager.getConnection("jdbc:mysql://localhost:3306/bdlogin","root","");
					Statement stmt = con.createStatement();
					String sql = "SELECT * FROM usuario WHERE username ='"+usr.getText()+"' AND password='"+pwd.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
						JOptionPane.showMessageDialog(null, "Login exitoso ");
					else
						JOptionPane.showMessageDialog(null, "Usuario o clave errados");
					con.close();
				}catch(Exception e) {System.out.println(e); }
			}
		});
		btnLogin.setBounds(63, 192, 89, 23);
		contentPane.add(btnLogin);
	}
}
