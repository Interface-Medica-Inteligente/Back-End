package br.ufs.dcomp.interfacemedicainteligente.useful;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import br.ufs.dcomp.interfacemedicainteligente.exception.RegraNegocioException;

public class ValidacaoUtil {
	public static <T> void validarCmd(T cmd, Validator validator) {
		Set<ConstraintViolation<T>> violations = validator.validate(cmd);
		if (!violations.isEmpty()) {
			throw new RegraNegocioException(violations.stream().findFirst().get().getMessage());
		}
	}
}
