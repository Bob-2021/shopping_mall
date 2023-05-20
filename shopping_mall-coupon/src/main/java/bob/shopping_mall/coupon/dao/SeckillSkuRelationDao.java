package bob.shopping_mall.coupon.dao;

import bob.shopping_mall.coupon.entity.SeckillSkuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动商品关联
 * 
 * @author bob
 * @email none
 * @date 2023-05-17 16:51:40
 */
@Mapper
public interface SeckillSkuRelationDao extends BaseMapper<SeckillSkuRelationEntity> {
	
}
