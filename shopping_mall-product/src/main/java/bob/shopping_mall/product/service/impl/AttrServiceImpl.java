package bob.shopping_mall.product.service.impl;

import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.common.utils.Query;
import bob.shopping_mall.product.dao.AttrAttrgroupRelationDao;
import bob.shopping_mall.product.dao.AttrGroupDao;
import bob.shopping_mall.product.dao.CategoryDao;
import bob.shopping_mall.product.entity.AttrAttrgroupRelationEntity;
import bob.shopping_mall.product.entity.AttrGroupEntity;
import bob.shopping_mall.product.entity.CategoryEntity;
import bob.shopping_mall.product.vo.AttrRespVo;
import bob.shopping_mall.product.vo.AttrVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import bob.shopping_mall.product.dao.AttrDao;
import bob.shopping_mall.product.entity.AttrEntity;
import bob.shopping_mall.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {
    @Resource
    AttrAttrgroupRelationDao relationDao;
    @Resource
    AttrGroupDao attrGroupDao;
    @Resource
    CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }
    @Transactional
    @Override
    public void saveAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr, attrEntity);
        this.save(attrEntity);
        AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
        relationEntity.setAttrGroupId(attr.getAttrGroupId());
        relationEntity.setAttrId(attrEntity.getAttrId());
        relationDao.insert(relationEntity);

    }

    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<>();
        if(catelogId != 0){
            queryWrapper.eq("catelog_id", catelogId);
        }
        String key = (String)params.get("key");
        if(!StringUtils.isEmpty(key)){
            queryWrapper.and((wrapper)->{
                wrapper.eq("attr_id", key).or().like("attr_name", key);
            });
        }
        IPage<AttrEntity> page = this.page(
          new Query<AttrEntity>().getPage(params),
          queryWrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        List<AttrEntity> records = page.getRecords();
        List<AttrRespVo> respVos =  records.stream().map((attrEntity -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(attrEntity, attrRespVo);
            AttrAttrgroupRelationEntity attrId = relationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attrEntity.getAttrId()));
            if(attrId != null){
                AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrId.getAttrGroupId());
                attrGroupDao.selectById(attrId.getAttrGroupId());
                attrRespVo.setCatelogName(attrGroupEntity.getAttrGroupName());
            }
            CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCatelogId());
            if(categoryEntity != null){
                attrRespVo.setCatelogName(categoryEntity.getName());
            }
            return attrRespVo;
        })).collect(Collectors.toList());
        pageUtils.setList(respVos);
        return pageUtils;
    }
}