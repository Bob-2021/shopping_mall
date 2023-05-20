package bob.shopping_mall.member.dao;

import bob.shopping_mall.member.entity.MemberStatisticsInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员统计信息
 * 
 * @author bob
 * @email none
 * @date 2023-05-20 15:56:52
 */
@Mapper
public interface MemberStatisticsInfoDao extends BaseMapper<MemberStatisticsInfoEntity> {
	
}
