package org.daniel.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Esta clase es la representación de un objeto {@code Magazine} y herada de {@link  Publication}
 * e implementa {@link IVisualizable}
 * @author dacif
 * @version 1.0
 * @since 2023
 * */
public class Magazine extends Publication {

	private int id;

	public Magazine(String title, Date edititionDate, String editorial) {
		super(title, edititionDate, editorial);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		String detailMagazine = "\n :: MAGAZINE ::" +
				"\n Title: " + getTitle() +
				"\n Editorial: " + getEditorial() +
				"\n Edition Date: " + getEdititionDate() +
				"\n Authors: ";
		for (int i = 0; i < getAuthors().length; i++) {
			detailMagazine += "\t" + getAuthors()[i] + " ";
		}
		return  detailMagazine;
	}

	public static ArrayList<Magazine> makeMagazineList() {
		ArrayList<Magazine> magazines = new ArrayList();
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] = "author "+i;
		}
		for (int i = 1; i <= 5; i++) {
			magazines.add(new Magazine("Magazine " + i, new Date(), "Editorial " + i));
		}

		return magazines;
	}

}
