package practico4.grafos;

import java.util.HashMap;
import java.util.Iterator;

public class DFS<T> {

	private Grafo<T> grafo;
	private static final int BLANCO = 0;
	private static final int AMARILLO = 1;
	private static final int NEGRO = 2;
	private HashMap<Integer, Integer> color;

	public DFS(Grafo<T> grafo) {
		this.grafo = grafo;
		this.color = new HashMap<>();
	}

	public void pintarDFS() {
		Iterator<Integer> adyacentesIterator = grafo.obtenerVertices();
		// Pongo todos los vertices en blanco
		while (adyacentesIterator.hasNext()) {
			color.put(adyacentesIterator.next(), BLANCO);
		}
		// Hay q reiniciar el iterador para recorrer de nuevo
		adyacentesIterator = grafo.obtenerVertices();

		// Llamado recursivo a hacer DFS en cada vertice de nuevo
		while (adyacentesIterator.hasNext()) {
			Integer vertice = adyacentesIterator.next();
			if (color.get(vertice) == BLANCO) { // Retorna el valor asociado a la key
				visitar(vertice, color);
			}
		}
	}

	private void visitar(Integer vertice, HashMap<Integer, Integer> color) {
		color.put(vertice, AMARILLO); // Pinto de amarillo el vertice en el q inicio
		// Cuando entre al if un vertice de color blanco, se va a pintar de amarillo
		
		Iterator<Integer> adyacentesIterator = grafo.obtenerAdyacentes(vertice);
		while (adyacentesIterator.hasNext()) {
			Integer adyacente = adyacentesIterator.next();
			if (color.get(adyacente) == BLANCO) { // Retorna el valor asociado a la key
				visitar(adyacente, color); // Llamada recursiva a visitar el adyacente
			}
		}
		// Si se ejecutó el while completo quiere decir q todos los adyacentes fueron procesados
		color.put(vertice, NEGRO);
	}
}
