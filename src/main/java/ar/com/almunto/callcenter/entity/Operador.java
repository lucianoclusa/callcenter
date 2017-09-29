package ar.com.almunto.callcenter.entity;

import ar.com.almundo.callcenter.CallDispatcher;

public class Operador extends AbstractEmpleado {
	public Operador(CallDispatcher dispatcher, String nombre){
		super(dispatcher, nombre);
		super.tipoEmpleado = TipoEmpleado.OPERADOR;
	}

	@Override
	void addEmpleadoDisponible(CallDispatcher dispatcher) {
		dispatcher.addEmpleadoDisponible(new Operador(dispatcher, nombre));
	}

}
