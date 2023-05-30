package bob.shopping_mall.product.service;

import bob.shopping_mall.product.vo.AttrVo;
import com.baomidou.mybatisplus.extension.service.IService;
import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author bob
 * @email none
 * @date 2023-05-14 01:11:05
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId);
}

