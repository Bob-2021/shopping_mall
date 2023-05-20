package bob.shopping_mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("bob.shopping_mall.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class ShoppingMallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallProductApplication.class, args);
    }

}
