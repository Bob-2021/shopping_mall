package bob.shopping_mall.product.dao;

import bob.shopping_mall.product.entity.BrandEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌
 * 
 * @author bob
 * @email none
 * @date 2023-05-14 01:11:05
 */
@Mapper
public interface BrandDao extends BaseMapper<BrandEntity> {
	
}
