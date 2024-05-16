package br.org.serratec.trabalhoindividual.exception;

public class ValidationTitulo {
	
	public static void validarTitulo(String titulo) throws EnumValidationException {
		if (titulo == null || titulo.trim().isEmpty()) {
			throw new EnumValidationException("O título do livro não pode ser vazio ou nulo.");
		}
		if (titulo.length() < 3 || titulo.length() > 100) {
			throw new EnumValidationException("O título do livro deve ter entre 3 e 100 caracteres.");
		}		
	}
}
