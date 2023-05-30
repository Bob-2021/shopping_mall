package bob.shopping_mall;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "bob.shopping_mall.coupon.feign")
@SpringBootApplication
public class ShoppingMallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallCouponApplication.class, args);
    }

}
