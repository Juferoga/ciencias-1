import numpy as np

def div_casillas(arreglo,columna):

  sub_columna = 0;
  while((columna - sub_columna) > 0):

    if(columna - sub_columna > 2):

      if((arreglo[sub_columna] + arreglo[sub_columna+2]-1) > arreglo[sub_columna+1]):
        arreglo[sub_columna+1] = 0
        sub_columna += 1
      else:
        arreglo[sub_columna] = 0
        arreglo[sub_columna+2] = 0
        sub_columna += 1
    
    elif((columna - sub_columna) == 2):
      
      if(arreglo[sub_columna] > arreglo[sub_columna+1]):
        arreglo[sub_columna+1] = 0
        sub_columna += 2
      else:
        arreglo[sub_columna] = 0
        sub_columna += 2
    else:
      sub_columna += 1

  return arreglo

#Lectura de los datos

while(True):

  tamanio = input()
  if(tamanio == "0 0"):
    exit()

  tamanio = (tamanio.split())
  fila = int(tamanio[0])
  columna = int(tamanio[1])
  arreglo = np.zeros((fila, columna), int)

  for i in range(0, fila, 1):
    aux = input()
    aux = aux.split();
    arreglo[i] = list(map(int, aux))

  #<------------------------- Intento 2 -------------------------------

  for i in range(0, fila, 1):

    arr_aux = arreglo[i][:]
    arreglo[i] = div_casillas(arr_aux,columna)
  
  #print(arreglo)
  arr_2 = np.sum(arreglo, axis=1)
  div_casillas(arr_2,fila)

  print(np.sum(arr_2, axis=0))

