package bob.shopping_mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import bob.shopping_mall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import bob.shopping_mall.product.entity.AttrEntity;
import bob.shopping_mall.product.service.AttrService;
import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.common.utils.R;




/**
 * 商品属性
 *
 * @author bob
 * @email none
 *      @date 2023-05-14 01:11:05
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
		AttrEntity attr = attrService.getById(attrId);

        return R.ok().put("attr", attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrEntity attr){
		attrService.updateById(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }
    @GetMapping("/base/list/{catelogId}")
    public R baseAttrList(
            @RequestParam Map<String, Object> params,
            @PathVariable("catelogId") Long catelogId
    ){
        PageUtils page = attrService.queryBaseAttrPage(params, catelogId);
        return R.ok().put("page", page);
    }

}
