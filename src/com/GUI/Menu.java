package com.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSlider;
import java.awt.Label;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class Menu {

	private JFrame frmAluguelDeCarros;

	/*
	 * Initialize the icons
	 */

	Image icon_novo = new ImageIcon("C:\\Users\\Rodrigo\\workspace\\LocacaoVeiculosJava\\Icons\\ionicons\\plus.png").getImage().getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH);
	Image icon_editar = new ImageIcon("C:\\Users\\Rodrigo\\workspace\\LocacaoVeiculosJava\\Icons\\ionicons\\edit.png").getImage().getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH);
	Image icon_excluir = new ImageIcon("C:\\Users\\Rodrigo\\workspace\\LocacaoVeiculosJava\\Icons\\ionicons\\close.png").getImage().getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH);
	Image icon_listar = new ImageIcon("C:\\Users\\Rodrigo\\workspace\\LocacaoVeiculosJava\\Icons\\ionicons\\navicon-round.png").getImage().getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH);
	
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmAluguelDeCarros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAluguelDeCarros = new JFrame();
		frmAluguelDeCarros.setTitle("AluCar - Menu");
		frmAluguelDeCarros.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rodrigo\\workspace\\LocacaoVeiculosJava\\Icons\\ionicons\\model-s.png").getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH));
		frmAluguelDeCarros.setBackground(Color.WHITE);
		frmAluguelDeCarros.setBounds(100, 100, 607, 425);
		frmAluguelDeCarros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmAluguelDeCarros.setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmInserir = new JMenuItem("Novo");
		mntmInserir.setIcon(new ImageIcon(icon_novo));
		mnCliente.add(mntmInserir);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.setIcon(new ImageIcon(icon_editar));
		mnCliente.add(mntmAlterar);
		
		JMenuItem mntmDeletar = new JMenuItem("Excluir");
		mntmDeletar.setIcon(new ImageIcon(icon_excluir));
		mnCliente.add(mntmDeletar);
		
		JMenu mnVeculo = new JMenu("Gerenciar Ve\u00EDculos");
		menuBar.add(mnVeculo);
		
		JMenuItem mntmNovo = new JMenuItem("Novo");
		mntmNovo.setIcon(new ImageIcon(icon_novo));
		mnVeculo.add(mntmNovo);
		
		JMenuItem mntmAlterar_1 = new JMenuItem("Listar");
		mntmAlterar_1.setIcon(new ImageIcon(icon_listar));
		mnVeculo.add(mntmAlterar_1);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.setIcon(new ImageIcon(icon_excluir));
		mnVeculo.add(mntmExcluir);
		SpringLayout springLayout = new SpringLayout();
		frmAluguelDeCarros.getContentPane().setLayout(springLayout);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				slider.getValue();
			}
		});
		slider.setValue(0);
		slider.setMaximum(1000);
		frmAluguelDeCarros.getContentPane().add(slider);
		
		Label label = new Label("R$ 00,00");
		springLayout.putConstraint(SpringLayout.NORTH, label, 42, SpringLayout.NORTH, frmAluguelDeCarros.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, slider, 5, SpringLayout.EAST, label);
		springLayout.putConstraint(SpringLayout.SOUTH, slider, 0, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, frmAluguelDeCarros.getContentPane());
		frmAluguelDeCarros.getContentPane().add(label);
		
		Label label_1 = new Label("R$ 1000,00");
		springLayout.putConstraint(SpringLayout.WEST, label_1, 6, SpringLayout.EAST, slider);
		springLayout.putConstraint(SpringLayout.SOUTH, label_1, 0, SpringLayout.SOUTH, slider);
		frmAluguelDeCarros.getContentPane().add(label_1);
	}
}
