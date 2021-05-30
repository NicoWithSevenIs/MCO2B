package com.MCO2B.java;

import java.awt.FlowLayout;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


//this class facilitates all the movement of Characters and Weapons

public class Handler{

	  //properties
		
		//classes to handle
		private Inventory handle_inventory;
		private Gacha_Machine handle_gacha;
		private Merger handle_merge;
		private Adventure handle_adventure;
		
		private MainMenuGUI MainGUI;
		private AdventureGUI AdvGUI;	
		private InventoryGUI InvGUI;
		private DrawGUI GMGUI;
		private MergerGUI MrgGUI;
		
		private InventoryListGUI CharInvGUI;
		private InventoryListGUI WeapInvGUI;
		private UnitMergerGUI CharMrgGUI;
		private UnitMergerGUI WeapMrgGUI;
		//resources
		private int anima;
		private int refina;
		
	  //constructors

	  public Handler(){
		  
			this.setRefina(1620);
		    this.setAnima(5400);
		    
		    handle_inventory = new Inventory();
		    handle_adventure = new Adventure();
		    handle_gacha = new Gacha_Machine();
		    handle_merge = new Merger();
		    
		    MainGUI = new MainMenuGUI();
		    AdvGUI = new AdventureGUI();
		    InvGUI = new InventoryGUI();
		    GMGUI = new DrawGUI();
		    MrgGUI = new MergerGUI();
		    
		    CharMrgGUI = new UnitMergerGUI(true);
		    WeapMrgGUI = new UnitMergerGUI(false);
		    
		    CharInvGUI = new InventoryListGUI(true);
		    WeapInvGUI = new InventoryListGUI(false);
			
		    implementMainGUI();
		    implementAdventureGUI();
		    implementInventoryGUI();
		    implementDrawGUI();
		    implementMergerGUI();
		    
		    MainGUI.menuToggler(refina, anima);
		    
		    
	  }

	  //methods
	  
	  //getters and setters (and incrementers?)
	  
  		public int getRefina(){
		    return this.refina;
		  }
  		public void setRefina(int param_refina){
		    this.refina = param_refina;
		  }
		public void increaseRefina(float param_increment){
		    this.refina += param_increment;
		  }
		
		public int getAnima(){
		    return this.anima;
		  }
		public void setAnima(int param_anima){
		    this.anima = param_anima;
		  }
		public void increaseAnima(float param_increment){
		    this.anima += param_increment;
		  }

		
		//Button Implementing
		
		public void implementMenuButton(JButton param_button, GUI lower) {
			 param_button.addActionListener(e -> {
				this.MainGUI.menuToggler(refina, anima);
				lower.frameToggler();
				
			});
		}
		
		public void implementBackButton(GUI upper, GUI lower) {
		  
		  lower.getBackButton().addActionListener(e ->{
			 
			  lower.frameToggler();
			  upper.frameToggler();
			  
		  });
		  
		}

		public void implementForwardButton(JButton param_button, GUI upper, GUI lower) {
			
			param_button.addActionListener( e-> {
				upper.frameToggler();
				lower.frameToggler();
			});
		}
		
		public void implementInventoryButton (JButton param_button, GUI upper, GUI lower, boolean isChar) {
			
			param_button.addActionListener( e-> {
				upper.frameToggler();
				lower.frameToggler();
				
				if(isChar == true) {
					loadCharInv(this.CharInvGUI.getTableModel());
					initializeCharacterComboBox(CharInvGUI.getComboBox());
					
					if(this.handle_inventory.getCharArrayList().size() == 0) {
						CharInvGUI.getView().setEnabled(false);
					}else {
						CharInvGUI.getView().setEnabled(true);
					}
					
				}else if(isChar == false) {
					loadWeapInv(this.WeapInvGUI.getTableModel());
					initializeWeaponComboBox(WeapInvGUI.getComboBox());
					 
					if(this.handle_inventory.getWeapArrayList().size() == 0) {
						WeapInvGUI.getView().setEnabled(false);
					}else {
						WeapInvGUI.getView().setEnabled(true);
					}
				}
				
			});
			

		}
		
		public void implementViewer(ViewerGUI param_viewer, int param_index, boolean param_isChar) {
			
			ImageIcon errorIcon = new ImageIcon("src/Image_Assets/error_icon.png");
			ImageIcon alertIcon = new ImageIcon("src/Image_Assets/warning_icon.png");
			
			param_viewer.frameToggler();
			
			param_viewer.updateRefina(this.refina);
			
			if(param_isChar == true) {
				CharInvGUI.frameToggler();
				implementBackButton(CharInvGUI, param_viewer);
				
				param_viewer.getBackButton().addActionListener(e -> {
					loadCharInv(this.CharInvGUI.getTableModel());
				});
				
				loadCharDetails(param_viewer.getModel(), param_index);

			}else if(param_isChar == false) {
				WeapInvGUI.frameToggler();
				implementBackButton(WeapInvGUI, param_viewer);
				
				param_viewer.getBackButton().addActionListener(e -> {
					loadWeapInv(this.WeapInvGUI.getTableModel());
				});
				
				if(this.handle_inventory.getWeapInd(param_index).checkNonNull() == 3) {
					
					param_viewer.addHone();
					if(this.handle_inventory.getWeapInd(param_index).getRanged().getCriticalDamage() >= 2) {
						param_viewer.getHone().setEnabled(false);
					}
					//implements Hone
					param_viewer.getHone().addActionListener( e -> {
						if(JOptionPane.showOptionDialog(null, "Hone? (Costs 10 R)", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, alertIcon, null, 1 ) == 0) {
							if(this.refina >= 10) {
								this.handle_inventory.getWeapInd(param_index).getRanged().Hone();
								this.increaseRefina(-10);
								loadWeapDetails(param_viewer.getModel(), param_index);
								
								if(this.handle_inventory.getWeapInd(param_index).getRanged().getCriticalDamage() >= 2) {
									param_viewer.getHone().setEnabled(false);
								}
								
							}else {
								JOptionPane.showMessageDialog(null, "Insufficient Resources!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );		
							}
						}
					});
				}else if(this.handle_inventory.getWeapInd(param_index).checkNonNull() == 4) {
					param_viewer.addReroll();
					//implements Reroll
					param_viewer.getReroll().addActionListener(e->{
						if(this.refina >= 150) {
							if(JOptionPane.showOptionDialog(null, "Are you sure you want to reroll this weapon?\nThis cannot be undone!", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, alertIcon, null, 1 ) == 0){
								if(this.handle_inventory.getWeapInd(param_index).getAsWeapon().checkIfEquipped() == true) {
									this.handle_inventory.getWeapInd(param_index).getAsWeapon().getHolder().unequipWeapon();
								}
								
								this.handle_inventory.getWeapArrayList().remove(param_index);
								this.handle_inventory.addWeapon(this.handle_gacha.drawWeapon());
								this.increaseRefina(-150);
								initializeWeaponComboBox(this.WeapInvGUI.getComboBox());	
								loadWeapInv(this.WeapInvGUI.getTableModel());
								param_viewer.frameToggler();
								this.WeapInvGUI.frameToggler();
							}
						}else {
							JOptionPane.showMessageDialog(null, "Insufficient Resources!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );		
						}
					});
				}
				
				loadWeapDetails(param_viewer.getModel(), param_index);
				
			}
			
			//Implements LevelUp buttons for both Characters and Weapons
		
			if(param_isChar == true && this.handle_inventory.getCharInd(param_index).getLevel() == 100) {
				param_viewer.getLevelUp().setEnabled(false);
			}else if(param_isChar == false && this.handle_inventory.getWeapInd(param_index).getAsWeapon().getLevel() == 50) {
				param_viewer.getLevelUp().setEnabled(false);
			}
		
			param_viewer.getLevelUp().addActionListener(e -> {
				int desiredlv = 0;
				String holder;
				
				holder =  JOptionPane.showInputDialog("Input Desired Level:");
				
				if(holder != null) {
					try {
						desiredlv = Integer.parseInt(holder);
					}catch (NumberFormatException err) {
						JOptionPane.showMessageDialog(null, "Invalid Input!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );
					}	
				}
				
				if(desiredlv <= this.refina) {
				if(param_isChar == true) {
					
					if(desiredlv < 0 || desiredlv + this.handle_inventory.getCharInd(param_index).getLevel() > 100) {
							JOptionPane.showMessageDialog(null, "Invalid Input!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );			
					}else{
						this.handle_inventory.getCharInd(param_index).levelUp(desiredlv);
	
						this.increaseRefina(-1 * desiredlv);
						param_viewer.updateRefina(this.refina);
						loadCharDetails(param_viewer.getModel(), param_index);
						
						if(this.handle_inventory.getCharInd(param_index).getLevel() == 100) {
							param_viewer.getLevelUp().setEnabled(false);
						}	
					}
				}else if(param_isChar == false) {
					if(desiredlv < 0 || desiredlv + this.handle_inventory.getWeapInd(param_index).getAsWeapon().getLevel() > 50) {					
						JOptionPane.showMessageDialog(null, "Invalid Input!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );			
					}else{
						this.handle_inventory.getWeapInd(param_index).getAsWeapon().levelUp(desiredlv);
					
						this.increaseRefina(-1 * desiredlv);
						param_viewer.updateRefina(this.refina);
						loadWeapDetails(param_viewer.getModel(), param_index);
						
						if(this.handle_inventory.getWeapInd(param_index).getAsWeapon().getLevel() == 50) {
							param_viewer.getLevelUp().setEnabled(false);
						}
					}	
				}
				}else {
					JOptionPane.showMessageDialog(null, "Insufficient Resources!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );		
				}
			});
			
			//Implements EquipButton
			
			if((param_isChar == true && this.handle_inventory.getWeapArrayList().size() == 0) ||
				(param_isChar == false && this.handle_inventory.getCharArrayList().size() == 0))	
				param_viewer.getEquip().setEnabled(false);
		
			
			param_viewer.getEquip().addActionListener(e -> {
				
				int selectedIndex;
				JComboBox<String> list = new JComboBox<String>();
				
				if(param_isChar == true) {
					
					initializeWeaponComboBox(list);
					
					selectedIndex = JOptionPane.showConfirmDialog(null, list, "Select Weapon" , JOptionPane.DEFAULT_OPTION);
					
					if(selectedIndex != -1) {
						
						
						if(this.handle_inventory.getWeapInd(list.getSelectedIndex()).checkNonNull() == 1) {
							this.handle_inventory.getCharInd(param_index).equipWeapon(this.handle_inventory.getWeapInd(list.getSelectedIndex()).getBladed());
						}else if(this.handle_inventory.getWeapInd(list.getSelectedIndex()).checkNonNull() == 2) {
							this.handle_inventory.getCharInd(param_index).equipWeapon(this.handle_inventory.getWeapInd(list.getSelectedIndex()).getMagical());
						}else if(this.handle_inventory.getWeapInd(list.getSelectedIndex()).checkNonNull() == 3) {
							this.handle_inventory.getCharInd(param_index).equipWeapon(this.handle_inventory.getWeapInd(list.getSelectedIndex()).getRanged());
						}else if(this.handle_inventory.getWeapInd(list.getSelectedIndex()).checkNonNull() == 4) {
							this.handle_inventory.getCharInd(param_index).equipWeapon(this.handle_inventory.getWeapInd(list.getSelectedIndex()).getGolden());
						}
						
						loadCharDetails(param_viewer.getModel(), param_index);
					}
					
				}else if(param_isChar == false) {
					
					initializeCharacterComboBox(list);
					
					selectedIndex = JOptionPane.showConfirmDialog(null, list, "Select Character" , JOptionPane.DEFAULT_OPTION);
					
					if(selectedIndex != -1) {
						
						if(this.handle_inventory.getWeapInd(param_index).checkNonNull() == 1) {
							this.handle_inventory.getCharInd(list.getSelectedIndex()).equipWeapon(this.handle_inventory.getWeapInd(param_index).getBladed());
						}else if(this.handle_inventory.getWeapInd(param_index).checkNonNull() == 2) {
							this.handle_inventory.getCharInd(list.getSelectedIndex()).equipWeapon(this.handle_inventory.getWeapInd(param_index).getMagical());
						}else if(this.handle_inventory.getWeapInd(param_index).checkNonNull() == 3) {
							this.handle_inventory.getCharInd(list.getSelectedIndex()).equipWeapon(this.handle_inventory.getWeapInd(param_index).getRanged());
						}else if(this.handle_inventory.getWeapInd(param_index).checkNonNull() == 4) {
							this.handle_inventory.getCharInd(list.getSelectedIndex()).equipWeapon(this.handle_inventory.getWeapInd(param_index).getGolden());
					
						}
					}
					
					loadWeapDetails(param_viewer.getModel(), param_index);
				}
				
			
				
			});
			
			
			//implements UnequipButton
				
			
			param_viewer.getUnequip().addActionListener(e-> {
				
				if(param_isChar == true) {
					
					this.handle_inventory.getCharInd(param_index).unequipWeapon();
					loadCharDetails(param_viewer.getModel(), param_index);
				}else if (param_isChar == false) {
				
					if(this.handle_inventory.getWeapInd(param_index).getAsWeapon().checkIfEquipped() == true) {
						this.handle_inventory.getWeapInd(param_index).getAsWeapon().getHolder().unequipWeapon();
						loadWeapDetails(param_viewer.getModel(), param_index);
					}else {
						JOptionPane.showMessageDialog(null, this.handle_inventory.getWeapInd(param_index).getAsWeapon().getName() + " is not Equipped", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );	
					}
				}
				
			});
			
			
		}
		
		
		public void implementMergerButton(JButton param_button, GUI upper, GUI lower, boolean isChar) {
			
			
			param_button.addActionListener( e-> {
				
				upper.frameToggler();
				lower.frameToggler();
			if(isChar == true) {
				loadCharInv(this.CharMrgGUI.getTableModel());
				initializeCharacterComboBox(CharMrgGUI.getAscendantComboBox());
				initializeCharacterComboBox(CharMrgGUI.getFodder1ComboBox());
				initializeCharacterComboBox(CharMrgGUI.getFodder2ComboBox());

				if(this.handle_inventory.getCharArrayList().size() == 0) {
					CharMrgGUI.getMerge().setEnabled(false);
				}else {
					CharMrgGUI.getMerge().setEnabled(true);
				}
				
			}else if(isChar == false) {
				loadWeapInv(this.WeapMrgGUI.getTableModel());
				
				initializeWeaponComboBox(WeapMrgGUI.getAscendantComboBox());
				initializeWeaponComboBox(WeapMrgGUI.getFodder1ComboBox());
				initializeWeaponComboBox(WeapMrgGUI.getFodder2ComboBox());
				 
					if(this.handle_inventory.getWeapArrayList().size() == 0) {
						WeapMrgGUI.getMerge().setEnabled(false);
					}else {
						WeapMrgGUI.getMerge().setEnabled(true);
					}
				}
			});
		}	
		
		//Main Menu
		
		public void implementMainGUI() {
			

				implementMenuButton(MainGUI.getAdvButton(), AdvGUI);
				implementMenuButton(MainGUI.getInvButton(), InvGUI);

				MainGUI.getGmButton().addActionListener(e -> {
					this.MainGUI.menuToggler(refina, anima);
					GMGUI.drawToggler(anima);
					
				});
				
				implementMenuButton(MainGUI.getMrgButton(), MrgGUI);
				
		}
		
		//Adventure
		public void implementEnemyList(JButton param_button, EnemyGUI enemy_list, int map_index) {
			
			param_button.addActionListener(e->{
				implementEnemyTable(enemy_list.getTableModel(), map_index);
				AdvGUI.frameToggler();
				enemy_list.frameToggler();
			});
		}
			
		public void implementEnemyTable (DefaultTableModel param_table, int param_map_ind) {
			
			String[] rowData = new String[3];
			
			param_table.setRowCount(0);
			
			 for (int i = 0; i < this.handle_adventure.getMapInd(param_map_ind).getEnemyList().size(); i++) {
					
				  if(this.handle_adventure.getMapInd(param_map_ind).getEnemyList().get(i).getQuantity() > 0) {
					  
					  rowData[0] = (""+ this.handle_adventure.getMapInd(param_map_ind).getEnemyList().get(i).getQuantity());
					  
					  rowData[1] = (""+ this.handle_adventure.getMapInd(param_map_ind).getEnemyList().get(i).getName());
					  
					  rowData[2] = (""+ this.handle_adventure.getMapInd(param_map_ind).getEnemyList().get(i).getPower());
				
					  
					  param_table.addRow(rowData);
				  }
			 
			}
		}
				
		public void implementAdventureGUI() {
			
			EnemyGUI UG = new EnemyGUI();
			EnemyGUI FOE = new EnemyGUI();
			EnemyGUI SOH = new EnemyGUI();
			EnemyGUI TOE = new EnemyGUI();
			EnemyGUI CPL = new EnemyGUI();
			
			implementMenuButton(AdvGUI.getBackButton(), AdvGUI);
			
			implementEnemyList(AdvGUI.getUGEnemies(), UG, 0);
			implementEnemyList(AdvGUI.getFOEEnemies(), FOE, 1);
			implementEnemyList(AdvGUI.getSOHEnemies(), SOH, 2);
			implementEnemyList(AdvGUI.getTOEEnemies(), TOE, 3);
			implementEnemyList(AdvGUI.getCPLEnemies(), CPL, 4);
			
			CharSelectAdvGUI advUG = new CharSelectAdvGUI(this.handle_adventure.getMapInd(0).getName(), "src/Image_Assets/UG_icon.png");
			CharSelectAdvGUI advFOE = new CharSelectAdvGUI(this.handle_adventure.getMapInd(1).getName(), "src/Image_Assets/FOE_icon.png");
			CharSelectAdvGUI advSOH = new CharSelectAdvGUI(this.handle_adventure.getMapInd(2).getName(), "src/Image_Assets/SOH_icon.png");
			CharSelectAdvGUI advTOE = new CharSelectAdvGUI(this.handle_adventure.getMapInd(3).getName(), "src/Image_Assets/TOE_icon.png");
			CharSelectAdvGUI advCPL = new CharSelectAdvGUI(this.handle_adventure.getMapInd(4).getName(), "src/Image_Assets/CPL_icon.png");
			
			initializeCharacterSelect(advUG,AdvGUI.pickUGAdv(),0);
			initializeCharacterSelect(advFOE,AdvGUI.pickFOEAdv(),1);
			initializeCharacterSelect(advSOH,AdvGUI.pickSOHAdv(),2);
			initializeCharacterSelect(advTOE,AdvGUI.pickTOEAdv(),3);
			initializeCharacterSelect(advCPL,AdvGUI.pickCPLAdv(),4);

			
			implementBackButton(AdvGUI, UG);
			implementBackButton(AdvGUI, FOE);
			implementBackButton(AdvGUI, SOH);
			implementBackButton(AdvGUI, TOE);
			implementBackButton(AdvGUI, CPL);

		}
		
		public void initializeCharacterSelect(CharSelectAdvGUI param_charSel, JButton param_pick, int param_index) {
			
			ImageIcon errorIcon = new ImageIcon("src/Image_Assets/error_icon.png");
			
			JPanel rewardContainer = new JPanel();
			JLabel rewardRefina = new JLabel();
			JLabel rewardAnima = new JLabel();
			ImageIcon refinaIcon = new ImageIcon("src/Image_Assets/refina_icon.png");
			ImageIcon animaIcon = new ImageIcon("src/Image_Assets/anima_icon.png");
			
			rewardContainer.setSize(300,300);
			rewardContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
			rewardContainer.add(rewardRefina);
			rewardRefina.setIcon(refinaIcon);
			rewardRefina.setIconTextGap(10);
			
			rewardContainer.add(rewardAnima);
			rewardAnima.setIcon(animaIcon);
			rewardAnima.setIconTextGap(10);
			
			
			implementBackButton(AdvGUI, param_charSel);
			
			
			param_pick.addActionListener(e -> {
				if(this.handle_inventory.getCharArrayList().size() >= 2) {
					initializeCharacterComboBox(param_charSel.getFirstCharComboBox());
					initializeCharacterComboBox(param_charSel.getSecondCharComboBox());
					
					this.AdvGUI.frameToggler();
					param_charSel.frameToggler();
					
				} else {
					JOptionPane.showMessageDialog(null, "Have at least 2 Heroes before Adventuring!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );
				}
				
			});
			
			
			param_charSel.getStartADV().addActionListener( e->{
				
				int rewards = 0;
				
				if(param_charSel.getFirstCharComboBox().getSelectedIndex() != param_charSel.getSecondCharComboBox().getSelectedIndex()) {
					
					if((this.handle_inventory.getCharInd(param_charSel.getFirstCharComboBox().getSelectedIndex()).checkEquip() == true)||
							(this.handle_inventory.getCharInd(param_charSel.getSecondCharComboBox().getSelectedIndex()).checkEquip() == true)) {
						
						rewards = this.handle_adventure.initiateAdventure(this.handle_adventure.getMapInd(param_index), 
								this.handle_inventory.getCharInd(param_charSel.getFirstCharComboBox().getSelectedIndex()),
								this.handle_inventory.getCharInd(param_charSel.getSecondCharComboBox().getSelectedIndex()));
						
							this.increaseRefina(rewards);
							this.increaseAnima((int)(rewards * 0.7));
							
							rewardAnima.setText("+" + rewards);
							rewardRefina.setText("+" + (int)(rewards * 0.7));
							
							JOptionPane.showMessageDialog(null, rewardContainer, "Rewards", JOptionPane.PLAIN_MESSAGE);
							
							this.AdvGUI.frameToggler();
							param_charSel.frameToggler();
							
						
					}else{
						JOptionPane.showMessageDialog(null, "Heroes cannot Adventure Unarmed!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Selection. Pick 2 Unique Characters!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );
				}
			});
			
			
			
			
			
		}
	
		//Inventory
		
		
		//Inventory
		public void implementInventoryGUI() {		
			
			implementMenuButton(InvGUI.getBackButton(), InvGUI);
			
			implementInventoryButton(InvGUI.getCharInv(), InvGUI, CharInvGUI, true);
			implementInventoryButton(InvGUI.getWeapInv(), InvGUI, WeapInvGUI, false);
			
			implementBackButton(InvGUI, CharInvGUI);
			implementBackButton(InvGUI, WeapInvGUI);
		
			CharInvGUI.getView().addActionListener(e->{	
				implementViewer(new ViewerGUI(), CharInvGUI.getComboBox().getSelectedIndex(), true);
				
			});	
			
			WeapInvGUI.getView().addActionListener(e ->{
				implementViewer(new ViewerGUI(), WeapInvGUI.getComboBox().getSelectedIndex(), false);
			});
			
		}
		
		public void loadCharInv(DefaultTableModel param_table) {
			
			String[] rowData = new String[4];
			
			param_table.setRowCount(0);
			
			for(int i = 0; i < this.handle_inventory.getCharArrayList().size(); i++) {
				
				rowData[0] = "" + (i+1);
				rowData[1] = "" + this.handle_inventory.getCharInd(i).getRarity();
				rowData[2] = "" + this.handle_inventory.getCharInd(i).getName();
				rowData[3] = "" + this.handle_inventory.getCharInd(i).getLevel();

			
				param_table.addRow(rowData);
			}
			
			
		}
		
		public void loadWeapInv(DefaultTableModel param_table) {
			
			String[] rowData = new String[4];
			
			param_table.setRowCount(0);
			
			for(int i = 0; i < this.handle_inventory.getWeapArrayList().size(); i++) {
				
				rowData[0] = "" + (i+1);
				
				switch(this.handle_inventory.getWeapInd(i).checkNonNull()) {
					case 1: 
						rowData[1] = "" + this.handle_inventory.getWeapInd(i).getBladed().getRarity();
						rowData[2] = "" + this.handle_inventory.getWeapInd(i).getBladed().getName();
						rowData[3] = "" + this.handle_inventory.getWeapInd(i).getBladed().getLevel();	
					break;
					
					case 2:
						rowData[1] = "" + this.handle_inventory.getWeapInd(i).getMagical().getRarity();
						rowData[2] = "" + this.handle_inventory.getWeapInd(i).getMagical().getName();
						rowData[3] = "" + this.handle_inventory.getWeapInd(i).getMagical().getLevel();
					break;
					
					case 3:
						rowData[1] = "" + this.handle_inventory.getWeapInd(i).getRanged().getRarity();
						rowData[2] = "" + this.handle_inventory.getWeapInd(i).getRanged().getName();
						rowData[3] = "" + this.handle_inventory.getWeapInd(i).getRanged().getLevel();
					break;
					
					case 4:
						rowData[1] = "" + this.handle_inventory.getWeapInd(i).getGolden().getRarity();
						rowData[2] = "" + this.handle_inventory.getWeapInd(i).getGolden().getName();
						rowData[3] = "" + this.handle_inventory.getWeapInd(i).getGolden().getLevel();
					break;
				}
				
				param_table.addRow(rowData);
			}
		}
		
		public void initializeCharacterComboBox(JComboBox<String> param_box) {
			
			param_box.removeAllItems();
			for (int i=0; i<this.handle_inventory.getCharArrayList().size(); i++) {
				param_box.addItem("[" + (i+1) + "] " +
							+ this.handle_inventory.getCharInd(i).getRarity() + "R " 
							+ this.handle_inventory.getCharInd(i).getName() + " Lvl. " 
							+ this.handle_inventory.getCharInd(i).getLevel());
			}
			
		}
		
		public void initializeWeaponComboBox(JComboBox<String> param_box) {
			
			param_box.removeAllItems();
			
			
			for (int i=0; i<this.handle_inventory.getWeapArrayList().size(); i++) {
				
				switch(this.handle_inventory.getWeapInd(i).checkNonNull()) {
				case 1: 
					param_box.addItem("[" + (i+1) + "] " +
							+ this.handle_inventory.getWeapInd(i).getBladed().getRarity() + "R "  
							+ this.handle_inventory.getWeapInd(i).getBladed().getName() + " Lvl. " 
							+ this.handle_inventory.getWeapInd(i).getBladed().getLevel());
				break;
				
				case 2:
					param_box.addItem("[" + (i+1) + "] " +
							+ this.handle_inventory.getWeapInd(i).getMagical().getRarity() + "R "  
							+ this.handle_inventory.getWeapInd(i).getMagical().getName() + " Lvl. " 
							+ this.handle_inventory.getWeapInd(i).getMagical().getLevel());
				break;
				
				case 3:
					param_box.addItem("[" + (i+1) + "] " +
							+ this.handle_inventory.getWeapInd(i).getRanged().getRarity() + "R "  
							+ this.handle_inventory.getWeapInd(i).getRanged().getName() + " Lvl. " 
							+ this.handle_inventory.getWeapInd(i).getRanged().getLevel());
				break;
				
				case 4:
					param_box.addItem("[" + (i+1) + "] " +
							+ this.handle_inventory.getWeapInd(i).getGolden().getRarity() + "R "  
							+ this.handle_inventory.getWeapInd(i).getGolden().getName() + " Lvl. " 
							+ this.handle_inventory.getWeapInd(i).getGolden().getLevel());
				break;
			}
				
			}
			
			
			
		}
			
		//Gacha Machine
		
		public void loadCharDetails(DefaultTableModel param_model, int param_index) {
			
			String[] rowData = new String[1];
			
			param_model.setRowCount(0);
			
			rowData[0] = "Name: "+ this.handle_inventory.getCharInd(param_index).getName();
			param_model.addRow(rowData);
			rowData[0] = "Element: " + this.handle_inventory.getCharInd(param_index).getElement();
			param_model.addRow(rowData);
			rowData[0] = "Level: " + this.handle_inventory.getCharInd(param_index).getLevel();
			param_model.addRow(rowData);
			rowData[0] = "Rarity: " + this.handle_inventory.getCharInd(param_index).getRarity();
			param_model.addRow(rowData);
			rowData[0] = "Weapon Type: " + this.handle_inventory.getCharInd(param_index).getWeaponType();
			param_model.addRow(rowData);
			
			if(this.handle_inventory.getCharInd(param_index).checkEquip() == true) {
				rowData[0] = "Equipped Weapon: " + this.handle_inventory.getCharInd(param_index).getWeapon().getName();
			}else if(this.handle_inventory.getCharInd(param_index).checkEquip() == false) {
				rowData[0] = "Equipped Weapon: None";
			}
				
			param_model.addRow(rowData);
		}
		
		public void loadWeapDetails(DefaultTableModel param_model, int param_index) {
			
			String[] rowData = new String[1];
			
			param_model.setRowCount(0);
					
			rowData[0] = "Name: "+ this.handle_inventory.getWeapInd(param_index).getAsWeapon().getName();
			param_model.addRow(rowData);
			rowData[0] = "Level: " + this.handle_inventory.getWeapInd(param_index).getAsWeapon().getLevel();
			param_model.addRow(rowData);
			
			if(this.handle_inventory.getWeapInd(param_index).getAsWeapon().checkIfEquipped() == true) {
				rowData[0] = "Holder: " + this.handle_inventory.getWeapInd(param_index).getAsWeapon().getHolder().getName();
			}else {
				rowData[0] = "Holder: None";
			}
			param_model.addRow(rowData);
			
			switch(this.handle_inventory.getWeapInd(param_index).checkNonNull()) {
				case 1: rowData[0] = "Power: " + this.handle_inventory.getWeapInd(param_index).getBladed().getPower();
						param_model.addRow(rowData);
						rowData[0] = "Rarity: " + this.handle_inventory.getWeapInd(param_index).getBladed().getRarity();
						param_model.addRow(rowData);
						rowData[0] = "Weapon Type: Bladed";
						param_model.addRow(rowData);
						break;
						
				case 2: rowData[0] = "Power: " + this.handle_inventory.getWeapInd(param_index).getMagical().getPower();
						param_model.addRow(rowData);
						rowData[0] = "Rarity: " + this.handle_inventory.getWeapInd(param_index).getMagical().getRarity();
						param_model.addRow(rowData);
						rowData[0] = "Weapon Type: Magical";
						param_model.addRow(rowData);
						break;
				
				case 3:	
						DecimalFormat crit = new DecimalFormat("#.#");
						crit.setRoundingMode(RoundingMode.DOWN);
						rowData[0] = "Power: " + this.handle_inventory.getWeapInd(param_index).getRanged().getPower();
						param_model.addRow(rowData);
						rowData[0] = "Critical Damage: " + crit.format(this.handle_inventory.getWeapInd(param_index).getRanged().getCriticalDamage());
						param_model.addRow(rowData);
						rowData[0] = "Rarity: " + this.handle_inventory.getWeapInd(param_index).getRanged().getRarity();
						param_model.addRow(rowData);
						rowData[0] = "Weapon Type: Ranged";
						param_model.addRow(rowData);
						break;
						
				case 4: rowData[0] = "Power: " + this.handle_inventory.getWeapInd(param_index).getGolden().getPower();
						param_model.addRow(rowData);
						rowData[0] = "Rarity: " + this.handle_inventory.getWeapInd(param_index).getGolden().getRarity();
						param_model.addRow(rowData);
						rowData[0] = "Weapon Type: Golden";
						param_model.addRow(rowData);
						break;		
						
				
			}
			
		}

		//Draw
		
		public void implementDrawGUI() {
			
			ImageIcon alertIcon = new ImageIcon("src/Image_Assets/warning_icon.png");
			ImageIcon errorIcon = new ImageIcon("src/Image_Assets/error_icon.png");
			
			implementMenuButton(GMGUI.getBackButton(), GMGUI);
		
			GMGUI.getSingleCharacterDraw().addActionListener(e ->{
				
				if(this.anima >= 300) {
					
					if(JOptionPane.showOptionDialog(null, "Draw Single Character?", "Tavern Keep", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, alertIcon, null, 1 ) == 0) {
						
						this.handle_inventory.addCharacter(this.handle_gacha.drawCharacter());
						this.increaseAnima(-300);
						GMGUI.refreshAnima(anima);
						
					}
					
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Insufficient Resources", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );
				}
				
			
			});
			
			GMGUI.getTenCharacterDraw().addActionListener(e ->{
				

				if(this.anima >= 2700) {
					
					if(JOptionPane.showOptionDialog(null, "Draw Ten Characters?", "Tavern Keep", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, alertIcon, null, 1 ) == 0) {
						
						this.increaseAnima(300);
						
						for(int i = 0; i< 10 ; i++) {
							this.handle_inventory.addCharacter(this.handle_gacha.drawCharacter());
							this.increaseAnima(-300);
						}
						
						GMGUI.refreshAnima(anima);
						
					}
					
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Insufficient Resources", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon);
				}
				
			});
			
			GMGUI.getSingleWeaponDraw().addActionListener(e-> {
				
				if(this.anima >= 300) {
					
					if(JOptionPane.showOptionDialog(null, "Draw Single Weapon?", "Tavern Keep", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, alertIcon, null, 1 ) == 0) {
						this.handle_inventory.addWeapon(this.handle_gacha.drawWeapon());
						this.increaseAnima(-300);
						GMGUI.refreshAnima(anima);					
					}
						
				}else {
					
					JOptionPane.showMessageDialog(null, "Insufficient Resources", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );
				}
				
			});
			
			GMGUI.getTenWeaponDraw().addActionListener(e-> {
					
				if(this.anima >= 2700) {			
					if(JOptionPane.showOptionDialog(null, "Draw Ten Weapons?", "Tavern Keep", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, alertIcon, null, 1 ) == 0) {					
						this.increaseAnima(300);		
						for(int i = 0; i< 10 ; i++) {
							this.handle_inventory.addWeapon(this.handle_gacha.drawWeapon());
							this.increaseAnima(-300);
						}			
						GMGUI.refreshAnima(anima);			
					}		
				}else {
					JOptionPane.showMessageDialog(null, "Insufficient Resources", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon);
				}
				
			});
		
		}
		
		//Merger
		
		
		public void implementMergerGUI() {
			
			implementMenuButton(MrgGUI.getBackButton(), MrgGUI);
			
			implementMergerButton(MrgGUI.getCharMergeButton(), MrgGUI, CharMrgGUI, true);
			implementMergerButton(MrgGUI.getWeapMergeButton(), MrgGUI, WeapMrgGUI, false);
			
			implementMergeButton(CharMrgGUI.getMerge(), CharMrgGUI.getAscendantComboBox(), CharMrgGUI.getFodder1ComboBox(), CharMrgGUI.getFodder2ComboBox(), true);
			implementMergeButton(WeapMrgGUI.getMerge(), WeapMrgGUI.getAscendantComboBox(), WeapMrgGUI.getFodder1ComboBox(), WeapMrgGUI.getFodder2ComboBox(), false);
			
			implementBackButton(MrgGUI,CharMrgGUI);
			implementBackButton(MrgGUI,WeapMrgGUI);
			
			
		}
		
		
		public void implementMergeButton(JButton param_button, JComboBox<String> Ascendant, JComboBox<String> Fodder1, JComboBox<String> Fodder2, boolean isChar) {
			
			ImageIcon errorIcon = new ImageIcon("src/Image_Assets/error_icon.png");
			
			param_button.addActionListener(e -> {
				
				if((Ascendant.getSelectedIndex() != Fodder1.getSelectedIndex()) && 
						(Fodder1.getSelectedIndex() != Fodder2.getSelectedIndex()) &&
						(Fodder2.getSelectedIndex() != Ascendant.getSelectedIndex())) {
					
						if(isChar == true) {
							
								
								this.handle_merge.CharacterMerge(
										this.handle_inventory.getCharInd(Ascendant.getSelectedIndex()), 
										this.handle_inventory.getCharInd(Fodder1.getSelectedIndex()),
										this.handle_inventory.getCharInd(Fodder2.getSelectedIndex()));
								
								this.handle_inventory.getCharArrayList().removeIf(c -> (c.getName() == "-==!ForRemoval!==-"));
								
								loadCharInv(this.CharMrgGUI.getTableModel());
								initializeCharacterComboBox(Ascendant);
								initializeCharacterComboBox(Fodder1);
								initializeCharacterComboBox(Fodder2);
								
							
							
						}else if(isChar == false) {
							
							this.handle_merge.WeaponMerge(
									this.handle_inventory.getWeapInd(Ascendant.getSelectedIndex()), 
									this.handle_inventory.getWeapInd(Fodder1.getSelectedIndex()),
									this.handle_inventory.getWeapInd(Fodder2.getSelectedIndex()));
							
							this.handle_inventory.getWeapArrayList().removeIf(w -> (w.getAsWeapon().getName() == "-==!ForRemoval!==-"));
							
							loadWeapInv(this.WeapMrgGUI.getTableModel());
							initializeWeaponComboBox(Ascendant);
							initializeWeaponComboBox(Fodder1);
							initializeWeaponComboBox(Fodder2);
						}
						
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Selection. Pick 3 Unique Characters!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );
				}
				
			});
			
		}


}