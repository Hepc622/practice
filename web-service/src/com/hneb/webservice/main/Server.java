package com.hneb.webservice.main;

import javax.xml.ws.Endpoint;

import com.hneb.webservice.imp.CalculateServiceImp;

/**
 * @author hpc 
 * 2017年7月22日 上午10:55:00
 */
public class Server {
	public static void main(String[] args) {
		String address="http://localhost/";
		Endpoint.publish(address, new CalculateServiceImp());
	}
}
