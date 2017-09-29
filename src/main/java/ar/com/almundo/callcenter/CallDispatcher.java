package ar.com.almundo.callcenter;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import ar.com.almunto.callcenter.entity.AbstractEmpleado;
import ar.com.almunto.callcenter.entity.LLamada;

public class CallDispatcher extends Thread{

	BlockingQueue<AbstractEmpleado> empleadosDisponibles;
	BlockingQueue<LLamada> llamadas; 

	public CallDispatcher(){
		empleadosDisponibles = new PriorityBlockingQueue<AbstractEmpleado>();
		llamadas = new LinkedBlockingQueue<LLamada>();
	}

	public void dispatchCall(LLamada llamada) throws InterruptedException{
		System.out.println("Entrando llamada " + llamada.getDescripcion());
		this.llamadas.put(llamada);
	}

	public void run() {
		LLamada llamada;
		AbstractEmpleado empleado;
		try {
			while(true){
				llamada = llamadas.take();
				System.out.println("Esperando a tomar la llamada " + llamada.getDescripcion());
				empleado = empleadosDisponibles.take();
				System.out.println("Empleado " + empleado.getNombre() + " va a tomar la llamda " + llamada.getDescripcion());
				empleado.atenderLlamada(llamada);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addEmpleadoDisponible(AbstractEmpleado empleado){
		this.empleadosDisponibles.add(empleado);
	}
	
	public Queue<LLamada> getLLamadas(){
		return llamadas;
	}
	
	public Queue<AbstractEmpleado> getEmpleadosDisponibles(){
		return empleadosDisponibles;
	}
}
