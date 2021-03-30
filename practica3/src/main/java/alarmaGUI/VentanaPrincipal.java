package alarmaGUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JList;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import Aplicacion.*;

public class VentanaPrincipal {

	private JFrame frame;
	private Alarmas context;
	
	/*Atributes*/
	JLabel lblHoraAlarma;
	JSpinner timeSpinner;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 616, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		frame.getContentPane().add(panelCentral);
		panelCentral.setLayout(null);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(12, 5, 309, 365);
		panelCentral.add(panelLeft);
		panelLeft.setLayout(null);
		
		JPanel panelIdAlarma = new JPanel();
		panelIdAlarma.setBounds(0, 12, 297, 41);
		panelLeft.add(panelIdAlarma);
		
		JLabel lblIdAlarma = new JLabel("Id Alarma");
		lblIdAlarma.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIdAlarma.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextPane txtpIDalarma = new JTextPane();
		GroupLayout gl_panelIdAlarma = new GroupLayout(panelIdAlarma);
		gl_panelIdAlarma.setHorizontalGroup(
			gl_panelIdAlarma.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdAlarma.createSequentialGroup()
					.addComponent(lblIdAlarma, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpIDalarma, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
					.addGap(12))
		);
		gl_panelIdAlarma.setVerticalGroup(
			gl_panelIdAlarma.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdAlarma.createSequentialGroup()
					.addGap(12)
					.addComponent(txtpIDalarma, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
					.addGap(12))
				.addGroup(gl_panelIdAlarma.createSequentialGroup()
					.addComponent(lblIdAlarma, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelIdAlarma.setLayout(gl_panelIdAlarma);
		
		JPanel panelHoraAlarma = new JPanel();
		panelHoraAlarma.setBounds(0, 85, 297, 41);
		panelLeft.add(panelHoraAlarma);
		panelHoraAlarma.setLayout(null);
		
		lblHoraAlarma = new JLabel("Hora Alarma");
		lblHoraAlarma.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHoraAlarma.setBounds(12, 12, 102, 29);
		panelHoraAlarma.add(lblHoraAlarma);
		
		
		timeSpinner = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date()); 
		timeSpinner.setBounds(149, 0, 148, 41);
		panelHoraAlarma.add(timeSpinner);
		
		JButton btnNuevaAlarma = new JButton("Nueva Alarma");
		btnNuevaAlarma.setBounds(49, 179, 210, 22);
		btnNuevaAlarma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				context.NuevaAlarma(new Alarma(lblHoraAlarma.getText(), (Date) timeSpinner.getValue()));
			}
		});
		panelLeft.add(btnNuevaAlarma);
		
		JButton btnApagar = new JButton("APAGAR");
		btnApagar.setBounds(49, 328, 210, 25);
		panelLeft.add(btnApagar);
		
		JPanel panelRight = new JPanel();
		panelRight.setBounds(329, 5, 287, 365);
		panelCentral.add(panelRight);
		panelRight.setLayout(null);
		
		JPanel panelAlarmasActivas = new JPanel();
		panelAlarmasActivas.setBounds(0, 0, 275, 149);
		panelRight.add(panelAlarmasActivas);
		
		JLabel lblAlarmasActivas = new JLabel("Alarmas Activas");
		
		JList alarmasActivasList = new JList();
		GroupLayout gl_panelAlarmasActivas = new GroupLayout(panelAlarmasActivas);
		gl_panelAlarmasActivas.setHorizontalGroup(
			gl_panelAlarmasActivas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAlarmasActivas.createSequentialGroup()
					.addContainerGap(79, Short.MAX_VALUE)
					.addGroup(gl_panelAlarmasActivas.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelAlarmasActivas.createSequentialGroup()
							.addComponent(alarmasActivasList, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(65))
						.addGroup(Alignment.TRAILING, gl_panelAlarmasActivas.createSequentialGroup()
							.addComponent(lblAlarmasActivas)
							.addGap(73))))
		);
		gl_panelAlarmasActivas.setVerticalGroup(
			gl_panelAlarmasActivas.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelAlarmasActivas.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAlarmasActivas)
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(alarmasActivasList, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
		);
		panelAlarmasActivas.setLayout(gl_panelAlarmasActivas);
		
		JPanel panelAlarmasDesactivadas = new JPanel();
		panelAlarmasDesactivadas.setBounds(0, 161, 275, 204);
		panelRight.add(panelAlarmasDesactivadas);
		panelAlarmasDesactivadas.setLayout(null);
		
		JLabel lblAlarmasDesactivadas = new JLabel("Alarmas Desactivadas");
		lblAlarmasDesactivadas.setBounds(59, 12, 156, 15);
		panelAlarmasDesactivadas.add(lblAlarmasDesactivadas);
		
		JList alarmasDesactivadasList = new JList();
		alarmasDesactivadasList.setBounds(39, 32, 176, 85);
		panelAlarmasDesactivadas.add(alarmasDesactivadasList);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(80, 167, 117, 25);
		panelAlarmasDesactivadas.add(btnEliminar);
		
		JButton btnOff = new JButton("OFF");
		btnOff.setBounds(12, 130, 117, 25);
		panelAlarmasDesactivadas.add(btnOff);
		
		JButton btnOn = new JButton("ON");
		btnOn.setBounds(141, 130, 117, 25);
		panelAlarmasDesactivadas.add(btnOn);
	}
}