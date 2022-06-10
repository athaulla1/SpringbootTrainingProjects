package com.lntedutech.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouting(RouteLocatorBuilder builder)
	{
		return builder.routes()
			
				
				//predicate-action, Filters..
			.route(p -> p.path("/get")
					.filters(f -> f
							.addRequestHeader("MyHeader", "MyValue")
							.addRequestParameter("Param", "MyParam"))
					.uri("http://httpbin.org:80"))
			
			//localhost:8675/currency-exchange/currency-exchange/from/{from}/to/{}
			.route(p -> p.path("/currency-exchange/**")
					.uri("lb://currency-exchange"))
			//localhost:xxxx/currency-exchange
			
			.route(p -> p.path("/currency-conversion-feign/**")
					.uri("lb://currency-conversion"))
		
			.route(p -> p.path("/currency-conversion-new/**")
					.filters(f -> f.rewritePath(
							"/currency-conversion-new/(?<segment>.*)", 
							"/currency-conversion-feign/${segment}"))
					.uri("lb://currency-conversion"))
		
			.build();
		
	}

}

//localhost:8765/currency-conversion/currency-conversion/from/USD/to/INR/quantity/10
//localhost:8765/currency-conversion/from/USD/to/INR/quantity/10
			
			
//localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10 to
//localhost:8675/currency-conversion-feign/from/USD/to/INR/quantity/10
						
//localhost:8675/get
//localhost:8675//currency-exchange/from/USD/to.........
//localhost:8675/currency-conversion-feign/from/USD/to/INR/quantity/34

