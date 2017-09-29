package ar.com.almunto.callcenter.entity;

import ar.com.almundo.callcenter.CallDispatcher;

public class Director extends AbstractEmpleado {
	public Director(CallDispatcher dispatcher, String nombre){
		super(dispatcher, nombre);
		this.tipoEmpleado = TipoEmpleado.DIRECTOR;
	}

	@Override
	void addEmpleadoDisponible(CallDispatcher dispatcher) {
		dispatcher.addEmpleadoDisponible(new Director(dispatcher, nombre));
	}

}
