package com.MCO2B.java;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EnemyGUI extends GUI{
	
	private String[] columnNames = {"Quantity", "Name", " Power"};
	private DefaultTableModel model;
	private JTable population;
	private JScrollPane scroll;
	private JPanel nested;
	
	public EnemyGUI() {
		super(352,352, "Enemies");
		
		model = new DefaultTableModel(columnNames, 0);
		population = new JTable();
		nested = new JPanel();
		
		super.LP.add(nested);
		nested.setBounds(10,10,315,215);
		nested.setLayout(new BorderLayout());
	
		nested.add(population);
  		population.setModel(model);
  		
  		scroll = new JScrollPane(population, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getVerticalScrollBar().setUnitIncrement(20);	
		nested.add(scroll);
		
		super.addBackButton(25,225,0);
		

	}
	
	public DefaultTableModel getTableModel() {
		return this.model;
	}

	

}
