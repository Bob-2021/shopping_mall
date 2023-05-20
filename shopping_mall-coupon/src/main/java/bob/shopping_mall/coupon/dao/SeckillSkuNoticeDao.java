package bob.shopping_mall.coupon.dao;

import bob.shopping_mall.coupon.entity.SeckillSkuNoticeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀商品通知订阅
 * 
 * @author bob
 * @email none
 * @date 2023-05-17 16:51:40
 */
@Mapper
public interface SeckillSkuNoticeDao extends BaseMapper<SeckillSkuNoticeEntity> {
	
}
