package listas.example.Conversiones;

public class Binario_Decimal {

    public static String convertir_Binario_Decimal(String binario) {
        int decimal = 0;
        int longitud = binario.length();


        for (int i = 0; i < longitud; i++) {
            if(binario.charAt(i) != '1' || binario.charAt(i) == '0') {
                return "El numero ingresado no es binario";
            }
            if (binario.charAt(longitud - 1 - i) == '1') {
                decimal += Math.pow(2, i);
            }
        }
        return String.valueOf(decimal);
    }



}
