package bob.shopping_mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.ware.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author bob
 * @email none
 * @date 2023-05-17 17:37:31
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

