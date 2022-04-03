import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack; 
import java.lang.Math;

// ((10+3*5)-70/2)+7*5

class Main {

  public static LinkedList<String> colaExpresion = new LinkedList<String>();
  public static LinkedList<String> posfija = new LinkedList<String>();
  public static Stack<String> signos = new Stack<String>();
  public static Stack<Double> numeros = new Stack<Double>();

  public static void main(String[] args) {
    new Main();
  }
  // + - * / ^ %
  public Main(){
    Scanner in = new Scanner(System.in);
    String expresion = in.nextLine();
    separarExpresion(expresion);

    System.out.println("\nExpresión ingresada: "+expresion);

    posFija();
    System.out.println("Expresión posfija: "+posfija);

    operar();
    System.out.println("Resultado: "+numeros.pop()+"\n");
  }

  public void operar(){

    final String OPERADORES = "+-*/^%";
  
    while(!posfija.isEmpty()){;

      String a = posfija.poll();
      
      if(OPERADORES.contains(a)){

        double num1, num2;
        num1 = numeros.pop();
        num2 = numeros.pop();

        switch (a){
          case "+":
            numeros.push(num2+num1);
            break; 
          case "-": 
            numeros.push(num2-num1);
            break; 
          case "*":
            numeros.push(num2*num1);
            break;
          case "/":
            numeros.push(num2/num1);
            break;
          case "%":
            numeros.push(num2%num1);
            break; 
          case "^":
            numeros.push(Math.pow(num2, num1));
            break;
          default:
            System.out.println(a);
            break;
        }
      }else{
        numeros.push(Double.parseDouble(a));
      }
    }
  }

  public void separarExpresion(String exp){

    String numero = "";
    exp = "("+exp+")";
    boolean termino = true;
    for( int i=0; i<exp.length(); i++){
      char c = exp.charAt(i);
      if(("()+-*/%^").contains(c+"")){
        if(termino == false){
          colaExpresion.offer(numero);
          termino = true;
          numero = "";
        }
        colaExpresion.offer(c+"");
      }else{
        if(("0123456789,.").contains(c+"")){
          numero += c;
          numero = numero.replace(",",".");
          termino = false;
        }
      }
    }
  }

  public void posFija(){

    final String SIMBOLOS = ")(+-*/^%";
    while(!colaExpresion.isEmpty()){

      String a= colaExpresion.poll();
      
      if(SIMBOLOS.contains(a)){
        if(!a.equals(")")){
          while(true){
            int num_ex = SIMBOLOS.indexOf(a);
            if(num_ex == 1){
              signos.push(a);
              break;
            }else{
              int num_pila = SIMBOLOS.indexOf(signos.peek());
              if(num_ex >= num_pila){
                signos.push(a);
                break;
              }else
                posfija.offer(signos.pop());
            }
          }
        }else{
          String n = "";
          do{
            n = signos.pop();
            if(!n.equals("("))
              posfija.offer(n);
          }while(!n.equals("("));
        }       
      }else{
        posfija.offer(a);
      }
    }
  }
}
