public class ArbolBinario<E> {

  public NodoArbol raiz;

  public ArbolBinario() {
      raiz = null;
  }

  public void insertar( Comparable x ){
        raiz = insertar(x, raiz);
    }

  private NodoArbol insertar(Comparable x, NodoArbol t){
    if( t == null )
        t = new NodoArbol(x, null, null, 0);
    else if( x.compareTo( t.numero ) < 0 ) {
        t.izquierdo = insertar( x, t.izquierdo );
        t.izquierdo.esHijo = -1;
        t.izquierdo.profundidad = t.profundidad + 1;
        if( altura( t.izquierdo ) - altura( t.derecho ) == 2 )
            if( x.compareTo( t.izquierdo.numero ) < 0 )
                t = rotIzquierda( t );
            else
                t = dobleRotIzquierda( t );
    }
    else if( x.compareTo( t.numero ) > 0 ) {
      t.derecho = insertar( x, t.derecho );
      t.derecho.esHijo = 1;
      t.derecho.profundidad = t.profundidad + 1;
      if( altura( t.derecho ) - altura( t.izquierdo ) == 2 )
          if( x.compareTo( t.derecho.numero ) > 0 )
              t = rotDerecha( t );
          else
              t = dobleRotDerecha( t );
    }
    else
        ; 
    t.altura = max( altura( t.izquierdo ), altura( t.derecho ) ) + 1;
    return t;
  }

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

  public int cantidadNodos() {
    return 1 + raiz.cantidadHijos();
  }

  public int altura(){
    return raiz.altura();
  }

  public void recorrido() {
    raiz.recorrer();
  }

  private static int max( int lhs, int rhs ){
    return lhs > rhs ? lhs : rhs;
  }

  private static NodoArbol rotIzquierda( NodoArbol k2 ){
    NodoArbol k1 = k2.izquierdo;
    k2.izquierdo = k1.derecho;
    k1.derecho = k2;

    return k1;
  }


  private static NodoArbol rotDerecha( NodoArbol k1 ){
    NodoArbol k2 = k1.derecho;
    k1.derecho = k2.izquierdo;
    k2.izquierdo = k1;
        
    return k2;
  }


  private static NodoArbol dobleRotIzquierda( NodoArbol k3 ){
    k3.izquierdo = rotDerecha( k3.izquierdo );
    return rotIzquierda( k3 );
  }


  private static NodoArbol dobleRotDerecha( NodoArbol k3 ){
    k3.izquierdo = rotDerecha( k3.izquierdo );
    return rotIzquierda( k3 );
  }


  private static int altura( NodoArbol t ){
    return t == null ? -1 : t.altura;
  }

  public void mostrarArbol(){
      mostrarArbol(raiz, altura());
  }

  private void mostrarArbol(NodoArbol nodo, int alturaMax){

    int max = 0;
    int nivel = altura();

    for ( ; nivel >= 0; nivel--)
        max += Math.pow(2, nivel);
    max++;    
    NodoArbol cola[] = new NodoArbol[max];
    String posicion[] = new String[max];

    cola[1] = nodo;
    posicion[1] = "raiz";
    int x = 1;

    for (int i = 2; i < max; i += 2, x++){
      if (cola[x] == null){
        cola[i] = null;
        cola[i + 1] = null;
      }
      else{
        if(cola[x].izquierdo == null)
          posicion[i] = "izq_vacio";
        else
          posicion[i] = "izq_lleno";

        if(cola[x].derecho == null)
          posicion[i+1] = "der_vacio";
        else
          posicion[i+1] = "der_lleno";
        
        cola[i]   = cola[x].izquierdo;
        //System.out.println(cola[x].derecho.numero);
        cola[i + 1] = cola[x].derecho;
      }
    }
    nivel = 0;
    int cont = 0;
    int cantidad = 1;
    int ultimaPosicion = 1;
    
    for (int i = 1; i < max; i++){
       //System.out.println("Posicion: "+posicion[i]);
        if(i == Math.pow(2, nivel)){
          System.out.print("\n Nivel " + (nivel) + ": ");
          nivel++;

          for(int k=0; k<alturaMax; k++)
            System.out.print("\t");
          
          if(alturaMax > 2){
            for(int k=2; k<alturaMax; k++){}
              System.out.print("   ");
          }

        }
      
        try{
          
          if(posicion[i].equals("izq_vacio")){
            //System.out.print("Entra 1");
            for(int k=0; k<=alturaMax; k++)
              System.out.print("       ");
          }

          /*if(posicion[i].equals("izq_lleno") && posicion[i+1].equals("der_lleno")){
            //System.out.print("Entra 2");
            for(int k=0; k<=alturaMax; k++)
              System.out.print("       ");
          }*/
          
        }catch(NullPointerException e){}
        
        if(cola[i] != null){
          System.out.print(",");
          try{
            for(int k=0; k<alturaMax; k++)
              System.out.print("---");
          }catch(NullPointerException e){}
          
          System.out.print(cola[i].numero);

          try{
            for(int k=0; k<alturaMax; k++)
              System.out.print("---");
          }catch(NullPointerException e){}

          System.out.print(",");
          cont++;
        }

      try{
        if(posicion[i].equals("izq_lleno") && posicion[i+1].equals("der_lleno")){
          //for(int k=0; k<=alturaMax; k++)
          //System.out.print("Entra 4");
            System.out.print("     ");
        }
        
        if(posicion[i].equals("der_vacio")){
          //System.out.print("Entra 5");
          for(int k=0; k<=alturaMax; k++)
            System.out.print("   ");
        }
      }catch(NullPointerException e){}
      
        if(ultimaPosicion == i  && cantidad == Math.pow(2, --nivel)){                
          cont = 0;
          cantidad *= 2;
          ultimaPosicion += (int)Math.pow(2, ++nivel);
          alturaMax--;
        }
    }
  }
}