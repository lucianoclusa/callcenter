package ar.com.almundo.callcenter.entity;

import ar.com.almunto.callcenter.entity.LLamada;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LLamadaTest extends TestCase {
	public static Test suite(){
		return new TestSuite( LLamadaTest.class );
	}
	public void testLlamada(){
		LLamada llamada	= new LLamada("llamada test");
		assertTrue(llamada.getDuracion()>=LLamada.MIN_DURACION);
		assertTrue(llamada.getDuracion()<=LLamada.MAX_DURACION);
	}
}
