package bob.shopping_mall.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.common.utils.Query;

import bob.shopping_mall.coupon.dao.SeckillSkuNoticeDao;
import bob.shopping_mall.coupon.entity.SeckillSkuNoticeEntity;
import bob.shopping_mall.coupon.service.SeckillSkuNoticeService;


@Service("seckillSkuNoticeService")
public class SeckillSkuNoticeServiceImpl extends ServiceImpl<SeckillSkuNoticeDao, SeckillSkuNoticeEntity> implements SeckillSkuNoticeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeckillSkuNoticeEntity> page = this.page(
                new Query<SeckillSkuNoticeEntity>().getPage(params),
                new QueryWrapper<SeckillSkuNoticeEntity>()
        );

        return new PageUtils(page);
    }

}