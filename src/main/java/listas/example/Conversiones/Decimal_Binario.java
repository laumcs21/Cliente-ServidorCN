package listas.example.Conversiones;


import java.util.Arrays;

public class Decimal_Binario {
    public static String convertir_Decimal_Binario(int decimal, int ancho) {
        char[] bits = new char[ancho];
        Arrays.fill(bits, '0');
        int index = ancho - 1;
        while (decimal > 0 && index >= 0) {
            int residuo = decimal % 2;
            bits[index] = (residuo == 1) ? '1' : '0';
            decimal = decimal / 2;
            index--;
        }
        return new String(bits);
    }

}
