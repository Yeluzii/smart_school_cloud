package net.maku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "net.maku.feign")
public class AppIoTApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppIoTApplication.class, args);
    }
}
