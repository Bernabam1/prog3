package practico4.grafos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, LinkedList<Arco<T>>> vertices;

	public GrafoDirigido() {
		this.vertices = new HashMap<>();
	}

	public LinkedList<Arco<T>> getListaAdyacentes(int vertice) {
		return vertices.get(vertice);
	}

	@Override
	public void agregarVertice(int verticeId) {
		if (!vertices.containsKey(verticeId))
			this.vertices.put(verticeId, new LinkedList<>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		if (vertices.containsKey(verticeId)) // contieneVertice me pide castear
			vertices.remove(verticeId);
		// Eliminar el vértice de los conjuntos de adyacentes de los demás vértices
		for (LinkedList<Arco<T>> arrArcos : vertices.values()) {
			for (Arco<T> arco : arrArcos) {
				borrarArco(arco.getVerticeOrigen(), verticeId);
			}
		}
	}

	@Override
	public void agregarArco(int verticeOrigen, int verticeDestino, T etiqueta) {
		if (vertices.containsKey(verticeOrigen) && vertices.containsKey(verticeDestino)) {
			Arco<T> aux = new Arco<>(verticeOrigen, verticeDestino, etiqueta);
			if (!vertices.get(verticeOrigen).contains(aux)) {
				vertices.get(verticeOrigen).add(aux);
			}
		}
	}

	@Override
	public void borrarArco(int verticeOrigen, int verticeDestino) {
		Arco<T> aux = new Arco<>(verticeOrigen, verticeDestino, null);
		List<Arco<T>> arcos = this.vertices.get(verticeOrigen);
		if (arcos.contains(aux)) {
			arcos.remove(aux);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeOrigen, int verticeDestino) {
		LinkedList<Arco<T>> adyacentes = vertices.get(verticeOrigen);
		for (Arco<T> arco : adyacentes) {
			return arco.getVerticeDestino() == verticeDestino;
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeOrigen, int verticeDestino) {
		if (!existeArco(verticeOrigen, verticeDestino))
			return null;
		LinkedList<Arco<T>> adyacentes = getListaAdyacentes(verticeOrigen);
		for (Arco<T> arco : adyacentes) {
			if (arco.getVerticeDestino() == verticeDestino)
				return new Arco<T>(verticeOrigen, verticeDestino, arco.getEtiqueta());
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
		for (LinkedList<Arco<T>> arcos : vertices.values()) {
			cant += arcos.size();
		}
		return cant;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return this.vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		if (!vertices.containsKey(verticeId)) {
			return null; // Vértice no está en el grafo
		}
		LinkedList<Integer> adyacentes = new LinkedList<>();
		for (Arco<T> arco : vertices.get(verticeId)) {
			adyacentes.add(arco.getVerticeDestino());
		}
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		LinkedList<Arco<T>> listaArcos = new LinkedList<>();
		for (LinkedList<Arco<T>> listaAdyacencia : vertices.values()) {
			listaArcos.addAll(listaAdyacencia);
		}
		return listaArcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}