package org.daniel.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Esta clase es la representación de un objeto {@code Movie} y herada de {@link  Film}
 * e implementa {@link IVisualizable}
 * @author dacif
 * @version 1.0
 * @since 2023
 * */
public class Movie extends Film implements IVisualizable {

	private int id;
	private int timeViewed;


	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}


	public int getId() {
		return id;
	}


	public int getTimeViewed() {
		return timeViewed;
	}
	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	@Override
	public String toString() {
		return  "\n :: MOVIE ::" +
				"\n Title: " + getTitle() +
				"\n Genero: " + getGenre() +
				"\n Year: " + getYear() +
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub

		if (dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeViewed(0);
		}


	}

	public static ArrayList<Movie> makeMoviesList() {
		ArrayList<Movie> movies = new ArrayList();

		for (int i = 1; i <= 5; i++) {
			movies.add(new Movie("Movie " + i, "Genero " + i, "Creador " + i, 120+i, (short)(2017+i)));
		}

		return movies;
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void view() {
		this.setViewed(true);
		Date dateI = this.startToSee(new Date());

		for (int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}

		//Termine de verla
		this.stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Viste: " + this.toString());
		System.out.println("Por: " + this.getTimeViewed() + " milisegundos");
	}
}







