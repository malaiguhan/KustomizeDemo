package com.demo.kustomize;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class KustomizeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KustomizeDemoApplication.class);
	}


	@GetMapping("/hello/{name}")
	public ResponseEntity<String> greet(@PathVariable String name, HttpServletRequest request){
		Enumeration<String> headerNames = request.getHeaderNames();
		Map<String,String> headerMap = new HashMap<>();
		while(headerNames.hasMoreElements()) {
			String nextElement = headerNames.nextElement();
			headerMap.put(nextElement,request.getHeader(nextElement));
		}
		return ResponseEntity.ok(String.format("%s %s!. Have a good day! please find the headers attached %s" ,System.getenv("GREETING"), name, headerMap));
	}

}




















