package org.daniel.model;

import org.daniel.util.AmazonUtil;

import java.util.ArrayList;
import java.util.Date;

/**
 * Esta clase es la representación de un objeto {@code Book} y herada de {@link  Publication}
 * e implementa {@link IVisualizable}
 * @author dacif
 * @version 1.0
 * @since 2023
 * */
public class Book extends Publication implements IVisualizable {
	private int id;
	private String isbn;
	private boolean read;
	private int timeRead;
	private ArrayList<Page> pages;


	/**
	 * Método constructor de la clase {@code Book}
	 * */
	public Book(String title, Date edititionDate, String editorial, String[] authors, ArrayList<Page> pages) {
		super(title, edititionDate, editorial);
		this.pages = pages;
		setAuthors(authors);
	}


	public int getId() {
		return id;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	/**
	 * Determina si el libro ha sido leído o no.
	 * */
	public String isRead() {
		String leido = "";
		if(read) {
			leido = "Sí";
		}else {
			leido = "No";
		}

		return leido;
	}


	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean getIsRead() {
		return read;
	}


	public int getTimeRead() {
		return timeRead;
	}


	public void setTimeRead(int timeRead) {
		this.timeRead = timeRead;
	}

	public ArrayList<Page> getPages() {
		return pages;
	}

	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		String detailBook = "\n :: BOOK ::" +
				"\n Title: " + getTitle() +
				"\n Editorial: " + getEditorial() +
				"\n Edition Date: " + getEdititionDate() +
				"\n Authors: ";
		for (int i = 0; i < getAuthors().length; i++) {
			detailBook += "\t" + getAuthors()[i] + " ";
		}
		return  detailBook;
	}


	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}


	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if (dateF.getTime() > dateI.getTime()) {
			setTimeRead((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeRead(0);
		}
	}


	public static ArrayList<Book> makeBookList() {
		ArrayList<Book> books = new ArrayList<>();
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] = "author "+i;
		}

		ArrayList<Page> pages = new ArrayList<>();
		int pagina = 0;
		for (int i = 0; i < 3; i++) {
			pagina = i+1;
			pages.add(new Book.Page(pagina, "Este es el contenido de la página " + pagina));
		}

		for (int i = 1; i <= 5; i++) {
			books.add(new Book("Book " + i, new Date(), "editorial " + i, authors, pages));
		}

		return books;
	}

	/**
	 * Permite ver las páginas del libro y su contenido.
	 * */
	public void view() {
		this.setRead(true);
		Date dateI = this.startToSee(new Date());

		int i = 0;
		do {
			System.out.println("..........");
			System.out.println("Página " + getPages().get(i).getPageNumber());
			System.out.println(getPages().get(i).getContent());
			System.out.println("..........");

			if (i != 0) {
				System.out.println("1. Regresar página");
			}
			System.out.println("2. Siguiente página");
			System.out.println("0. Cerrar libro\n");

			int response = AmazonUtil.validateUserResponseMenu(0, 2);

			if (response == 2) {
				i++;
			}else if (response == 1 && i>0) {
				i--;
			}else if (response == 0) {
				break;
			}

		} while (i < getPages().size());

		this.stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Leíste: " + this);
		System.out.println("Por: " + this.getTimeRead() + " milisegundos");

	}

	public static class Page {
		private int id;
		private int pageNumber;
		private String content;

		public Page(int pageNumber, String content) {
			this.pageNumber = pageNumber;
			this.content = content;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getPageNumber() {
			return pageNumber;
		}

		public void setPageNumber(int pageNumber) {
			this.pageNumber = pageNumber;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

}
