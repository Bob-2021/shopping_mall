package bob.shopping_mall.member.dao;

import bob.shopping_mall.member.entity.MemberReceiveAddressEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员收货地址
 * 
 * @author bob
 * @email none
 * @date 2023-05-20 15:56:52
 */
@Mapper
public interface MemberReceiveAddressDao extends BaseMapper<MemberReceiveAddressEntity> {
	
}
