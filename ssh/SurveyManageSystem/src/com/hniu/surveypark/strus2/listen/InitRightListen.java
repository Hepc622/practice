package com.hniu.surveypark.strus2.listen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.ServletContextAware;

import com.hniu.surveypark.model.Right;
import com.hniu.surveypark.service.RightService;

@SuppressWarnings("rawtypes")
public class InitRightListen implements ApplicationListener, ServletContextAware {

	private RightService rightService;
	private ServletContext sc;

	public void setRightService(RightService rightService) {
		this.rightService = rightService;
	}

	// ??Spring????????????????????
	public void onApplicationEvent(ApplicationEvent arg0) {
		// ???????????????
		if (arg0 instanceof ContextRefreshedEvent) {
			// ??????????
			List<Right> right = rightService.getAllRight();
			// ????????????map??
			Map<String, Right> map = new HashMap<String, Right>();
			for (Right r : right) {
				map.put(r.getRight_url(), r);
			}
			// ??map????Application??
			sc.setAttribute("all_right", map);
		}
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		this.sc = arg0;
	}

}
