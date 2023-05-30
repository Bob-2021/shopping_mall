package bob.shopping_mall.product.service;

import bob.shopping_mall.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import bob.shopping_mall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author bob
 * @email none
 * @date 2023-05-14 01:11:05
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);

}

