package ar.com.almunto.callcenter.entity;

import ar.com.almunto.callcenter.CallDispatcher;

public class Supervisor extends AbstractEmpleado {
	public Supervisor(CallDispatcher dispatcher, String nombre){
		super(dispatcher, nombre);
		super.tipoEmpleado = TipoEmpleado.SUPERVISOR;
	}

	@Override
	void addEmpleadoDisponible(CallDispatcher dispatcher) {
		dispatcher.addEmpleadoDisponible(new Supervisor(dispatcher, nombre));
	}

}
