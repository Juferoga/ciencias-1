import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.FileReader;

class Main {
  public static void main(String[] args) {
    ProcessBuilder pb = new ProcessBuilder();
    pb.command("bash","-c","sh /home/runner/Tiempos-Juferoga-UD/execute.sh; echo \"Acción finalizada...\"");

    try {

      Process process = pb.start();

      StringBuilder output = new StringBuilder();

      BufferedReader reader = new BufferedReader(
          new InputStreamReader(process.getInputStream()));
      
      BufferedReader reader_out = new BufferedReader(
          new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line + "\n");
      }

      int exitVal = process.waitFor();
      if (exitVal == 0) {
        System.out.println("Funciono hahah!");
        try {
          System.out.println("Vamos bien");
          BufferedReader br = new BufferedReader(new FileReader("/home/runner/Tiempos-Juferoga-UD/cadena_result"));
            String linea;
          while ((linea = br.readLine()) != null) {
            System.out.println(linea);
          }
          
          br.close();
        }

        catch(Exception e) {
          e.getStackTrace();
          System.out.println("F");
        }
        System.out.println(output);
        System.exit(0);
      } else {
        System.out.println("Se toteo esto hahah!");
      }

    } 
    catch (IOException e) {
      e.printStackTrace();
    } 
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

} 
