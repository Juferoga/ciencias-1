public class ArbolBinario<E> {

  NodoArbol<E> raiz;

  public ArbolBinario() {
      raiz = null;
  }

  /*
  public void agregarNodo(E dato) {
      if (raiz == null) {
          raiz = new NodoArbol<E>(dato);
      } else {
          raiz.agregarNodo(dato);
      }
  }*/
  public void agregarNodo(E dato) {
      if (raiz == null) {
        raiz = new NodoArbol<E>(dato, 0, null);
        raiz.esHijo = 0;
      } else {
        raiz.agregarNodo(dato, 1, raiz);
      }
  }
  /*
  //Equilibrar nodo
  public void equilibrar(NodoArbol<E> rev) {

      NodoArbol<E> P = null, Q = null;
      while (rev.getFe() <= 1 && rev.getFe() >= -1) {
          rev = rev.getPadre();
      }
      P = rev;
      Q = P.getHijoAlto();
      if (P.getFe() > 0 && Q.getFe() > 0) {
          //rotacion a la derecha
          rotacionDerecha();

      }
      if (P.getFe() < 0 && Q.getFe() < 0) {
          //rotacion a la izquierda
          rotacionIzquierda();

      }
      if (P.getFe() > 0 && Q.getFe() < 0) {
          //rotacion de q a la izquierda 
          //rotacion de p a la derecha
          doblerotacionDerecha();

      }
      if (P.getFe() < 0 && Q.getFe() > 0) {
          //rotacion de q a la derecha 
          //rotacion de p a la izquierda
          doblerotacionIzquierda();
      }

      System.out.println("P:" + P.getNumero());
      System.out.println("Q:" + Q.getNumero());
      System.out.println("FE P:" + P.getFe());
      System.out.println("FE Q:" + Q.getFe());
  }

  public void rotacionDerecha() {
      AVLNode k1 = k2.izquierdo;
      k2.izquierdo = k1.derecho;
      k1.derecho = k2;
      k2.height = max( height(k2.izquierdo), height(k2.derecho)) + 1;
      k1.height = max( height( k1.izquierdo ), k2.height ) + 1;
      return k1;
  }
  
  public void rotacionIzquierda() {
      AVLNode k2 = k1.derecho;
      k1.derecho = k2.izquierdo;
      k2.izquierdo = k1;
      k1.height = max( height(k1.izquierdo), height(k1.derecho) ) + 1;
      k2.height = max( height( k2.derecho ), k1.height ) + 1;
      return k2;
  }
  
  public void doblerotacionDerecha() {
      k3.izquierdo = rotateWithRightChild( k3.izquierdo );
      return rotateWithLeftChild( k3 );
  }
  
  public void doblerotacionIzquierda() {
      k3.izquierdo = rotateWithRightChild( k3.izquierdo );
      return rotateWithLeftChild( k3 );
  }
  */
  public void recorrerIRD() {
    System.out.println("Recorrido Izquierda Raiz Derecha (INFIJA):");
    raiz.recorrerIRD();
    System.out.println("\n--------------");
  }

  public void recorrerIDR(){
    System.out.println("Recorrido Izquierda Derecha Raiz (POSFIJA)");
    raiz.recorrerIDR();
    System.out.println("\n--------------");
  }

  public void recorrerDRI() {
    System.out.println("Recorrido Derecha Raiz Izquierda (INFIJA INVERSA)");
    raiz.recorrerDRI();
    System.out.println("\n--------------");
  }

  public void recorrerRID() {
    System.out.println("Recorrido Raiz Izquierda Derecha");
    raiz.recorrerRID();
    System.out.println("\n--------------");
  }

  public void recorrerRDI() {
    System.out.println("Recorrido Raiz Derecha Izquierda");
    raiz.recorrerRDI();
    System.out.println("\n--------------");
  }

  public void recorrerDIR(){
    System.out.println("Recorrido Derecha Izquierda Raiz");
    raiz.recorrerDIR();
    System.out.println("\n--------------");
  }

  public int cantidadNodos() {
    return 1 + raiz.cantidadHijos();
  }

  public int altura(){
    return raiz.altura();
  }

  public void recorrido() {
    raiz.recorrer();
  }
}