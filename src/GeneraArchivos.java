import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneraArchivos {
    public void archivoJson(List<String> lista){
        try {
            FileWriter fileWriter = new FileWriter("historial.txt");
            for (String resultado : lista) {
                fileWriter.write(resultado);
                fileWriter.write("\n");
            }
            fileWriter.close();
            System.out.println("Consultas guardadas en 'historial.txt'");
            } catch (IOException e) {
            System.out.println("No se puede guardar las consultas:" + e.getMessage());
        }
    }
}
