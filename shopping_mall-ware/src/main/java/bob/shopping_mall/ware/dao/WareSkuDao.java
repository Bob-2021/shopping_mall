package bob.shopping_mall.ware.dao;

import bob.shopping_mall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author bob
 * @email none
 * @date 2023-05-17 17:37:31
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
