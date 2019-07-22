# CallCenterBack
Ejercicio de Java con Maven - Spring - JUnit que simula la atención de llamadas para un CallCenter

Call center donde hay 3 tipos de empleados: operador, supervisor y director. El proceso de la atención de una llamada telefónica en primera instancia debe ser atendida por un operador, si no hay ninguno libre debe ser atendida por un supervisor, y de no haber tampoco supervisores libres debe ser atendida por un director.

# Descarga
> git clone https://github.com/cadolop/CallCenterBack.git

# Ejecución
> mvn spring-boot:run

# Consumo servicio

> post http://localhost:8080/dispatcher?size=10

Donde size es el numero de llamadas a entrar

# FAQS

1. Cómo asigna a los empleados disponibles?
R/ La clase Dispatcher mediante el método dispatchCall que permiete manejar las llamadas entrantes y buscar el Empleado disponible.

2. Como resuelve varias las llamadas al mismo tiempo?
R/ Mediante Asynchronous Methods de Spring, utilizando las propiedades setCorePoolSize y setQueueCapacity de ThreadPoolTaskExecutor, donde la cantidad de llamadas la da la capacidad maxima en cola y las llamadas a atender al tiempo es la cantidad de empleados configurados.

3. El tiempo de llamada como se determina?
R/ Tiempo aleatorio con Random entre 5 y 10 segundos.

4. Como esta configurado el test unitario?
R/ Se configura los MocksBean y MockMvc para consumir el servicio rest de la capa controller. Donde siempre atiendo 10 llamadas al tiempo.

5. Qué pasa con una llamada cuando no hay ningún empleado libre?
R/ La llamada pasa a la cola de espera del ThreadPoolTaskExecutor con la capacidad maxima configurada.

6. Qué pasa con una llamada cuando entran más de 10 llamadas concurrentes.
R/ La llamada pasa a la cola de espera del ThreadPoolTaskExecutor con la capacidad maxima configurada.

7. Qué tests unitarios tiene?
R/ dispatcherControllerTen que prueba el servicio rest de la capa controller. Donde siempre atiendo 10 llamadas al tiempo.
