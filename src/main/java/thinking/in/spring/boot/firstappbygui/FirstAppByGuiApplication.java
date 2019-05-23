package thinking.in.spring.boot.firstappbygui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import thinking.in.spring.boot.config.WebConfiguration;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan
//@SpringBootApplication(scanBasePackages = "thinking.in.spring.boot.config")
public class FirstAppByGuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebConfiguration.class, args);
	}
//
//	@EventListener(WebServerInitializedEvent.class)
//	public void onWebServerReady(WebServerInitializedEvent event){
//        System.out.println("-------------->当前webServer实现类是："+event.getWebServer().getClass().getName());
//    }

//	@Bean
//	public ApplicationRunner runner(WebServerApplicationContext context){
//		return args -> {
//			System.out.println("-------------->当前webServer实现类是："+context.getWebServer().getClass().getName());
//		};
//	}
//	@Bean
//	public RouterFunction<ServerResponse> helloWord(){
//		return route(GET("/hello-word"),request -> ok().body(Mono.just("Hello,Word") , String.class));
//	}

}
