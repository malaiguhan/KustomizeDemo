package com.demo.kustomize;

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
import scala.reflect.ClassTag;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
	public ResponseEntity<String> greet(@PathVariable String name){
		return ResponseEntity.ok(String.format("%s %s! " ,System.getenv("GREETING"), name));
	}

}




















