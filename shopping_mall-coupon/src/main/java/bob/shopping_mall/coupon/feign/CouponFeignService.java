package bob.shopping_mall.coupon.feign;

import bob.shopping_mall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ***
 * 2023-05-20 15:59
 */
@FeignClient(name = "shoppingmall-coupon")
public interface CouponFeignService {
    @RequestMapping("/coupon/coupon/member/list")
    R memberCoupons();
}
