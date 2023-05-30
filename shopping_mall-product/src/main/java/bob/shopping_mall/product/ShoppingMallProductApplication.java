package bob.shopping_mall.product;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ShoppingMallProductApplication {
    //port: 8088
    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallProductApplication.class, args);
    }

}
