package com.socratesdiaz.manejadoreventos.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

import com.socratesdiaz.manejadoreventos.control.MainController;

public class Login extends JDialog {

	private final JPanel contentPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField dbusernameField;
	private JPasswordField dbpasswordField;
	private JTextField dbhostField;

	public Login(JFrame parent, MainController control) {
		super(parent);
		setTitle("Login");
		setBounds(100, 100, 450, 427);
		setLayout(new BorderLayout());
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 0, 0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Indentifíquese", TitledBorder.LEADING, TitledBorder.TOP, null, Color.blue));
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(2, 2, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNombre = new JLabel("Nombre:");
					lblNombre.setBounds(124, 49, 60, 15);
					panel_1.add(lblNombre);
				}
				{
					usernameField = new JTextField();
					usernameField.setBounds(202, 45, 114, 19);
					panel_1.add(usernameField);
					usernameField.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblContrasea = new JLabel("Contraseña:");
					lblContrasea.setBounds(101, 36, 88, 15);
					panel_1.add(lblContrasea);
				}
				{
					passwordField = new JPasswordField();
					passwordField.setBounds(207, 34, 114, 19);
					passwordField.setColumns(10);
					panel_1.add(passwordField);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Acceso a la base de datos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.blue));
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(5, 17, 420, 51);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
					lblNombreDeUsuario.setBounds(56, 24, 140, 15);
					panel_1.add(lblNombreDeUsuario);
				}
				{
					dbusernameField = new JTextField();
					dbusernameField.setBounds(214, 22, 114, 19);
					panel_1.add(dbusernameField);
					dbusernameField.setColumns(10);
				}
			}
			{
				JPanel panel_1_1 = new JPanel();
				panel_1_1.setBounds(5, 68, 420, 51);
				panel.add(panel_1_1);
				panel_1_1.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Contraseña:");
					lblNewLabel.setBounds(106, 12, 88, 15);
					panel_1_1.add(lblNewLabel);
				}
				{
					dbpasswordField = new JPasswordField();
					dbpasswordField.setBounds(212, 10, 114, 19);
					panel_1_1.add(dbpasswordField);
					dbpasswordField.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(5, 119, 420, 51);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("Host:");
					lblNewLabel_1.setBounds(157, 12, 38, 15);
					panel_1.add(lblNewLabel_1);
				}
				{
					dbhostField = new JTextField();
					dbhostField.setBounds(213, 5, 114, 19);
					panel_1.add(dbhostField);
					dbhostField.setColumns(10);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ingresar");
				okButton.setName("Login_OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(control);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setName("Login_Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(control);
			}
		}
		setModalityType(ModalityType.APPLICATION_MODAL);
	}
	
	public JTextField getUsernameField() {
		return usernameField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getDbusernameField() {
		return dbusernameField;
	}

	public JPasswordField getDbpasswordField() {
		return dbpasswordField;
	}

	public JTextField getDbhostField() {
		return dbhostField;
	}

}
