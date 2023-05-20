package bob.shopping_mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.coupon.entity.CouponSpuCategoryRelationEntity;

import java.util.Map;

/**
 * 优惠券分类关联
 *
 * @author bob
 * @email none
 * @date 2023-05-17 16:51:40
 */
public interface CouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

