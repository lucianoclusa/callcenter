<div class="WordSection1">

# Consigna

<span style="mso-spacerun:yes"> </span>Existe un <span class="SpellE">call</span> center donde hay 3 tipos de empleados: operador, supervisor y director. El proceso de la atención de una llamada telefónica en primera instancia debe ser atendida por un operador, si no hay ninguno libre debe ser atendida por un supervisor, y de no haber tampoco supervisores libres debe ser atendida por un director.

# Requerimientos

<span style="font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family:
Symbol"><span style="mso-list:Ignore">·<span style="font:7.0pt &quot;Times New Roman&quot;">        </span> </span></span>Diseñar el modelado de clases y diagramas UML necesarios para documentar y comunicar el diseño.

<span style="font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family:
Symbol"><span style="mso-list:Ignore">·<span style="font:7.0pt &quot;Times New Roman&quot;">        </span> </span></span>Debe existir una clase <span class="SpellE">Dispatcher</span> encargada de manejar las llamadas, y debe contener el método <span class="SpellE">dispatchCall</span> para que las asigne a los empleados disponibles.

<span style="font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family:
Symbol"><span style="mso-list:Ignore">·<span style="font:7.0pt &quot;Times New Roman&quot;">        </span> </span></span>La clase <span class="SpellE">Dispatcher</span> debe tener la capacidad de poder procesar 10 llamadas al mismo tiempo (de modo concurrente).

<span style="font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family:
Symbol"><span style="mso-list:Ignore">·<span style="font:7.0pt &quot;Times New Roman&quot;">        </span> </span></span>Cada llamada puede durar un tiempo aleatorio entre 5 y 10 segundos. Debe tener un test unitario donde lleguen 10 llamadas

# Extras/Plus

<span style="font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family:
Symbol"><span style="mso-list:Ignore">·<span style="font:7.0pt &quot;Times New Roman&quot;">        </span> </span></span>Dar alguna solución sobre qué pasa con una llamada cuando no hay ningún empleado libre.

<span style="font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family:
Symbol"><span style="mso-list:Ignore">·<span style="font:7.0pt &quot;Times New Roman&quot;">        </span> </span></span>Dar alguna solución sobre qué pasa con una llamada cuando entran más de 10 llamadas concurrentes.

<span style="font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family:
Symbol"><span style="mso-list:Ignore">·<span style="font:7.0pt &quot;Times New Roman&quot;">        </span> </span></span>Agregar los <span class="SpellE">tests</span> unitarios que se crean convenientes. Agregar documentación de código.

# Resolución


Se creó la clase <span class="SpellE">CallDispacher</span> que vendría a ser un <span class="SpellE">deamon</span> que recibe llamadas y se le asignan empleados, asincrónicamente va asignando los llamados en espera a los empleados disponibles quienes van a atender dichos llamados. Cuando un empleado termina de atender una llamada se vuelve a cargar ese tipo de empleado a la cola de <span class="SpellE">empleadosDisponibles</span>.

Para la cola de llamadas se utiliza <span class="SpellE"><span class="GramE">java.util</span>.concurrent.LinkedBlockingQueue.LinkedBlockingQueue</span> que es una implementación de <span class="SpellE">BlockingQueue</span> y se caracteriza por mantener el hilo a la espera cuando se quiere sacar un elemento de una cola vacía.

Para la cola de <span class="SpellE">empleadosDisponibles</span> utilicé java.util.concurrent.PriorityBlockingQueue.PriorityBlockingQueue que la única diferencia con la de llamadas es que está priorizada para que tome primero a los Operadores, luego a los Supervisores y por ultimo a los Directores.

Implementando estas colas, se solucionan los puntos Extras/Plus de la posibilidad de no tener empleado libre y la posibilidad de tener más de 10 llamadas concurrentes.



</div>
