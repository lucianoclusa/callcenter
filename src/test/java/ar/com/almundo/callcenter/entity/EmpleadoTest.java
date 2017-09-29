package ar.com.almundo.callcenter.entity;

import ar.com.almundo.callcenter.CallDispatcher;
import ar.com.almundo.callcenter.CallDispatcherTest;
import ar.com.almunto.callcenter.entity.LLamada;
import ar.com.almunto.callcenter.entity.Operador;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class EmpleadoTest extends TestCase {
	public static Test suite(){
		return new TestSuite( CallDispatcherTest.class );
	}

	public void empleadoTest(){
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
