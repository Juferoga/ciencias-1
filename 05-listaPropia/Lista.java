public class Lista<T>{
  //atributos
  private Object arreglo[] = new Object[3];
  int tam = 0;

  public boolean estaVacia(){
    return tam==0;
  }

  public int obtenerTamanio(){
    return tam;
  }

  public T obtenerDato(int pos){
    return (T) this.arreglo[pos];
  }

  public void intercabiar(int pos1, int pos2){
    Object aux = arreglo[pos2];
    arreglo[pos2] = arreglo[pos1];
    arreglo[pos1] = aux;
  }

  public void agregarDato(T dato){
    tam++;
    
    if(tam>arreglo.length/2){

      Object arreglo_aux[] = this.arreglo;
      int newTam = (int)Math.round(this.arreglo.length*1.3);
      this.arreglo = new Object[newTam];

      for(int i=0 ; i<arreglo_aux.length ; i++)
        this.arreglo[i] = arreglo_aux[i];

    }
    this.arreglo[tam-1] = dato;
  }

  public void eliminarDato(){
    this.arreglo[tam-1] = null;
    tam--;

    if(tam< (double) arreglo.length/2 && arreglo.length>3){
      Object arreglo_aux[] = this.arreglo;
      int newTam = (int) Math.round(this.arreglo.length*0.7);
      this.arreglo = new Object[newTam];
      for(int i=0 ; i<arreglo_aux.length-1 ; i++){
        this.arreglo[i] = arreglo_aux[i];
      }
    }
    
  }

  public void eliminarDato(int pos){
    
    this.arreglo[pos] = null;
    for(int i=pos ; i<tam ; i++){
      arreglo[i] = arreglo[i+1];
    }

    if(tam< (double) arreglo.length/2 && arreglo.length>3){
      Object arreglo_aux[] = this.arreglo;
      int newTam = (int) Math.round(this.arreglo.length*0.7);
      this.arreglo = new Object[newTam];
      for(int i=0 ; i<arreglo_aux.length-1 ; i++){
        this.arreglo[i] = arreglo_aux[i];
      }
    }
  }

  public void reemplazarDato(int pos, T dato){
    this.arreglo[pos] = dato;
  }

  public void limpiar(){
    tam=0;
    this.arreglo = new Object[0];
    this.arreglo = new Object[3];
  }

}