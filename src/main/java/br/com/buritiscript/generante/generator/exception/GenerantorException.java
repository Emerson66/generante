package br.com.buritiscript.generante.generator.exception;

public class GenerantorException extends RuntimeException{
    public GenerantorException(String message) {
		super(message);
	}

	public GenerantorException(String message, Throwable cause) {
		super(message, cause);
	}
}
