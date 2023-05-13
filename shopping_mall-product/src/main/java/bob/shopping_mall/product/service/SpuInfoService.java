package bob.shopping_mall.product.service;

import bob.shopping_mall.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import bob.shopping_mall.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author bob
 * @email none
 * @date 2023-05-14 01:11:05
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

