package listas.example.Conversiones;



public class Decimal_Hexadecimal {
    public static String convertir_decimal_hexadecimal(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder hex = new StringBuilder();
        char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while (decimal > 0) {
            int residuo = decimal % 16;
            hex.insert(0, hexChars[residuo]);
            decimal = decimal / 16;
        }

        return hex.toString();
    }

}
