import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Practica6_UsoFileOutputStream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese la receta
        System.out.println("Ingrese la receta a registrar (escriba 'FIN' para terminar):");
        StringBuilder receta = new StringBuilder();
        String linea;
        while (!(linea = scanner.nextLine()).equalsIgnoreCase("FIN")) {
            receta.append(linea).append(System.lineSeparator());
        }

        // Solicitar al usuario que ingrese el nombre del archivo
        System.out.println("Ingrese el nombre del archivo (sin extensión):");
        String fileName = scanner.next();

        // Escribir la receta en el archivo
        try (FileOutputStream fos = new FileOutputStream(fileName + ".txt")) {
            byte[] bytesArray = receta.toString().getBytes();
            fos.write(bytesArray);
            System.out.println("Receta escrita en el archivo con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer la receta del archivo
        try (FileInputStream fis = new FileInputStream(fileName + ".txt")) {
            int content;
            System.out.println("Leyendo la receta del archivo:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}