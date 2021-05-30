package com.MCO2B.java;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class UnitMergerGUI extends GUI{

	private JLabel mergeIcon;
	private JTable UnitList;
	
	private ImageIcon mergeCharIcon;
	private ImageIcon mergeWeapIcon;
	
	private boolean CharOrWeap;
	private JPanel listContainer;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private String[] columnNames = {"ID",  "Rarity","Name", "Level"};
	private JButton mergeButton;
	private JComboBox<String> AscendingUnit;
	private JComboBox<String> Fodder1Unit;
	private JComboBox<String> Fodder2Unit;
	private JLabel comboboxlabel1;
	private JLabel comboboxlabel2;
	private JLabel comboboxlabel3;

	public UnitMergerGUI(boolean param_CharOrWeap) {
		super(512, 512, "Merge");
		
		this.CharOrWeap = param_CharOrWeap;
		mergeIcon = new JLabel();
		UnitList = new JTable() ;
		listContainer = new JPanel();
		model = new DefaultTableModel(columnNames, 0);
		
		mergeCharIcon = new ImageIcon("src/Image_Assets/charMerge_icon.png");
		mergeWeapIcon = new ImageIcon("src/Image_Assets/weapMerge_icon.png");
		
		mergeButton = new JButton();
		AscendingUnit = new JComboBox<String>();
		Fodder1Unit = new JComboBox<String>();
		Fodder2Unit = new JComboBox<String>();
		
		comboboxlabel1 = new JLabel();
		comboboxlabel2 = new JLabel();
		comboboxlabel3 = new JLabel();

		
		super.LP.add(listContainer);
		listContainer.setBounds(25,25, 240,350);
		
		listContainer.add(UnitList, Integer.valueOf(5));
		listContainer.setLayout(new BorderLayout());
		UnitList.setModel(model);
	
		scroll = new JScrollPane(UnitList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getVerticalScrollBar().setUnitIncrement(20);	
		listContainer.add(scroll);
	
		UnitList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		UnitList.getColumnModel().getColumn(0).setPreferredWidth(35);
		UnitList.getColumnModel().getColumn(1).setPreferredWidth(50);
		UnitList.getColumnModel().getColumn(2).setPreferredWidth(100);
		UnitList.getColumnModel().getColumn(3).setPreferredWidth(52);
		
	
		super.LP.add(AscendingUnit, Integer.valueOf(5));
		AscendingUnit.setBounds(285, 100, 185, 25);
		super.LP.add(comboboxlabel1);
		comboboxlabel1.setText("Ascendant:");
		comboboxlabel1.setBounds(285, 75, 185, 25);
		
		super.LP.add(Fodder1Unit, Integer.valueOf(4));
		Fodder1Unit.setBounds(285, 175, 185, 25);
		super.LP.add(comboboxlabel2);
		comboboxlabel2.setText("Fodder:");
		comboboxlabel2.setBounds(285, 150, 185, 25);
		
		super.LP.add(Fodder2Unit, Integer.valueOf(3));
		Fodder2Unit.setBounds(285, 250, 185, 25);
		super.LP.add(comboboxlabel3);
		comboboxlabel3.setText("Fodder:");
		comboboxlabel3.setBounds(285, 225, 185, 25);
		
		
		super.LP.add(mergeIcon, Integer.valueOf(2));
		mergeIcon.setBounds(425,365,100,100);
		if(this.CharOrWeap == true) {
			mergeIcon.setIcon(mergeCharIcon);
		}else if(this.CharOrWeap == false) {
			mergeIcon.setIcon(mergeWeapIcon);
		}
		
		super.LP.add(mergeButton, Integer.valueOf(2));
		mergeButton.setBounds(285,400,150,50);
		mergeButton.setText("Merge");
		mergeButton.setBackground(new Color(0xA6A6A6));
		mergeButton.setFocusable(false);
		
		super.addBackButton(25, 375, 0);
	}
	
	public JButton getMerge() {
		return this.mergeButton;
	}
	
	public JComboBox<String> getAscendantComboBox(){
		return this.AscendingUnit;
	}
	
	public JComboBox<String> getFodder1ComboBox(){
		return this.Fodder1Unit;
	}
	
	public JComboBox<String> getFodder2ComboBox(){
		return this.Fodder2Unit;
	}
	
	public DefaultTableModel getTableModel() {
		return this.model;
	}

}
