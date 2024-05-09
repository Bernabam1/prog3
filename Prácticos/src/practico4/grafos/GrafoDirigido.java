package practico4.grafos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, ArrayList<Arco<T>>> vertices;

	public GrafoDirigido() {
		this.vertices = new HashMap<>();
	}

	public ArrayList<Arco<T>> getListaAdyacentes(int vertice) {
		return vertices.get(vertice);
	}

	@Override
	public void agregarVertice(int verticeId) {
		if (!vertices.containsKey(verticeId))
			this.vertices.put(verticeId, new ArrayList<>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		if (vertices.containsKey(verticeId)) // contieneVertice me pide castear
			vertices.remove(verticeId);

		for (ArrayList<Arco<T>> arrArcos : vertices.values()) {
			for (Arco<T> arco : arrArcos) {
				borrarArco(arco.getVerticeOrigen(), verticeId);
			}
		}

		/*
		 * for (Map.Entry<Integer, ArrayList<Arco<T>>> entry : vertices.entrySet()) {
		 * for (Arco<T> arco : entry.getValue()) { borrarArco(arco.getVerticeOrigen(),
		 * verticeId); } }
		 */
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
		ArrayList<Arco<T>> adyacentes = vertices.get(verticeOrigen);
		for (Arco<T> arco : adyacentes) {
			return arco.getVerticeDestino() == verticeDestino;
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeOrigen, int verticeDestino) {
		if (!existeArco(verticeOrigen, verticeDestino))
			return null;
		ArrayList<Arco<T>> adyacentes = getListaAdyacentes(verticeOrigen);
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
		for (ArrayList<Arco<T>> arcos : vertices.values()) {
			cant += arcos.size();
		}

		/*
		 * for (Map.Entry<Integer, ArrayList<Arco<T>>> entry : vertices.entrySet()) {
		 * cant += entry.getValue().size(); }
		 */

		return cant;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return this.vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}