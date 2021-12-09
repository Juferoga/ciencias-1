#include<iostream>
#include<cassert>
#include<cstring>
#include<algorithm>
#include<vector>

using namespace std;

/* Función menor */
bool menor(const char* p1, const char* p2) {
  // comparación p1 y 2 menor a 0
  return strcmp(p1, p2) < 0;
}
 
/* Función para encontrar cadena*/
void encontrarCad(const char* str) {
  //uso de función assert para hacer la prueba sobre srt
  assert(str);

  //punteros
  const char* p = str;
  // vector de caracteres
  vector<const char*> vec;
  // mientras que p sea diferente a 0
  // regrese p++
  // o recorre la cadena de texto
  while (*p != 0) {  
    // de lo más grande a lo más chico
    vec.push_back(p++);
  }    

  // Organizar el vector inicio, final y si es menor
  sort(vec.begin(), vec.end(), menor);

  // actual maximo
  int curmax = 0;
  
  const char* pmax = str;
  
  // repita en en la longitud del vector
  for (int i = 0; i < vec.size() - 1; ++i) {
    // longitud
    int lon = 0;
    // definición de iterador de patron 1 y 2 
    const char* piter1 = vec[i];
    const char* piter2 = vec[i+1];


    while (*piter1 != 0 && *piter2 != 0 && *piter1 == *piter2) { //prefijos de patron
    
      // impresión de iteradores
      // cout<<endl<<"iteradores > "<<*piter1<<" == "<<*piter2;//<<"Piter 2  "<<piter2;
      piter1++, piter2++;
      // aumento de longitud
      lon++;
    }

    if (lon > curmax) {
      // Guarda el actual máximo
      pmax = vec[i];
      // improme el maximo actual
      // cout<<endl<<endl<<"Pmax  "<<pmax<<endl;
      // actualiza el máximo
      curmax = lon;
    }
  }
 
  cout<<endl<<endl<<"╔═══════[ Cadena más larga repetida ]═══════╗"<<endl;
  cout<<"║                     ";
  for (int i = 0; i < curmax; ++i) {
    // imprime los items del arreglo creado con el máximo repetido
    cout<<*pmax++;
  }
  cout<<"                  ║";
  cout<<endl<<"╚═══════════════════════════════════════════╝"<<endl;    
  cout<<endl;
}

int main() {
  char s[] = "abbabbabbabbabbabbabb";
  /*"abcababcaaabaaaabcjhkjfhskljdhfkjsjdjshkadfhkjashfjkashkfhesuhlkhaskhakshajkhahakjhaskjhdsajhfajshfkashdfkhaskjhdhahaduiahiedwehwihidaiwhdiwhihiwhdaiwhehidadehuawihidhudehdhahdkajdhkahdhuawhdkjsdcju";*/
  encontrarCad(s);
  return 0;
}
