import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    new Main();
  }

  public Main() {
    String seguir = "s";
    int valor = 0;

    Scanner in = new Scanner(System.in);
    ArbolBinario<Integer> ab = new ArbolBinario<Integer>();
    
    while(seguir.equals("s")){
      //Lectura de dato y manejo de las excepciones
      while(true){
        try{
          System.out.print("Ingrese un valor entero: ");
          valor = Integer.parseInt(in.nextLine());
          break;
        }catch(NumberFormatException E){
            System.out.print("\n\tNo se ingresado un número entero\n\n");
        }
      }

      //Agregar nodo al arbol
      ab.insertar(valor);

      //Mostrar información referente al arbol
      System.out.println("\n[================ INFORMACIÓN DEL ARBOL ===================]\n");/*
      //System.out.println("Altura: "+ab.altura());
      System.out.println("Cantidad de nodos: "+ab.cantidadNodos());
      System.out.println("\n[================ RECORRIDO BALANCEADO ===================]\n");
      ab.recorrido();*/
      ab.mostrarArbol();
      System.out.println("\n[============================================================]\n");
      
      //Preguntar por salida del programa
      System.out.print("¿Desea agreagar otro nodo? (s/n): ");
      seguir = in.nextLine();
      System.out.println("");

      if(seguir.equals("n") || seguir.equals("N"))
        break;
    }
    
  }
}