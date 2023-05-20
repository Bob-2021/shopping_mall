package bob.shopping_mall.product;

import bob.shopping_mall.product.entity.BrandEntity;
import bob.shopping_mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShoppingMallProductApplicationTests {
    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setDescript("Descript2");
        brandEntity.setName("name2");
        brandService.save(brandEntity);
    }

}
