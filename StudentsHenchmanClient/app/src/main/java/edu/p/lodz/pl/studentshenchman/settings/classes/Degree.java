package edu.p.lodz.pl.studentshenchman.settings.classes;

/**
 * Created by Michał on 2016-11-11.
 */

public class Degree {
	private String name;
	private Long value;

	public Degree() {
	}

	public Degree(String name, Long value) {

		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Term{" +
				"name='" + name + '\'' +
				", value=" + value +
				'}';

	}
}
