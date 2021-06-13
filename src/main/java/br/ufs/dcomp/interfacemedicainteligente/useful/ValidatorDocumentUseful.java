package br.ufs.dcomp.interfacemedicainteligente.useful;

import java.util.InputMismatchException;

public class ValidatorDocumentUseful {

	public static boolean validarCpf(String cpf) {
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11))
			return false;

		char digito10, digito11;
		int soma, resto, numero, peso;

		try {

			soma = 0;
			peso = 10;

			for (int i = 0; i < 9; i++) {
				numero = (int) (cpf.charAt(i) - 48);
				soma = soma + (numero * peso);
				peso = peso - 1;
			}

			resto = 11 - (soma % 11);

			if ((resto == 10) || (resto == 11))
				digito10 = '0';
			else
				digito10 = (char) (resto + 48);

			soma = 0;
			peso = 11;

			for (int i = 0; i < 10; i++) {
				numero = (int) (cpf.charAt(i) - 48);
				soma = soma + (numero * peso);
				peso = peso - 1;
			}

			resto = 11 - (soma % 11);

			if ((resto == 10) || (resto == 11))
				digito11 = '0';
			else
				digito11 = (char) (resto + 48);

			if ((digito10 == cpf.charAt(9)) && (digito11 == cpf.charAt(10)))
				return true;
			else
				return false;
		} catch (InputMismatchException erro) {
			return false;
		}
	}
}
