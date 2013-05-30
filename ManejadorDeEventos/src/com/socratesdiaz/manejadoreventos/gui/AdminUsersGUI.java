package com.socratesdiaz.manejadoreventos.gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Frame;

import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

import com.socratesdiaz.manejadoreventos.control.MainController;

public class AdminUsersGUI extends JDialog {
	private JTextField nameTextField;
	private JPasswordField passwordTextField;
	private JTextField nameTextField2;
	private JPasswordField passwordTextField2;
	private JList userList;

	public AdminUsersGUI(Frame parent, MainController control) {
		super(parent);
		setBounds(100, 100, 518, 300);
		getContentPane().setLayout(null);
		
		{
			JPanel panel = new JPanel();
			panel.setBounds(12, 12, 106, 242);
			getContentPane().add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			userList = new JList();
			panel.add(userList, BorderLayout.CENTER);
			
			JPanel panel_1 = new JPanel();
			panel.add(panel_1, BorderLayout.SOUTH);
			panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
			JButton btnNewUser = new JButton("", new ImageIcon("iconos/add.png"));
			panel_1.add(btnNewUser);
		
			JButton btnDelete = new JButton("", new ImageIcon("iconos/cross.png"));
			panel_1.add(btnDelete);
		}
		
		{
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Información sobre el usuario seleccionado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(130, 0, 374, 254);
			getContentPane().add(panel_3);
			panel_3.setLayout(new CardLayout(0, 0));
			
			JPanel panel_2 = new JPanel();
			panel_3.add(panel_2, "readInfoUser");
			panel_2.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(12, 12, 70, 15);
			panel_2.add(lblNombre);
			
			nameTextField = new JTextField();
			nameTextField.setEditable(false);
			nameTextField.setBounds(12, 39, 114, 19);
			panel_2.add(nameTextField);
			nameTextField.setColumns(10);
			
			JLabel lblTipo = new JLabel("Tipo");
			lblTipo.setBounds(235, 12, 70, 15);
			panel_2.add(lblTipo);
			
			JLabel lblNewLabel = new JLabel("...");
			lblNewLabel.setBounds(235, 39, 117, 17);
			panel_2.add(lblNewLabel);
			
			JLabel lblContrasea = new JLabel("Contraseña");
			lblContrasea.setBounds(12, 70, 114, 15);
			panel_2.add(lblContrasea);
			
			passwordTextField = new JPasswordField();
			passwordTextField.setEditable(false);
			passwordTextField.setEnabled(false);
			passwordTextField.setBounds(12, 97, 114, 19);
			panel_2.add(passwordTextField);
			passwordTextField.setColumns(10);
			
			JLabel lblFechaDeCreacin = new JLabel("Fecha de creación:");
			lblFechaDeCreacin.setBounds(12, 155, 133, 15);
			panel_2.add(lblFechaDeCreacin);
			
			JLabel label = new JLabel("../../..");
			label.setBounds(12, 182, 70, 15);
			panel_2.add(label);
			
			JButton btnEditar = new JButton("Editar");
			btnEditar.setBounds(235, 195, 117, 25);
			panel_2.add(btnEditar);
			
			JPanel panel_4 = new JPanel();
			panel_3.add(panel_4, "writeInfoUser");
			panel_4.setLayout(null);
			
			JLabel label_1 = new JLabel("Nombre:");
			label_1.setBounds(12, 12, 70, 15);
			panel_4.add(label_1);
			
			nameTextField2 = new JTextField();
			nameTextField2.setBounds(12, 39, 114, 19);
			nameTextField2.setColumns(10);
			panel_4.add(nameTextField2);
			
			JLabel label_2 = new JLabel("Tipo");
			label_2.setBounds(235, 12, 70, 15);
			panel_4.add(label_2);
			
			JLabel label_3 = new JLabel("Contraseña");
			label_3.setBounds(12, 70, 114, 15);
			panel_4.add(label_3);
			
			passwordTextField2 = new JPasswordField();
			passwordTextField2.setBounds(12, 97, 114, 19);
			passwordTextField2.setColumns(10);
			panel_4.add(passwordTextField2);
			
			JLabel label_4 = new JLabel("Fecha de creación:");
			label_4.setBounds(12, 155, 133, 15);
			panel_4.add(label_4);
			
			JLabel label_5 = new JLabel("../../..");
			label_5.setBounds(12, 182, 70, 15);
			panel_4.add(label_5);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(235, 39, 117, 17);
			panel_4.add(comboBox);
			
			JButton button = new JButton("Editar");
			button.setBounds(235, 195, 117, 25);
			panel_4.add(button);
		}

	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public JPasswordField getPasswordTextField() {
		return passwordTextField;
	}

	public JTextField getNameTextFieldFromPanel2() {
		return nameTextField2;
	}

	public JPasswordField getPasswordTextFieldFromPanel2() {
		return passwordTextField2;
	}

	public JList getUserList() {
		return userList;
	}
	
}
