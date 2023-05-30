package bob.shopping_mall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import bob.shopping_mall.coupon.feign.CouponFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bob.shopping_mall.coupon.entity.CouponEntity;
import bob.shopping_mall.coupon.service.CouponService;
import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.common.utils.R;



/**
 * 优惠券信息
 *
 * @author bob
 * @email none
 * @date 2023-05-17 16:51:40
 */
@RestController
@RefreshScope
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;
    @Autowired
    CouponFeignService couponFeignService;

    @Value("${coupon.user.name}")
    String name;
    @Value("${coupon.user.age}")
    Integer age;
    @RequestMapping("f-coupons")
    public R test(){

        R membercoupons = couponFeignService.memberCoupons();
        return R.ok().put("coupons",membercoupons.get("coupons")).put("name", name).put("age",age);
    }

    @RequestMapping("member/list")
    public R memberCoupons(){
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100减10");
        return R.ok().put("coupons", Arrays.asList(couponEntity));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:coupon:info")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:coupon:delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
