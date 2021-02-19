package top.summus.notionmiddleware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.summus.notionmiddleware.mapper")
public class NotionMiddlewareApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotionMiddlewareApplication.class, args);
    }
}
