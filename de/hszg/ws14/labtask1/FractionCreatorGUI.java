/**
 * 
 */
package de.hszg.ws13.labtask2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Markus Ullrich
 *
 */
public class FractionCreatorGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 442175100616902911L;

	private JTextField numeratorField, denominatorField, equationField, resultField;
	private JButton createFractionButton, solveEquationButton, addButton, subButton, mulButton, divButton;
	private JList fractionList;
	private DefaultListModel fractionListModel;
	
	public FractionCreatorGUI(){
		super("Fraction Math");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
		pack();
		setVisible(true);
	}

	private void initGUI() {
		numeratorField = new JTextField();
		denominatorField = new JTextField();
		createFractionButton = new JButton("Create Fraction");
		solveEquationButton = new JButton("Solve Equation");
		equationField = new JTextField();
		equationField.setEnabled(false);
		resultField = new JTextField();
		resultField.setEnabled(false);
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		fractionListModel = new DefaultListModel();
		fractionList = new JList(fractionListModel);
		this.setLayout(new BorderLayout(5,5));
		JPanel createAndOperationsPanel = new JPanel(new GridBagLayout());
		JPanel solveAndResultPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(2,2,2,2);
		gc.weightx = 1;
		gc.weighty = 0;
		//numeratorField.setPreferredSize(new Dimension(40,numeratorField.getHeight()));
		createAndOperationsPanel.add(numeratorField, gc);
		gc.gridy = 1;
		createAndOperationsPanel.add(denominatorField, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 3;
		gc.fill = GridBagConstraints.NONE;
		createAndOperationsPanel.add(createFractionButton, gc);
		this.add(createAndOperationsPanel, BorderLayout.WEST);
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 1;
		createAndOperationsPanel.add(addButton, gc);
		gc.gridx = 1;
		createAndOperationsPanel.add(subButton, gc);
		gc.gridx = 2;
		createAndOperationsPanel.add(mulButton, gc);
		gc.gridx = 3;
		createAndOperationsPanel.add(divButton, gc);
		this.add(fractionList, BorderLayout.CENTER);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridheight = 1;
		gc.gridwidth = 5;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(2,2,2,2);
		gc.weightx = 1;
		gc.weighty = 0;
		solveAndResultPanel.add(equationField, gc);
		gc.gridx = 5;
		gc.gridwidth = 2;
		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 0;
		solveAndResultPanel.add(solveEquationButton, gc);
		gc.gridy = 1;
		gc.weightx = 0.4;
		gc.fill = GridBagConstraints.HORIZONTAL;
		solveAndResultPanel.add(resultField, gc);
		this.add(solveAndResultPanel, BorderLayout.SOUTH);
	}
	
}
