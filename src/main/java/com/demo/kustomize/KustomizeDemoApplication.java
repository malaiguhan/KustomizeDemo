package com.demo.kustomize;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.*;
import org.apache.spark.sql.expressions.Window;
import org.apache.spark.sql.expressions.WindowSpec;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.util.LongAccumulator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;
import scala.reflect.ClassTag;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.spark.sql.functions.*;

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




















