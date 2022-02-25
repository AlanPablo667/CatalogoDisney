package com.example.disneyDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;

import com.example.disneyDomain.pelicula;
import com.example.disneyExepciones.AccesoDatosEx;
import com.example.disneyExepciones.EscrituraDatosEx;
import com.example.disneyExepciones.LecturaDatosEx;

public class AccesoDatosImpl implements IAccesoDatos {

	@Override
	public boolean existe(String nombreSerie)  {
		File archivo = new File(nombreSerie);
		return archivo.exists();

	}

	@Override
	public List<pelicula> listar(String nombreSerie) throws LecturaDatosEx {
		File archivo = new File(nombreSerie);
		List<pelicula> peliculas = new ArrayList<>();
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String linea = null;
			linea = entrada.readLine();
			while (linea != null) {
				var pelicula = new pelicula(linea);
				peliculas.add(pelicula);
				linea = entrada.readLine();
			}
			entrada.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			throw new LecturaDatosEx("Exepcion al listar pelicula:" + ex.getMessage());

		} catch (IOException ex) {
			ex.printStackTrace();
			throw new LecturaDatosEx("exepcion al listar pelicula:" + ex.getMessage());
		}
		return peliculas;
	}

	@Override
	public void escribir(pelicula pelicula, String nombreSerie, boolean anexar) throws EscrituraDatosEx {
		var archivo = new File(nombreSerie);
		try {
			var salida = new PrintWriter(new FileWriter(archivo, anexar));
			salida.println(pelicula.toString());
			salida.close();
			System.out.println("se escribio informacion al archivo" + pelicula);
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new EscrituraDatosEx("exepcion al listar pelicula:" + ex.getMessage());

		}
	}

	@Override
	public String buscar(String nombreSerie, String buscar) throws LecturaDatosEx {
		var archivo = new File(nombreSerie);
		String resultado = null;
		try {
			var entrada = new BufferedReader(new FileReader(archivo));
			String linea = null;
			linea = entrada.readLine();
			int indice = 1;
			while (linea != null) {
				if (buscar != null && buscar.equalsIgnoreCase(linea)) {
					resultado = "pelicula" + linea + "encontrada en el indice" + indice;
					break;
				}
				linea = entrada.readLine();
				indice++;
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			throw new LecturaDatosEx("exepcion al buscar peliculas:" + ex.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new LecturaDatosEx("exepcion al buscar peliculas:" + ex.getMessage());

		}
		return resultado;
	}

	@Override
	public void crear(String nombreSerie) throws AccesoDatosEx {
		var archivo = new File(nombreSerie);
		try {
			var salida = new PrintWriter(new FileWriter(archivo));
			salida.close();
			System.out.println("se ah creado el archivo");
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new AccesoDatosEx("exepcion al crear archivo:" + ex.getMessage());

		}
	}

	@Override
	public void borrar(String nombreSerie)  {
var archivo= new File (nombreSerie);
if(archivo.exists())
archivo.delete();
System.out.println("se ah borrado el archivo");
	}

}
