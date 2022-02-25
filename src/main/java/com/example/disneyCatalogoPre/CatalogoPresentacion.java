package com.example.disneyCatalogoPre;

import java.util.Scanner;

import org.thymeleaf.spring5.naming.SpringContextVariableNames;

import com.example.disneyServicio.ICatalogoDisney;
import com.example.disneyServicio.catalogoDisneyImpl;

public class CatalogoPresentacion {
	public static void main(String[] args) {

		var opcion = -1;
		var Scanner = new Scanner(System.in);
		ICatalogoDisney catalogo = new catalogoDisneyImpl();
		while (opcion != 0) {
			System.out.println("Elige una opcion:\n" + "1. iniciar catalogo Disney :\n" + "2. Agregar pelicula: \n"
					+ "3. Listar peliculas: \n" + "4. Buscar Pelicula: \n" + "0. salir");
			opcion = Integer.parseInt(Scanner.nextLine());

			switch(opcion) {
			case 1:
				catalogo.iniciarCatalogoPeliculas();
				break;
			case 2:
				System.out.println("introduce el nombre de la pelicula");
				var nombre= Scanner.nextLine();
				catalogo.agregarPeliculas(null);
				break;
			case 3 :
				catalogo.listarPeliculas();
				break;
			case 4:
				System.out.println("Introduce una pelicula a buscar");
				var buscar =Scanner.nextLine();
				catalogo.buscarPeliculas(buscar);
			case 0:
				System.out.println("hasta pronto!");
				break;
				default:
					System.out.println(" Opcion no reconodica");
					break;
				
			}
			
		}
	}
}
