package com.tl666.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class TLExceptionHandler {
		@ExceptionHandler({Exception.class})//捕获所有类的所有异常 相当于catch
		public ModelAndView exceptionTL(Exception e) {
			//redirect   forward
			ModelAndView view = new ModelAndView("exception");
			view.addObject("e", e);
			return view;
		}
//		@RequestMapping("exception")
//		@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE,reason="e")
//		public void exceptionTL2() {
//			
//		}
		
		
			
}
