package br.com.desafio.vacinacao.conf.validation;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.desafio.vacinacao.conf.validation.dto.ErrorFormDTO;

@RestControllerAdvice
public class ErrorValidationHandler {
	
	@Autowired
	MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorFormDTO> handle(MethodArgumentNotValidException argumentNotValidException){
		
		List<ErrorFormDTO> errors = new ArrayList<ErrorFormDTO>();
		List<FieldError> fieldErros = argumentNotValidException.getBindingResult().getFieldErrors();
		fieldErros.forEach(erro->{
			String message = messageSource.getMessage(erro,LocaleContextHolder.getLocale());
			ErrorFormDTO errorFormDTO = new ErrorFormDTO(erro.getField(), message);
			errors.add(errorFormDTO);
		});
		return errors;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public List<ErrorFormDTO> handle(ConstraintViolationException exception) {
		
		List<ErrorFormDTO> errors = new ArrayList<>();		
		errors.forEach(e -> {
			String message = "O paciente já está cadastrado";
			ErrorFormDTO error = new ErrorFormDTO(exception.getCause().getMessage(),message);
			errors.add(error);
		});
		return errors;		
	}
		
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public List<ErrorFormDTO> handle(DataIntegrityViolationException exception) {
		
		List<ErrorFormDTO> errors = new ArrayList<>();	
		errors.forEach(e -> {
			String message = "O paciente já está cadastrado";
			ErrorFormDTO error = new ErrorFormDTO(exception.getCause().getMessage(),message);
			errors.add(error);
		});
		return errors;		
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public List<ErrorFormDTO> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception) {
		List<ErrorFormDTO> errors = new ArrayList<>();	
		errors.forEach(e -> {
			String message = "O paciente já está cadastrado";
			ErrorFormDTO error = new ErrorFormDTO(exception.getCause().getMessage(),message);
			errors.add(error);
		});
		return errors;		
	}
	

}
