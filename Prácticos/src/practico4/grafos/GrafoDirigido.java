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
		this.vertices.putIfAbsent(verticeId, new ArrayList<>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		this.vertices.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		List<Arco<T>> arcos = vertices.getOrDefault(verticeId1, new ArrayList<>());
		Arco<T> aux = new Arco<>(verticeId1, verticeId2, etiqueta);
		this.agregarVertice(verticeId2);

		if (!arcos.contains(aux)) {
			arcos.add(aux);
			vertices.put(verticeId1, arcos);
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
		return (this.vertices.keySet().contains(verticeId)) ? true : false;
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
		return this.vertices.keySet().size();
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

	asdfhasdfjhdsfh
}