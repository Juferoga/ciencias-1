#Función para ordenamiento por shell sort
def shell_sort(arr_ordenado):
  #Se inicia guardando el valor del intervalo
  intervalo = len(arr_ordenado)
  
  while(intervalo > 0):
    #Se inicia un iterador en 0
    i = 0
    #Se divide el intervalo en dos y se toma solo su parte entera
    intervalo = int(intervalo/2)
    #Ciclo para evaluar dos elementos teninedno presente el intervalo
    while(i+intervalo < (len(arr_ordenado))):
      #Si el primero es mayor al manor se cambia
      if(arr_ordenado[i] > arr_ordenado[i+intervalo]):
        aux = arr_ordenado[i]
        arr_ordenado[i] = arr_ordenado[i+intervalo]
        arr_ordenado[i+intervalo] = aux
        #Revisando si las posiciones anteriores también son menores
        j=i
        while(j-intervalo >= 0):
          if(arr_ordenado[j] < arr_ordenado[j-intervalo]):
            aux = arr_ordenado[j]
            arr_ordenado[j] = arr_ordenado[j-intervalo]
            arr_ordenado[j-intervalo] = aux
            j-=intervalo
          else: break
      
      i += 1

    if(intervalo == 1): return arr_ordenado

#Lectura de datos
arreglo = list(int(x) for  x in input().split())
arr_ordenado = arreglo[0:]
arr_ordenado = shell_sort(arr_ordenado)
#print("Arreglo inicial: ",arreglo)
#print("Arreglo ordenado: ",arr_ordenado)
print(arr_ordenado)

