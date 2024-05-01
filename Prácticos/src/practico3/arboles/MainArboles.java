package practico3.arboles;

public class MainArboles {

	public static void main(String[] args) {
		// Crear un árbol binario ordenado
		
	        Tree bt = new Tree();
	        bt.add(63);
	        bt.add(42);
	        bt.add(89);
	        bt.add(25);
	        bt.add(48);
	        bt.add(15);
	        bt.add(12);
	        bt.add(50);
	        bt.add(74);
	        bt.add(67);
	        
	        Tree bt2 = new Tree();
	        
	        System.out.println("Root = " + bt.getRoot());
	        System.out.println("Has Elem = " + bt.hasElem(96));
	        System.out.println("Is Empty = " + bt2.isEmpty());
	        System.out.println("Get Longest Branch = " + bt.getLongestBranch());
	        System.out.println("Frontera = " + bt.getFrontera());
	        System.out.println("Get Max Element = " + bt.getMaxElement());
	        System.out.println("Get Element at Level = " + bt.getElementAtLevel(1));
	        
	}
}
