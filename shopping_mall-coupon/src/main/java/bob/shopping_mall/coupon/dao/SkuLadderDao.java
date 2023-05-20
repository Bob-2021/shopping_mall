package bob.shopping_mall.coupon.dao;

import bob.shopping_mall.coupon.entity.SkuLadderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品阶梯价格
 * 
 * @author bob
 * @email none
 * @date 2023-05-17 16:51:40
 */
@Mapper
public interface SkuLadderDao extends BaseMapper<SkuLadderEntity> {
	
}
