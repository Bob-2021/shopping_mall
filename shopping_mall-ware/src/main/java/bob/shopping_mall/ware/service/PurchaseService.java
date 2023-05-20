package bob.shopping_mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.ware.entity.PurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author bob
 * @email none
 * @date 2023-05-17 17:37:31
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

