public class Main {

    public Main() {
      ArbolBinario<Integer> ab = new ArbolBinario<Integer>();

      //Agregar nodos
      System.out.println("\nAgregando nodos...");
      ab.agregarNodo(10);
      ab.agregarNodo(5);
      ab.agregarNodo(12);
      ab.agregarNodo(3);
      ab.agregarNodo(7);
      ab.agregarNodo(11);
      ab.agregarNodo(15);
        
      //ab.recorrerIRD();
      //ab.recorrerDRI();
      //ab.recorrerRID();
      //ab.recorrerRDI();
      
      System.out.println("\n[================ INFORMACIÓN DEL ARBOL ===================]\n");
      System.out.println("Altura: "+ab.altura());
      System.out.println("Cantidad de nodos: "+ab.cantidadNodos());
      System.out.println("\n[================ RECORRIDO Y PROFUNDIDAD ===================]\n");
      ab.recorrido();
      System.out.println("\n[================ RECORRIDOS ===================]\n");
      ab.recorrerDRI();
      ab.recorrerIRD();
      ab.recorrerIDR();
      ab.recorrerRDI();
      ab.recorrerRID();
      ab.recorrerDIR();
    
      //ab.recorrido();
    }    

    public static void main(String[] args) {
        new Main();
    }

}
