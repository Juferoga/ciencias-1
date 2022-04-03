public class NodoArbol {
  
  Comparable numero;
  NodoArbol izquierdo, derecho;
  int esHijo = 0;
  int altura;
  int profundidad = 0;
  int fe;

  public NodoArbol(Comparable n, NodoArbol izq, NodoArbol der,  int profundidad) {
    this.numero = n;
    this.izquierdo = izq;
    this.derecho = der;
    this.profundidad = profundidad;
    altura = 0;
  }

  public void recorrerIRD() {
    try {
        izquierdo.recorrerIRD();
    } catch (Exception e) {
    }
    System.out.print(numero+"  ");
    try {
        derecho.recorrerIRD();
    } catch (Exception e) {
    }
  }

  public void recorrerIDR() {
    try {
        izquierdo.recorrerIDR();
    } catch (Exception e) {
    }
    try {
        derecho.recorrerIDR();
    } catch (Exception e) {
    }
    System.out.print(numero+"  ");
  }
  
  public int altura() {
    int altura = 1;
    try {
        altura += Math.max(izquierdo.altura(), derecho.altura());
    } catch (NullPointerException e) {
        try {
            altura += izquierdo.altura();
        } catch (NullPointerException e1) {
        }
        try {
            altura += derecho.altura();
        } catch (NullPointerException e1) {
        }
    }
    return altura;
  }
  
  public int cantidadHijos() {
    int cantidad = 0;
    if (derecho != null) {
        cantidad += 1 + derecho.cantidadHijos();
    }
    if (izquierdo != null) {
        cantidad += 1 + izquierdo.cantidadHijos();
    }
    return cantidad;
  }

  public void recorrer() {
    System.out.println("");
    System.out.println(numero);
    System.out.println("Altura: "+altura());
    if (esHijo == -1) {
        System.out.println("Hijo Izquierdo");
    } else if (esHijo == 1) {

        System.out.println("Hijo Derecho");
    } else {
        System.out.println("Raiz");
    }
    System.out.println("Profundidad: " + profundidad);
    calcularFe();
    System.out.println("FE: "+getFe());
    if (izquierdo != null) {
        izquierdo.recorrer();
    }
    if (derecho != null) {
        derecho.recorrer();
    }
  }

  public void graficar(NodoArbol nodo){
    for(int i=0; i<(altura()*3); i++){
      if(altura()*2 <= altura())
        System.out.print(" ");
      
    }
  }

  public int getFe(){
    calcularFe();
    return fe;
  }

  public void setFe(int fe){
    this.fe = fe;
  }

  public int getAltura() {
	  return altura;
  }

  public void calcularFe(){
    if (izquierdo != null && derecho != null){
      setFe(derecho.altura() - izquierdo.altura());
    }
    
    if (izquierdo == null && derecho == null){
      setFe(0);
    }
    
    if (derecho == null && izquierdo != null){
      setFe(-izquierdo.altura());
    }
    
    if (izquierdo == null && derecho != null){
      setFe(derecho.altura());
    }

  }
}
