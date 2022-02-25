package com.example.disneyServicio;

import com.example.disneyDatos.AccesoDatosImpl;
import com.example.disneyDatos.IAccesoDatos;
import com.example.disneyDomain.pelicula;
import com.example.disneyExepciones.AccesoDatosEx;
import com.example.disneyExepciones.LecturaDatosEx;

public class catalogoDisneyImpl implements ICatalogoDisney {
	private final IAccesoDatos datos;

	public catalogoDisneyImpl() {
		this.datos = new AccesoDatosImpl();

	}

	@Override
	public void agregarPeliculas(String nombreSerie) {
		pelicula pelicula = new pelicula(nombreSerie);
		boolean anexar = false;
		try {
			anexar = datos.existe(NOMBRE_RECURSO);
			datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
		} catch (AccesoDatosEx ex) {
			System.out.println("Error de acceso a datos");
			ex.printStackTrace(System.out);
		}

	}

	@Override
	public void listarPeliculas() {
		try {
			var peliculas = this.datos.listar(NOMBRE_RECURSO);
			for (var pelicula : peliculas) {
				System.out.println("pelicula = " + pelicula);

			}
		} catch (LecturaDatosEx ex) {
			System.out.println("Error de acceso datos");
			ex.printStackTrace(System.out);
		}
	}

	@Override
	public void buscarPeliculas(String buscar) {
		String resultado = null;
		try {
			resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
		} catch (LecturaDatosEx ex) {
			System.out.println("Error de acceso datos");
			ex.printStackTrace(System.out);
		}
		System.out.println("resultado=" + resultado);
	}

	@Override
	public void iniciarCatalogoPeliculas() {
		try {
			if (this.datos.existe(NOMBRE_RECURSO)) {
				datos.borrar(NOMBRE_RECURSO);
				datos.crear(NOMBRE_RECURSO);
			} else {
				datos.crear(NOMBRE_RECURSO);
			}
		} catch (AccesoDatosEx ex) {
			System.out.println("Error al iniciar catalogo de disney");
			ex.printStackTrace(System.out);

		}

	}
}