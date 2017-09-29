package ar.com.almunto.callcenter.entity;

import java.util.Random;

public class LLamada {
	public static final int MIN_DURACION = 5;
	public static final int MAX_DURACION = 10;
	private int duracion;
	private String descripcion;

	public LLamada(String descripcion){
		duracion = new Random().nextInt(MAX_DURACION - MIN_DURACION + 1) + MIN_DURACION;
		this.descripcion = descripcion;
	}
	
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
