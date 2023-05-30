package bob.shopping_mall.product.dao;

import bob.shopping_mall.product.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 品牌分类关联
 * 
 * @author bob
 * @email none
 * @date 2023-05-14 01:11:05
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {
	void updateCategory(@Param("catId") Long catId, @Param("name") String name);
}
