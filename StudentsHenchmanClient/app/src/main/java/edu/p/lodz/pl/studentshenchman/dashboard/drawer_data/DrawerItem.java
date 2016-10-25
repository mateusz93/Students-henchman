package edu.p.lodz.pl.studentshenchman.dashboard.drawer_data;

/**
 * Created by Michał on 2016-10-24.
 */

public class DrawerItem {

	private String name;
	private int icon;

	public DrawerItem(String name, int icon) {
		this.name = name;
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}
}
