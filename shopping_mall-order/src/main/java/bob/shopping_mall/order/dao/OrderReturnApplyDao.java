package bob.shopping_mall.order.dao;

import bob.shopping_mall.order.entity.OrderReturnApplyEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单退货申请
 * 
 * @author bob
 * @email none
 * @date 2023-05-17 17:27:40
 */
@Mapper
public interface OrderReturnApplyDao extends BaseMapper<OrderReturnApplyEntity> {
	
}
