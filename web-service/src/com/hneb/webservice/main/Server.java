package com.hneb.webservice.main;

import javax.xml.ws.Endpoint;

import com.hneb.webservice.imp.CalculateServiceImp;

/**
 * @author hpc 
 * 2017��7��22�� ����10:55:00
 */
public class Server {
	public static void main(String[] args) {
		String address="http://localhost/";
		Endpoint.publish(address, new CalculateServiceImp());
	}
}
