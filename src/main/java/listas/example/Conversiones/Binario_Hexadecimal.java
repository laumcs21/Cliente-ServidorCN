package listas.example.Conversiones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Binario_Hexadecimal {

    private static final Map<String, Character> BinToHexMap = new HashMap<>();

    static {
        BinToHexMap.put("0000", '0');
        BinToHexMap.put("0001", '1');
        BinToHexMap.put("0010", '2');
        BinToHexMap.put("0011", '3');
        BinToHexMap.put("0100", '4');
        BinToHexMap.put("0101", '5');
        BinToHexMap.put("0110", '6');
        BinToHexMap.put("0111", '7');
        BinToHexMap.put("1000", '8');
        BinToHexMap.put("1001", '9');
        BinToHexMap.put("1010", 'A');
        BinToHexMap.put("1011", 'B');
        BinToHexMap.put("1100", 'C');
        BinToHexMap.put("1101", 'D');
        BinToHexMap.put("1110", 'E');
        BinToHexMap.put("1111", 'F');
    }

    public String convertir_Binario_Hexadecimal(String bin, int anchoHex) {
        StringBuilder numeroHexadecimal = new StringBuilder();
        ArrayList<Character> caracteres = new ArrayList<>();

        // Guardar todos los dígitos binarios
        for (int i = 0; i < bin.length(); i++) {
            caracteres.add(bin.charAt(i));
        }

        // Rellenar con ceros a la izquierda hasta múltiplo de 4
        while (caracteres.size() % 4 != 0) {
            caracteres.add(0, '0');
        }

        // Convertir cada grupo de 4 bits en hexadecimal
        for (int i = 0; i < caracteres.size(); i += 4) {
            StringBuilder grupo = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                grupo.append(caracteres.get(i + j));
            }
            numeroHexadecimal.append(BinToHexMap.get(grupo.toString()));
        }

        // Ajustar al ancho requerido (rellenar con ceros a la izquierda si hace falta)
        while (numeroHexadecimal.length() < anchoHex) {
            numeroHexadecimal.insert(0, '0');
        }

        return numeroHexadecimal.toString();
    }


}
