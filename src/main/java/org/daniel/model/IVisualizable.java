package org.daniel.model;

import java.util.Date;

/**
 * <h2>IVisualizable</h2>
 * <p>
 * IVisualizable es una interface que contiene el método {@code startToSee()} que
 * obliga a las clases que la implementen a definir un método con el mismo nombre y parámetros.
 * @author dacif
 * @version 1.0
 * @since 2023
 * */
public interface IVisualizable {
	/**
	 * Este método captura el tiempo exacto de inicio de visualización.
	 * @param dateI Es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @return Devuelve la fecha y hora capturada.
	 * */
	Date startToSee(Date dateI);

	/**
	 * Este método captura el tiempo exacto de inicio y final de visualización.
	 * @param dateI Es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @param dateF Es un objeto {@code Date} con el tiempo de finalización exacto.
	 * */
	void stopToSee(Date dateI, Date dateF);

}
