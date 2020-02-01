package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menu_id;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="lvl1_id",referencedColumnName = "lvl1_id")
	private LevelOne lvl1;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="lvl2_id",referencedColumnName = "lvl2_id")
	private LevelTwo lvl2;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="lvl3_id",referencedColumnName = "lvl3_id")
	private LevelThree lvl3;
	
	private String ref;

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public LevelOne getLvl1() {
		return lvl1;
	}

	public void setLvl1(LevelOne lvl1) {
		this.lvl1 = lvl1;
	}

	public LevelTwo getLvl2() {
		return lvl2;
	}

	public void setLvl2(LevelTwo lvl2) {
		this.lvl2 = lvl2;
	}

	public LevelThree getLvl3() {
		return lvl3;
	}

	public void setLvl3(LevelThree lvl3) {
		this.lvl3 = lvl3;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", lvl1=" + lvl1 + ", lvl2=" + lvl2 + ", lvl3=" + lvl3 + ", ref=" + ref
				+ "]";
	}
		
}
