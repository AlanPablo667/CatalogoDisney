package com.example.disneyDatos;

import java.util.List;
import com.example.disneyDomain.*;
import com.example.disneyExepciones.*;

public interface IAccesoDatos {
	boolean existe(String nombreSerie) throws AccesoDatosEx;

	List<pelicula> listar(String nombreSerie) throws LecturaDatosEx;

	void escribir(pelicula pelicula, String nombreSerie, boolean anexar) throws EscrituraDatosEx;

	String buscar(String nombreSerie, String buscar) throws LecturaDatosEx;

	void crear(String nombreSerie) throws AccesoDatosEx;

	void borrar(String nombreSerie) throws AccesoDatosEx;
}
