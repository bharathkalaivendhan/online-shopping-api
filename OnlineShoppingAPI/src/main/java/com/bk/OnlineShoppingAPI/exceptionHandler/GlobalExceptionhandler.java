package com.bk.OnlineShoppingAPI.exceptionHandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bk.OnlineShoppingAPI.product.ProductNotFoundException;
import com.bk.OnlineShoppingAPI.seller.SellerNotFoundException;



@ControllerAdvice
public class GlobalExceptionhandler {

	@ExceptionHandler(SellerNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleSellerNotFoundExceptionEntity(HttpServletRequest req, Exception ex)
	{
		ErrorInfo erroInfo = new ErrorInfo(req.getRequestURI().toString(), ex.getMessage());
		return new ResponseEntity<ErrorInfo>(erroInfo,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleProductNotFoundException(HttpServletRequest req, Exception ex)
	{
		ErrorInfo erroInfo = new ErrorInfo(req.getRequestURI().toString(), ex.getMessage());
		return new ResponseEntity<ErrorInfo>(erroInfo,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidRatingException.class)
	public ResponseEntity<ErrorInfo> handleInvalidRatingException(HttpServletRequest req, Exception ex)
	{
		ErrorInfo erroInfo = new ErrorInfo(req.getRequestURI().toString(), ex.getMessage());
		return new ResponseEntity<ErrorInfo>(erroInfo,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorInfo> handleHttpMessageNotReadableException(HttpServletRequest req)
	{
		ErrorInfo errorInfo = new ErrorInfo(req.getRequestURI().toString(), "Provide Valid Seller Info in Request Body");
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ErrorInfo> handleEmptyResultDataAccessException(HttpServletRequest req)
	{
		ErrorInfo errorInfo = new ErrorInfo(req.getRequestURI().toString(), "Seller With Given Id is Not Found");
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorInfo> handleHttpRequestMethodNotSupportedException(HttpServletRequest req)
	{
		ErrorInfo errorInfo = new ErrorInfo(req.getRequestURI().toString(), "Provide Valid Http Request Method");
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
	}
}
