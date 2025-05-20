import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcionUsuario = 0;

        Conversion consulta = new Conversion();

        Calculos calculos = new Calculos(consulta);

        List<String> respuesta = new ArrayList<>();

        String menu = """
                \n================================================
                *** Sea bienvenido al Conversor de Monedas ***
                
                1. Dólar Estadounidense >>>> Peso Mexicano
                2. Peso Argentino >>>> Dolar Estadounidense
                3. Libra Esterlina >>>> Peso Mexicano
                4. Peso Colombiano >>>> Dólar Canadiense
                5. Peso Mexicano >>>> Euro
                6. Yen Japones >>>> Shekel Israelí
                7. Otra opción de conversión
                8. Salir
                ================================================
                """;
        while (opcionUsuario != 8) {
            try {
                System.out.println(menu);
                opcionUsuario = Integer.parseInt(lectura.nextLine());

                switch (opcionUsuario){
                    case 1:
                        calculos.valores("USD", "MXN");
                        respuesta.add(calculos.devuelveMensaje());
                        break;
                    case 2:
                        calculos.valores("ARG", "USD");
                        respuesta.add(calculos.devuelveMensaje());
                        break;
                    case 3:
                        calculos.valores("GBP", "MXN");
                        respuesta.add(calculos.devuelveMensaje());
                        break;
                    case 4:
                        calculos.valores("COP", "CAD");
                        respuesta.add(calculos.devuelveMensaje());
                        break;
                    case 5:
                        calculos.valores("MXN", "EUR");
                        respuesta.add(calculos.devuelveMensaje());
                        break;
                    case 6:
                        calculos.valores("JPY", "ILS");
                        respuesta.add(calculos.devuelveMensaje());
                        break;
                    case 7:
                        calculos.otrosValores();
                        respuesta.add(calculos.devuelveMensaje());
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Ingrese una opción válida");
                }
            }catch (JsonSyntaxException | NullPointerException e){
                System.out.println("Error. Por favor, Ingresa solo códigos de moneda válidos.");
            }catch (NumberFormatException | InputMismatchException e){
                System.out.println("Error. Por favor, Ingresa un valor numérico válido.");
            }
        }
        System.out.println("Saliendo...");
    }
}