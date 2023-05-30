package bob.shopping_mall.product.service.impl;

import bob.shopping_mall.common.utils.PageUtils;
import bob.shopping_mall.common.utils.Query;
import bob.shopping_mall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import bob.shopping_mall.product.dao.CategoryDao;
import bob.shopping_mall.product.entity.CategoryEntity;
import bob.shopping_mall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> entities = baseMapper.selectList(null);
        List<CategoryEntity> level_1_list = entities.stream().filter(
                categoryEntity -> categoryEntity.getParentCid() == 0
        ).map((menu)->{
                    menu.setChildren(getChildren(menu, entities));
                    return menu;
                }).sorted(
                        Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))
                ).collect(
                        Collectors.toList()
                );
        return level_1_list;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 1、检查当前删除的菜单是否被引用
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        CategoryEntity byId = this.getById(catelogId);
        findPath(catelogId, paths);
        Collections.reverse(paths);
        return paths.toArray(new Long[paths.size()]);
    }

    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());

    }

    private void findPath(Long catelogId, List<Long> paths){
        paths.add(catelogId);
        CategoryEntity byId = this.getById(catelogId);
        if(byId.getParentCid() != 0){
            findPath(byId.getParentCid(), paths);
        }
    }

    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all){
        List<CategoryEntity> children = all.stream().filter(
                categoryEntity -> categoryEntity.getParentCid().equals(root.getCatId())
        ).map(categoryEntity -> {
                    categoryEntity.setChildren(getChildren(categoryEntity, all));
                    return categoryEntity;
                }).sorted(
                    Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))
                ).collect(Collectors.toList());
        return children;
    }


}