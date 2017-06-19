package com.xiaoka.camel.timer;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ModelCamelContext;

public class TimerDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ModelCamelContext camelContext = new DefaultCamelContext();
		camelContext.start();
		
		camelContext.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("timer:foo?period=2000").process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
						// TODO Auto-generated method stub
						System.out.println("exchangeid : "+exchange.getExchangeId());
					}
				});
			}
		});
		//防止程序退出
		synchronized (TimerDemo.class) {
			TimerDemo.class.wait();
		}
		
	}

}
