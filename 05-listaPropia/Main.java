class Main {
  public static void main(String[] args) {
    
    //Creadno objeto lista
    Lista lista = new Lista();

    //Comprobando que está vacía
    System.out.println("[===========================================]");
    System.out.println("\n\tMOSTRAR SI ESTÁ VACÍA\n");
    System.out.println("La lista esta vacia: "+lista.estaVacia());

    //Llenando el arreglo
    lista.agregarDato("Hola");
    lista.agregarDato("Buena");
    lista.agregarDato("Hellouda");

    //Comprobando obtener dato
    System.out.println("[===========================================]");
    System.out.println("\n\tMOSTRAR CONTENIDO LLENO\n");
    System.out.println("Dato de pos 0: "+lista.obtenerDato(0));
    System.out.println("Dato de pos 1: "+lista.obtenerDato(1));
    System.out.println("Dato de pos 2: "+lista.obtenerDato(2));

    System.out.println("[===========================================]");
    System.out.println("\n\tMOSTRAR SI ESTÁ VACÍA\n");
    System.out.println("La lista esta vacia: "+lista.estaVacia());

    //PRobando eliminar dato
    System.out.println("[===========================================]");
    System.out.println("\n\tMOSTRAR SI SE BORRA EL ULTIMO DATO\n");
    lista.eliminarDato();
    System.out.println("Dato de pos 2 borrado: "+lista.obtenerDato(2));
    lista.eliminarDato();
    System.out.println("Dato de pos 1 borrado: "+lista.obtenerDato(1));
    lista.eliminarDato();
    System.out.println("Dato de pos 0 borrado: "+lista.obtenerDato(0));

    //Llenando el arreglo
    lista.agregarDato("Hola");
    lista.agregarDato("Buena");
    lista.agregarDato("Hellouda");

    //Comprobando obtener dato
    System.out.println("[===========================================]");
    System.out.println("\n\tMOSTRAR QUE ESTÁ LLENO\n");
    System.out.println("Dato de pos 0: "+lista.obtenerDato(0));
    System.out.println("Dato de pos 1: "+lista.obtenerDato(1));
    System.out.println("Dato de pos 2: "+lista.obtenerDato(2));

    //Eliminando arreglo en pos especifica
    lista.eliminarDato(1);

    //Comprobando obtener dato
    System.out.println("[===========================================]");
    System.out.println("\n\tMOSTRAR QUE SE BORRA DATO EN POSICIÓN ESPECÍFICA\n");
    System.out.println("Dato de pos 0: "+lista.obtenerDato(0));
    System.out.println("Dato de pos 1: "+lista.obtenerDato(1));
    System.out.println("Dato de pos 2: "+lista.obtenerDato(2));

    //reemplazando datos
    lista.reemplazarDato(1, "Hola que hace");

    //Comprobando obtener dato
    System.out.println("[===========================================]");
    System.out.println("\n\tMOSTRAR QUE SE REEMPLAZA UN DATO\n");
    System.out.println("Dato de pos 0: "+lista.obtenerDato(0));
    System.out.println("Dato de pos 1: "+lista.obtenerDato(1));
    System.out.println("Dato de pos 2: "+lista.obtenerDato(2));

    //Intercambio de datos
    lista.intercabiar(0, 1);

    //Comprobando obtener dato
    System.out.println("[===========================================]");
    System.out.println("\n\tMOSTRAR INTERCAMBIO DE DATOS\n");
    System.out.println("Dato de pos 0: "+lista.obtenerDato(0));
    System.out.println("Dato de pos 1: "+lista.obtenerDato(1));
    System.out.println("Dato de pos 2: "+lista.obtenerDato(2));

    //vaciando arreglo
    lista.limpiar();

    //Comprobando obtener dato
    System.out.println("[===========================================]");
    System.out.println("\n\tMOSTRAR QUE SE BORRA TODA LA LISTA\n");
    System.out.println("Dato de pos 0: "+lista.obtenerDato(0));
    System.out.println("Dato de pos 1: "+lista.obtenerDato(1));
    System.out.println("Dato de pos 2: "+lista.obtenerDato(2));

    System.out.println("[===========================================]");
    System.out.println("\n\tMOSTRAR SI ESTÁ VACÍA\n");
    System.out.println("La lista esta vacia: "+lista.estaVacia());
  }
}