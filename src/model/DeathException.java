package model;

public class DeathException extends Exception {
	
	/**
	 * Arroja una excepci�n si el jugador es atropellado por un carro
	 */
	private static final long serialVersionUID = 1L;

	public DeathException(String message) {
		super(message);
	}

}
