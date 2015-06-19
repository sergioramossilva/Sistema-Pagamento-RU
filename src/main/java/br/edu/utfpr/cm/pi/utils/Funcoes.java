package br.edu.utfpr.cm.pi.utils;

public class Funcoes {

    private static int[] arrayInt;

    public static int[] StringToArrayInt(String string) {

        arrayInt = new int[string.length()];

        for (int i = 0; i < string.length(); i++) {
            arrayInt[i] = Integer.parseInt(String.valueOf(string.charAt(i)));
        }
        return arrayInt;
    }
}