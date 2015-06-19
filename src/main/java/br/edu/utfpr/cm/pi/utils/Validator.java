package br.edu.utfpr.cm.pi.utils;

public class Validator {

    public static boolean validarCPF(String cpf) {

        int d1 = 0, d2 = 0;
        int ps1 = 10, ps2 = 11;
        int[] CPF;
        if (cpf.length() != 11 || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")
                || cpf.equals("00000000000")) {

            return false;
        } else {

            CPF = Funcoes.StringToArrayInt(cpf);

            // Calcula o primeiro dígito verificador.
            for (int i = 0; i < CPF.length - 2; i++) {
                d1 += CPF[i] * ps1;
                ps1--;
            }

            d1 = d1 % 11;

            if (d1 == 0 || d1 == 1) {
                d1 = 0;
            } else {
                d1 = 11 - d1;
            }

            // Calcula o segundo dígito verificador.
            for (int i = 0; i < CPF.length - 1; i++) {
                d2 += CPF[i] * ps2;
                ps2--;
            }

            d2 = d2 % 11;

            if (d2 == 0 || d2 == 1) {
                d2 = 0;
            } else {
                d2 = 11 - d2;
            }
        }

        // Compara os dígitos obtidos com os informados no CPF.
        if (d1 == CPF[9] && d2 == CPF[10]) {

            return true;
        } else {

            return false;
        }
    }
}