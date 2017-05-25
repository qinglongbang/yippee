package com.akina;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.akina.mapper")
//启注解事务管理
@EnableTransactionManagement
@EnableAsync
public class YippeeApplication {


    /***
     * 定义错误页面
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/commonView/401.html");
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/commonView/404.html");
                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/commonView/500.html");
                container.addErrorPages(error401Page, error404Page, error500Page);
            }
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(YippeeApplication.class, args);
    }
}
