package com.qa.julyQA.exception;

import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Juice does not exist with that I")
public class JuiceException extends EntityNotFoundException  {
	

	
}
