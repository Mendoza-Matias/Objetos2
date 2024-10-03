## Algoritmo de Ordenamiento Burbuja

  Este proyecto implementa el algoritmo de ordenamiento burbuja en Java. A continuación se detalla el funcionamiento del método y su lógica.


## Explicación del Algoritmo

Estado Inicial:

Se inicia con el arreglo numeros = {10, 9, 8, 7, 6, 5}.

## Iteraciones:

El bucle externo (for) itera n-1 veces, donde n es la longitud del arreglo (6 en este caso).
En cada iteración, el índice i varía de 0 a 4, permitiendo que los elementos más grandes "burbujeen" a su posición correcta.
Comparaciones y Cambios:

En cada iteración, se compara cada par de elementos adyacentes. Si están en el orden incorrecto, se intercambian.
Por ejemplo, en la primera iteración, se comparan y se intercambian los elementos hasta que el mayor queda al final del arreglo.
Estado Final:

Después de las iteraciones, el arreglo se ordena como {5, 6, 7, 8, 9, 10}.