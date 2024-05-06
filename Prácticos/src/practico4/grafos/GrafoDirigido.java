package practico4.grafos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, List<Arco<T>>> vertices;

	public GrafoDirigido() {
		this.vertices = new HashMap<>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		if (!vertices.containsKey(verticeId))
			this.vertices.put(verticeId, new ArrayList<>()); // Asigno espacio en memoria
	}

	@Override
	public void borrarVertice(int verticeId) {
		if (vertices.containsKey(verticeId))
			this.vertices.remove(verticeId);
		else
			System.out.println("No existe el vertice");
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (!vertices.containsKey(verticeId1)) {
			// Si no existe, inicializa una nueva lista para almacenar los arcos
			vertices.put(verticeId1, new ArrayList<>());
		}
		if (!vertices.containsKey(verticeId2)) {
			// Si no existe, agrega el vérticeId2 al grafo
			this.agregarVertice(verticeId2);
		}
		// Obtiene la lista de arcos asociada con verticeId1
		List<Arco<T>> arcosDeId1 = vertices.get(verticeId1);
		// Crea el nuevo arco
		Arco<T> aux = new Arco<>(verticeId1, verticeId2, etiqueta);
		// Verifica si el arco ya existe en la lista de arcos asociada a verticeId1
		if (!arcosDeId1.contains(aux)) {
			// Si no existe, agrega el arco a la lista de arcos asociada a verticeId1
			arcosDeId1.add(aux);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Arco<T> aux = new Arco<>(verticeId1, verticeId2, null);
		List<Arco<T>> arcos = this.vertices.get(verticeId1);
		if (arcos.contains(aux)) {
			arcos.remove(aux);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return (this.vertices.containsKey(verticeId));
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		Arco<T> aux = new Arco<>(verticeId1, verticeId2, null);
		List<Arco<T>> arcos = this.vertices.get(verticeId1);
		return (arcos.contains(aux));
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Arco<T> aux = new Arco<>(verticeId1, verticeId2, null);
		List<Arco<T>> arcos = this.vertices.get(verticeId1);
		for (Arco<T> arco : arcos) {
			if (arco.equals(aux)) {
				return arco;
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int cant = 0;
		Iterator<Integer> it = this.obtenerVertices();
		while (it.hasNext()) {
			cant += this.vertices.get(it.next()).size();
		}
		return cant;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return this.vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		List<Integer> adyacentes = new ArrayList<>();
		this.obtenerArcos(verticeId).forEachRemaining(arco -> {
			adyacentes.add(arco.getVerticeDestino());
		});
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		List<Arco<T>> arcos = new ArrayList<>();
		Iterator<Integer> it = this.obtenerVertices();
		while (it.hasNext()) {
			arcos.addAll(this.vertices.get(it.next()));
		}
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		List<Arco<T>> arcos = this.vertices.get(verticeId);
		return arcos != null ? arcos.iterator() : null;
	}

}