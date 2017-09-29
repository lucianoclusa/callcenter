package ar.com.almundo.callcenter;

import ar.com.almundo.callcenter.CallDispatcher;
import ar.com.almunto.callcenter.entity.Director;
import ar.com.almunto.callcenter.entity.LLamada;
import ar.com.almunto.callcenter.entity.Operador;
import ar.com.almunto.callcenter.entity.Supervisor;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CallDispatcherTest extends TestCase {
	final int TIEMPO_MAX_LLAMADA_MILISEC = 10000;
   /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( CallDispatcherTest.class );
    }
    
    //Este test dura 15s
    public void testTresLLamadas(){
    	try {
	    	CallDispatcher dispatcher = new CallDispatcher();
	    	dispatcher.start();
			dispatcher.addEmpleadoDisponible(new Operador(dispatcher, "Operador 1"));
			LLamada llamada1 = new LLamada(" 1 ");
			llamada1.setDuracion(5);
			LLamada llamada2 = new LLamada(" 2 ");
			llamada2.setDuracion(5);
			LLamada llamada3 = new LLamada(" 3 ");
			llamada3.setDuracion(5);
	    	dispatcher.dispatchCall(llamada1);
			dispatcher.dispatchCall(llamada2);
			dispatcher.dispatchCall(llamada3);

			//Las llamadas de este test duran 5s y como hay 1 solo operador, las llamadas tienen que ser atendidasen 15s.
			Thread.sleep(15000);
			
			//Al finalizar este tiempo, las llamdas deberian haber sido atendidas
			assertTrue(dispatcher.getLLamadas().isEmpty());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			fail();
		}
    	
    }
    //Este test dura 33s
    public void testDiezLLamadas(){
    	try {
	    	CallDispatcher dispatcher = new CallDispatcher();
	    	dispatcher.start();
			dispatcher.addEmpleadoDisponible(new Director(dispatcher, "Director 1"));
			dispatcher.addEmpleadoDisponible(new Supervisor(dispatcher, "Supervisor 1"));
			dispatcher.addEmpleadoDisponible(new Operador(dispatcher, "Operador 1"));
			
	    	dispatcher.dispatchCall(new LLamada(" 1 "));
			dispatcher.dispatchCall(new LLamada(" 2 "));
			dispatcher.dispatchCall(new LLamada(" 3 "));
			dispatcher.dispatchCall(new LLamada(" 4 "));
			dispatcher.dispatchCall(new LLamada(" 5 "));
			dispatcher.dispatchCall(new LLamada(" 6 "));
			dispatcher.dispatchCall(new LLamada(" 7 "));
			dispatcher.dispatchCall(new LLamada(" 8 "));
			dispatcher.dispatchCall(new LLamada(" 9 "));
			dispatcher.dispatchCall(new LLamada(" 10 "));

			//Espero el tiempo maximo para que todas las llamadas hayan sido atendidas:
			//((cant llamadas * tiempo de duracion max de llamada) / cant empleados)
			Thread.sleep((TIEMPO_MAX_LLAMADA_MILISEC * 10)/3);
			
			//Al finalizar este tiempo, las llamdas deberian haber sido atendidas
			assertTrue(dispatcher.getLLamadas().isEmpty());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			fail();
		}
    	
    }
    //Este test dura 20s
   public void testIncomingCalls(){
    	try {
	    	CallDispatcher dispatcher = new CallDispatcher();
	    	dispatcher.start();
	    	dispatcher.dispatchCall(new LLamada(" 1 "));
			dispatcher.dispatchCall(new LLamada(" 2 "));
			dispatcher.dispatchCall(new LLamada(" 3 "));
			dispatcher.dispatchCall(new LLamada(" 4 "));
			dispatcher.dispatchCall(new LLamada(" 5 "));
			dispatcher.addEmpleadoDisponible(new Operador(dispatcher, "Operador 1"));
			dispatcher.addEmpleadoDisponible(new Operador(dispatcher, "Operador 2"));
			dispatcher.addEmpleadoDisponible(new Operador(dispatcher, "Operador 3"));
			dispatcher.addEmpleadoDisponible(new Supervisor(dispatcher, "Supervisor 1"));
			dispatcher.addEmpleadoDisponible(new Operador(dispatcher, "Operador 4"));
			dispatcher.dispatchCall(new LLamada(" 6 "));
			dispatcher.addEmpleadoDisponible(new Director(dispatcher, "Director 1"));
			dispatcher.dispatchCall(new LLamada(" 7 "));
			dispatcher.dispatchCall(new LLamada(" 8 "));
			dispatcher.addEmpleadoDisponible(new Supervisor(dispatcher, "Supervisor 2"));
			dispatcher.dispatchCall(new LLamada(" 9 "));
			dispatcher.dispatchCall(new LLamada(" 10 "));
			dispatcher.dispatchCall(new LLamada(" 11 "));
			dispatcher.dispatchCall(new LLamada(" 12 "));
			dispatcher.addEmpleadoDisponible(new Director(dispatcher, "Director 2"));
			dispatcher.dispatchCall(new LLamada(" 13 "));
			dispatcher.dispatchCall(new LLamada(" 14 "));
			dispatcher.dispatchCall(new LLamada(" 15 "));
			dispatcher.dispatchCall(new LLamada(" 16 "));

			//Espero el tiempo maximo para que todas las llamadas hayan sido atendidas:
			//((cant llamadas * tiempo de duracion max de llamada) / cant empleados)
			Thread.sleep((TIEMPO_MAX_LLAMADA_MILISEC * 16)/8);
			
			//Al finalizar este tiempo, las llamdas deberian haber sido atendidas
			assertTrue(dispatcher.getLLamadas().isEmpty());

		} catch (InterruptedException e) {
			e.printStackTrace();
			fail();
		}
    	
    }
}
