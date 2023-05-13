package bob.shopping_mall.product.service;

import bob.shopping_mall.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import bob.shopping_mall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author bob
 * @email none
 * @date 2023-05-14 01:11:05
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

