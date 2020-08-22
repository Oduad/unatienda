package mx.unatienda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Son errores inesperados que no sabemos de dónde vienen
// Extender de Exception obligan a definir dentro de throw y el nombre de la interface y
// los métodos que llamen al método están obligados a envolver en try-catch.
// Extender de RuntimeException pueden lanzarse en cuanquierl momento.

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)//-->Para controlar el retorno
//Permite definir el status. Se lanzará esta excepción cuando no sepamos de dónde viene.

public class GeneralServiceException extends RuntimeException{

	public GeneralServiceException() {
		super();
	}

	public GeneralServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GeneralServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public GeneralServiceException(String message) {
		super(message);
	}

	public GeneralServiceException(Throwable cause) {
		super(cause);
	}

}
