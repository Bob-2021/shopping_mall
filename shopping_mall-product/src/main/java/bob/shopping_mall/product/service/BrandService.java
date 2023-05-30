package bob.shopping_mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author bob
 * @email none
 * @date 2023-05-14 01:11:05
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

