package bob.shopping_mall.order.dao;

import bob.shopping_mall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author bob
 * @email none
 * @date 2023-05-17 17:27:40
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
