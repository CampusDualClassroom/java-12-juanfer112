# Ejercicio 12 - Clases y Objetos - Car
## Descripción del ejercicio
Se implementará el contenido de una clase básica, con sus atributos y métodos, para luego ser instanciada desde otra clase.

### Objetivos
* Dadas las clases ``Exercise12`` y ``Car`` proporcionadas, desarrollar el contenido de la clase ``Car`` para que posteriormente pueda 
  ser instanciada en el método ``main()`` de ``Exercise12`` y se puedan realizar correctamente los ejercicios propuestos a continuación.

### Clases y métodos a implementar
* La clase ``Car`` proporcionada está vacía. Será necesario copiar todo lo que se muestra en las diapositivas del temario de POO dentro 
  de esta clase: sus atributos y métodos. 


* IMPORTANTE: en las diapositivas, el atributo ``steeringWheelAngle`` debe cambiar de nombre en este ejercicio a ``wheelsAngle``. 
  También, el método de las diapositivas ``turnSteeringWheel()`` debe cambiar de nombre a ``turnAngleOfWheels()``. Otros cambios podrían 
  ser necesarios, como por ejemplo añadir ciertas comprobaciones de datos, o algún cambio más: aplicarlos para lograr que los test se 
  ejecutan correctamente (sin modificar los test).



* Dentro del ``main()`` será necesario instanciar objetos de tipo ``Car`` y realizar ejercicios de las siguientes funcionalidades: 
  * Un método booleano que verifique si el valor del tacómetro es cero
  * Encender el coche comprobando el valor correcto del tacómetro (investigar cuál es el valor correcto)
  * Encender el coche cuando ya está encendido (comprobar que no se puede encender si ya está encendido)
  * Apagar el coche comprobando que el valor del tacómetro es correcto
  * Apagar el coche mientras todavía está en movimiento (y comprobar que no se puede)
  * Acelerar el coche
  * Acelerar hasta intentar superar la velocidad máxima (y comprobar que no se puede)
  * Frenar la velocidad
  * Frenar hasta un valor negativo (y comprobar que no se puede)
  * Girar el volante 20 grados
  * Girar el volante más de 45 grados ó -45 grados (y comprobar que no se puede)
  * Detener el coche y poner marcha atrás
  * Poner marcha atrás mientras el coche está en movimiento marcha adelante (y comprobar que no se puede)


### Requisitos
* No se pueden modificar en absoluto las clases de test.

### Test

```
mvn test
```
