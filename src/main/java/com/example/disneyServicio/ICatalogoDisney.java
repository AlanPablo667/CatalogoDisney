package com.example.disneyServicio;

public interface ICatalogoDisney {
String NOMBRE_RECURSO= "peliculas.txt";

void agregarPeliculas(String nombreSerie);
	
void listarPeliculas();
	
void buscarPeliculas(String buscar);

void iniciarCatalogoPeliculas();
	
}
