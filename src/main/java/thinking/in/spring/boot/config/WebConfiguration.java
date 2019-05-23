package thinking.in.spring.boot.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Configuration
@SpringBootApplication
//@EnableAutoConfiguration
public class WebConfiguration {

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event){
        System.out.println("-------------->当前webServer实现类是："+event.getWebServer().getClass().getName());
    }

    @Bean
    public RouterFunction<ServerResponse> helloWord(){
        return route(GET("/hello-word"),request -> ok().body(Mono.just("Hello,Word333") , String.class));
    }

    @Bean
    public ApplicationRunner runner(BeanFactory beanFactory){
        return args -> {
            System.out.println("------------->Hello Word Bean 实现类："+beanFactory.getBean("helloWord").getClass().getName());
            System.out.println("------------->WebConfiguration Bean 实现类："+beanFactory.getBean(WebConfiguration.class).getClass().getName());
        };
    }
}
