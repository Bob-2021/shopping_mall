package bob.shopping_mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ***
 * 2023-05-20 16:03
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "bob.shopping_mall.member.feign")
@SpringBootApplication
public class ShoppingMallMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallMemberApplication.class, args);
    }
}
