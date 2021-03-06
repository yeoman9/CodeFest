package com;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController{

	private static final String PATH = "/error";
	
	@RequestMapping(value = PATH)
    public String error() {
        return "ErrorHandling";
    }
	
	@Override
	public String getErrorPath() {
		return PATH;
	}

}
