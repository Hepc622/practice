package com.home.springmvc.forwardredirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 此类是：This is Springmvc of forward and redirect example
 * 	use mode:
 * 		return charstring of front add "forward:" or "redirect:" in method
 * 		used to conforim the way of using
 * @author hpc
 * @2017年2月19日上午11:53:10
 */
@Controller
public class SpringmvcForwardRedirect {
	/**
	 * 	 The request method is forward mode
	 */
	@RequestMapping("/springmvcForward")
	public String springmvcForward(){
		return "forward:/success";
	}
	/**
	 * The method is redirect request mode
	 */
	@RequestMapping("/springmvcRedirect")
	public String springmvcRedirect(){
		return "redirect:/success";
	}
}
