package bob.shopping_mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.ware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author bob
 * @email none
 * @date 2023-05-17 17:37:31
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

