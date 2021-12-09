# funcion realizada para particionar el arreglo y devolver el pivote que tomará nuestro algoritmo
def particion(listaOrganizada, menor, mayor):
  contador = menor-1
  # definición de pivote
  pivote = listaOrganizada[mayor]
  # recorremos el arreglo evaluando si el pivote es mayor
  for j in range(menor, mayor):
    if listaOrganizada[j] <= pivote:
      contador = contador+1
      #intercambiamos
      listaOrganizada[contador], listaOrganizada[j]=listaOrganizada[j], listaOrganizada[contador]
  # Luego intercaambiamos el mayor por el guardado en el contador
  listaOrganizada[contador+1], listaOrganizada[mayor]=listaOrganizada[mayor], listaOrganizada[contador+1]
  # retornamos el contador
  return(contador+1)

# funcion realizada para implementar quick sort recursivamente
def quickSort(listaOrdenada, menor, mayor):
  # evaluamos
  if menor < mayor:
    # Hallamos el indice de particion
    indicep = particion(listaOrdenada, menor, mayor) 
    # evaluamos la primera parte del arreglo
    quickSort(listaOrdenada, menor, indicep-1)
    # evaluamos la parte restante del arreglo
    quickSort(listaOrdenada, indicep+1, mayor)

# pedimos los datos
arreglo = list(int(x) for  x in input().split())

#print(arreglo, len(arreglo)-1)

# aplicamos QuickSort
quickSort(arreglo,0,len(arreglo)-1)
# imprimimos los datos organizados :)
print(arreglo)
  
