package listas.example.Conversiones;

import java.util.HashMap;
import java.util.Map;

public class Hexadecimal_Decimal {
    private static final Map<Character, Integer> hexToDecimal = new HashMap<>();

    static {
        hexToDecimal.put('0', 0);
        hexToDecimal.put('1', 1);
        hexToDecimal.put('2', 2);
        hexToDecimal.put('3', 3);
        hexToDecimal.put('4', 4);
        hexToDecimal.put('5', 5);
        hexToDecimal.put('6', 6);
        hexToDecimal.put('7', 7);
        hexToDecimal.put('8', 8);
        hexToDecimal.put('9', 9);
        hexToDecimal.put('A', 10);
        hexToDecimal.put('B', 11);
        hexToDecimal.put('C', 12);
        hexToDecimal.put('D', 13);
        hexToDecimal.put('E', 14);
        hexToDecimal.put('F', 15);
    }

    public static String convertir_hexadecimal_decimal(String hexadecimal) {
        int decimal = 0;
        int longitud = hexadecimal.length();
        for (int i = 0; i < longitud; i++) {
            char c = Character.toUpperCase(hexadecimal.charAt(i));
            int valor = hexToDecimal.get(c);
            int exponente = longitud - 1 - i;
            decimal += (int) (valor * Math.pow(16, exponente));
        }
        return String.valueOf(decimal);
    }

}
