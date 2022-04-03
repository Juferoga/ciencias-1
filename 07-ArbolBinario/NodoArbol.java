public class NodoArbol<E> {
  
  E numero;
  NodoArbol<E> ladoIzquierdo, ladoDerecho, padre;
  int esHijo;  //-1 Izquierdo, 0 Raiz, 1 Derecho
  int profundidad;

  public NodoArbol(E n, int profundidad, NodoArbol<E> padre) {
    this.numero = n;
    this.ladoIzquierdo = null;
    this.ladoDerecho = null;
    this.profundidad = profundidad;
    this.padre = padre;
    //System.out.println("Padre: "+this.padre);
    //System.out.println("Nodo: "+n);
  }

  public void agregarNodo(E dato, int profundidad, NodoArbol<E> padre) {
    if (((Comparable<E>) dato).compareTo(numero) > 0) {
        if (ladoDerecho == null) {
            //ladoDerecho = new NodoArbol<E>(dato);
            ladoDerecho = new NodoArbol<E>(dato, profundidad, padre);
            ladoDerecho.esHijo = 1;
        } else {
            //ladoDerecho.agregarNodo(dato);ç
            ladoDerecho.agregarNodo(dato, profundidad + 1, padre);
        }
    } else {
        if (ladoIzquierdo == null) {
            //ladoIzquierdo = new NodoArbol<E>(dato);
            ladoIzquierdo = new NodoArbol<E>(dato, profundidad, padre);
            ladoIzquierdo.esHijo = -1;
        } else {
            ladoIzquierdo.agregarNodo(dato, profundidad + 1, padre);
        }
    }
  }

  public void recorrerIRD() {
    try {
        ladoIzquierdo.recorrerIRD();
    } catch (Exception e) {
    }
    System.out.print(numero+"  ");
    try {
        ladoDerecho.recorrerIRD();
    } catch (Exception e) {
    }
  }

  public void recorrerIDR() {
    try {
        ladoIzquierdo.recorrerIDR();
    } catch (Exception e) {
    }
    try {
        ladoDerecho.recorrerIDR();
    } catch (Exception e) {
    }
    System.out.print(numero+"  ");
  }
  
  public void recorrerDRI() {
    try {
        ladoDerecho.recorrerDRI();
    } catch (Exception e) {
    }
    System.out.print(numero+"  ");
    try {
        ladoIzquierdo.recorrerDRI();
    } catch (Exception e) {
    }
  }

  public void recorrerDIR() {
    try {
        ladoDerecho.recorrerDIR();
    } catch (Exception e) {
    }
    try {
        ladoIzquierdo.recorrerDIR();
    } catch (Exception e) {
    }
    System.out.print(numero+"  ");
  }
  
  public void recorrerRID() {
    System.out.print(numero+"  ");
    try {
        ladoIzquierdo.recorrerRID();
    } catch (Exception e) {
    }
    try {
        ladoDerecho.recorrerRID();
    } catch (Exception e) {
    }
  }
  
  public void recorrerRDI() {
    System.out.print(numero+"  ");
    try {
        ladoDerecho.recorrerRDI();
    } catch (Exception e) {
    }
    try {
        ladoIzquierdo.recorrerRDI();
    } catch (Exception e) {
    }
  }

  public int altura() {
      int altura = 1;
      try {
          altura += Math.max(ladoIzquierdo.altura(), ladoDerecho.altura());
      } catch (NullPointerException e) {
          try {
              altura += ladoIzquierdo.altura();
          } catch (NullPointerException e1) {
          }
          try {
              altura += ladoDerecho.altura();
          } catch (NullPointerException e1) {
          }
      }
      return altura;
  }

  public int cantidadHijos() {
      int cantidad = 0;
      if (ladoDerecho != null) {
          cantidad += 1 + ladoDerecho.cantidadHijos();
      }
      if (ladoIzquierdo != null) {
          cantidad += 1 + ladoIzquierdo.cantidadHijos();
      }
      return cantidad;
  }

  public boolean esHoja() {
      return (ladoIzquierdo == null && ladoDerecho == null);
  }

  public void recorrer() {
      System.out.println("");
      System.out.println(numero);
      if (esHijo == -1) {
          System.out.println("Hijo Izquierdo");
      } else if (esHijo == 1) {

          System.out.println("Hijo Derecho");
      } else {
          System.out.println("Raiz");
      }
      System.out.println("Profundidad: " + profundidad);
      if (ladoIzquierdo != null) {
          ladoIzquierdo.recorrer();
      }
      if (ladoDerecho != null) {
          ladoDerecho.recorrer();
      }
  }

}
