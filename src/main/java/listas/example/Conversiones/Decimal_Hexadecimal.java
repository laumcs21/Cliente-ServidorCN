package listas.example.Conversiones;

public class Decimal_Hexadecimal {

    public static String convertir_decimal_hexadecimal(int decimal, int anchoHex) {
        if (decimal == 0) {
            // Si el ancho es mayor a 1, rellenar con ceros
            return String.format("%" + anchoHex + "s", "0").replace(' ', '0');
        }

        StringBuilder hex = new StringBuilder();
        char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while (decimal > 0) {
            int residuo = decimal % 16;
            hex.insert(0, hexChars[residuo]);
            decimal = decimal / 16;
        }

        // Ajustar al ancho requerido rellenando con ceros a la izquierda
        while (hex.length() < anchoHex) {
            hex.insert(0, '0');
        }

        return hex.toString();
    }


}
