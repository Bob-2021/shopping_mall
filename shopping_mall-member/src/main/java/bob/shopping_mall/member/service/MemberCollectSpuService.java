package bob.shopping_mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.member.entity.MemberCollectSpuEntity;

import java.util.Map;

/**
 * 会员收藏的商品
 *
 * @author bob
 * @email none
 * @date 2023-05-20 15:56:52
 */
public interface MemberCollectSpuService extends IService<MemberCollectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

