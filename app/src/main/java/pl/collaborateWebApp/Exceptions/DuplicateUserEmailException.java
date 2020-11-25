package pl.collaborateWebApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Użytkownik z takim adresem email już istnieje!")
public class DuplicateUserEmailException extends RuntimeException {
	
}
