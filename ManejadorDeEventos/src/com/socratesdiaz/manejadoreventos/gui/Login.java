package com.socratesdiaz.manejadoreventos.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 450, 427);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 0, 0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Indentif\u00EDquese", TitledBorder.LEADING, TitledBorder.TOP, null, Color.blue));
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
					textField = new JTextField();
					textField.setBounds(202, 45, 114, 19);
					panel_1.add(textField);
					textField.setColumns(10);
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
					textField_1 = new JTextField();
					textField_1.setBounds(214, 22, 114, 19);
					panel_1.add(textField_1);
					textField_1.setColumns(10);
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
					textField_2 = new JPasswordField();
					textField_2.setBounds(212, 10, 114, 19);
					panel_1_1.add(textField_2);
					textField_2.setColumns(10);
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
					textField_3 = new JTextField();
					textField_3.setBounds(213, 5, 114, 19);
					panel_1.add(textField_3);
					textField_3.setColumns(10);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ingresar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
