import java.util.Scanner;

public class Calculos {
    private String monedaOrigen;
    private String monedaCambio;
    private double cantidad;


    Scanner lectura = new Scanner(System.in);
    Conversion conversion;


    public Calculos(Conversion conversion){
        this.conversion = conversion;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaCambio() {
        return monedaCambio;
    }

    public double getCantidad() {
        return cantidad;
    }
    public void valores(String monedaOrigen, String monedaCambio){
        this.monedaOrigen = monedaOrigen;
        this.monedaCambio = monedaCambio;

        System.out.println("Ingrese el valor que deseas convertir");

        this.cantidad = Double.parseDouble(lectura.nextLine());
    }
    public void otrosValores (){
        String menuOtrasOpciones = """
                Currency Code       Currency Name       Country
                AED UAE Dirham                          United Arab Emirates
                AOA	Angolan Kwanza	                    Angola
                ARS	Peso Argentino	                    Argentina
                AUD	Australian Dollar	                Australia
                BOB	Bolivian Boliviano	                Bolivia
                BRL	Brazilian Real	                    Brazil
                CAD	Dolar Canadiense                    Canada
                CHF	Swiss Franc	                        Switzerland
                CLP	Chilean Peso	                    Chile
                CNY	Chinese Renminbi	                China
                COP	Peso Colombiano	                    Colombia
                CRC	Costa Rican Colon	                Costa Rica
                CUP	Cuban Peso	                        Cuba
                CZK	Czech Koruna	                    Czech Republic
                DKK	Danish Krone	                    Denmark
                DOP	Dominican Peso	                    Dominican Republic
                EGP	Egyptian Pound	                    Egypt
                EUR	Euro	                            European Union
                GBP	Pound Sterling	                    United Kingdom
                GTQ	Guatemalan Quetzal	                Guatemala
                HNL	Honduran Lempira	                Honduras
                ILS	Israeli New Shekel	                Israel
                JPY	Japanese Yen	                    Japan
                KRW	South Korean Won	                South Korea
                MXN	Peso Mexicano	                    Mexico
                NZD	New Zealand Dollar	                New Zealand
                PAB	Panamanian Balboa	                Panama
                PEN	Peruvian Sol	                    Peru
                PKR	Pakistani Rupee	                    Pakistan
                PLN	Polish Złoty	                    Poland
                PYG	Paraguayan Guaraní	                Paraguay
                QAR	Qatari Riyal	                    Qatar
                RON	Romanian Leu	                    Romania
                RSD	Serbian Dinar	                    Serbia
                RUB	Russian Ruble	                    Russia
                SAR	Saudi Riyal	Saudi                   Arabia
                SEK	Swedish Krona	                    Sweden
                SYP	Syrian Pound	                    Syria
                TND	Tunisian Dinar	                    Tunisia
                TRY	Turkish Lira	                    Turkey
                UAH	Ukrainian Hryvnia	                Ukraine
                USD	Dollar Estadounidense	            United States
                UYU	Peso Uruguayo	                    Uruguay
                VES	Venezuelan Bolívar Soberano	        Venezuela
                """;
        System.out.println(menuOtrasOpciones);
        System.out.println("Ingrese la moneda origen con 3 letras");
        this.monedaOrigen = lectura.next();
        System.out.println("Ingrese la moneda a cambiar con 3 letras");
        this.monedaCambio = lectura.next();

        boolean entradaValida = false;
        do {
            System.out.println("Ingrese el valor que deseas convertir");
            if (lectura.hasNextDouble()) {
                this.cantidad = lectura.nextDouble();
                entradaValida = true;
            } else {
                System.out.println("Error. Ingrese un valor numérico.");
                lectura.next();
            }
        } while ( !entradaValida);
    }


    public String devuelveMensaje(){
        String mensaje = getMonedaOrigen().toUpperCase() + " "
                + getCantidad() + " equivale a: " + getMonedaCambio().toUpperCase() + " " +
                conversion.buscaDivisa(getMonedaOrigen(),getMonedaCambio(),getCantidad());
        System.out.println(mensaje);
        return mensaje;
    }
}

