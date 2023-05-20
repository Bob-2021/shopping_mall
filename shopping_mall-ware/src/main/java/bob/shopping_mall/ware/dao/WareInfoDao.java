package bob.shopping_mall.ware.dao;

import bob.shopping_mall.ware.entity.WareInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 * 
 * @author bob
 * @email none
 * @date 2023-05-17 17:37:31
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfoEntity> {
	
}
