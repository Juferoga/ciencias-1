def busqueda():
  for i in range(N,2,-1):
    #print("Ciclos: ",i)
    if ((totPer%i) == 0):
      arcLen = int(totPer/i)
      #print(arcLen)
      for j in range(0,arcLen,1):
        #print(arcLen)
        isPos = True
        k = j

        while(k < totPer):
          #print("Bueeeeeenas")
          if(per[k] == False): isPos = False
          k += arcLen
    
        if(isPos == True): return (N-i)
    isPos = False
  
  return "-1"

while(True):
  #Atributos
  totPer = 0
  arcLen = 0
  verLen = 0
  aux = 0
  k = 0
  isPos = True

  N = int(input())
  if(N == 0): break

  #Lectura de datos
  X = list(int(x) for  x in input().split())
  for i in range(0,N,1):
    totPer += X[i]

  per = list(False for x in range(0,totPer,1))
  
  for i in range(0,N,1):
    per[verLen] = True
    verLen += X[i]
  
  print(busqueda())

  

