package practico3.arboles;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private TreeNode root;

	public Tree() {
		this.root = null;
	}

	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root, value);
	}

	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) {
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(), value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) {
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(), value);
			}
		}
	}

	public Integer getRoot() {
		if (this.root != null) {
			return this.root.getValue();
		} else {
			return null;
		}
	}

	public boolean hasElem(Integer value) {
		return hasElem(root, value);
	}

	private boolean hasElem(TreeNode node, Integer value) {
		if (node == null) {
			return false;
		}

		if (node.getValue().equals(value)) {
			return true;
		}

		// Recorrer hacia la izquierda si el valor es menor que el valor del nodo actual
		if (value < node.getValue()) {
			return hasElem(node.getLeft(), value);
		}
		// Recorrer hacia la derecha si el valor es mayor que el valor del nodo actual
		else {
			return hasElem(node.getRight(), value);
		}
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public void insert(Integer value) {
		add(root, value);
	}

	public List<Integer> getLongestBranch() {
		return getLongestBranch(root);
	}

	private List<Integer> getLongestBranch(TreeNode actual) {
		// Si la rama es null devuelvo lista vacía
		if (actual == null) {
			ArrayList<Integer> aux = new ArrayList<>();
			return aux;
		}

		// Llamadas recursivas en izquierda y derecha
		ArrayList<Integer> right = (ArrayList<Integer>) getLongestBranch(actual.getRight());
		ArrayList<Integer> left = (ArrayList<Integer>) getLongestBranch(actual.getLeft());

		// Comparo el size de los ArrayList
		// inserto el nodo de acuerdo al tamañao
		if (right.size() < left.size()) {
			left.add(actual.getValue());
		} else {
			right.add(actual.getValue());
		}

		// Retorno el mas largo
		if (right.size() > left.size()) {
			return right;
		} else {
			return left;
		}
	}

	public List<Integer> getFrontera() {
		List<Integer> resultado = new ArrayList<>();
		getFrontera(resultado, root);
		return resultado;
	}

	private void getFrontera(List<Integer> resultado, TreeNode actual) {
		if (actual != null) {
			if (actual.esHoja())
				resultado.add(actual.getValue());
			else {
				getFrontera(resultado, actual.getLeft());
				getFrontera(resultado, actual.getRight());
			}
		}
	}

	public Integer getMaxElement() {
		return getMaxElement(root);
	}

	private Integer getMaxElement(TreeNode actual) {
		if (actual == null)
			return null;
		if (actual.getRight() != null)
			return getMaxElement(actual.getRight());
		else {
			return actual.getValue();
		}
	}

	public List<Integer> getElementAtLevel(int lvl) {
		List<Integer> resultado = new ArrayList<>();
		getElementAtLevel(lvl, root, resultado, 0);
		return resultado;
	}

	private void getElementAtLevel(int lvl, TreeNode actual, List<Integer> resultado, int contador) {
		if (actual != null) {
			if (contador == lvl) {
				resultado.add(actual.getValue());
			} else {
				getElementAtLevel(lvl, actual.getLeft(), resultado, contador + 1);
				getElementAtLevel(lvl, actual.getRight(), resultado, contador + 1);
			}
		}
	}

	public boolean delete(Integer value) {
		return delete(value, root);
	}

	private boolean delete(Integer value, TreeNode actual) {
		if (actual == null)
			return false;
		
		if(actual.esHoja()) {
			actual = null;
			return true;
		}
		// Si el valor a eliminar es menor que el valor del nodo actual, recorro a la
		// izquierda
		if (actual.getValue() > value) {
			delete(value, actual.getLeft());
		}
		// Si el valor a eliminar es mayor que el valor del nodo actual, recorro a la
		// derecha
		else if (actual.getValue() < value)
			delete(value, actual.getRight());
		else {
			// Si el nodo tiene un solo hijo a la derecha
			if(actual.getRight() != null && actual.getLeft() == null) {
				
			}
			// Si el nodo tiene un solo hijo a la izquierda
			else if(actual.getRight() == null && actual.getLeft() != null) {
				
			}
			// Si tiene dos hijos
			else {
				
			}

		}
	}
}
