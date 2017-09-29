package ar.com.almundo.callcenter.entity;

import ar.com.almundo.callcenter.CallDispatcher;
import ar.com.almunto.callcenter.entity.LLamada;
import ar.com.almunto.callcenter.entity.Operador;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class OperadorTest extends TestCase {
	public static Test suite(){
		return new TestSuite( OperadorTest.class );
	}

	public void testOperador(){
		LLamada llamada = new LLamada("llamada test");
		llamada.setDuracion(5);
		CallDispatcher dispatcher = new CallDispatcher();
		Operador operador = new Operador(dispatcher, "operador test");
		try {
			operador.atenderLlamada(llamada);
			Thread.sleep(6000);
			assertTrue(dispatcher.getEmpleadosDisponibles().size()==1);
		} catch (InterruptedException e) {
			e.printStackTrace();
			fail();
		}
		
	}
}
