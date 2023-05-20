package bob.shopping_mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author bob
 * @email none
 * @date 2023-05-20 15:56:52
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

