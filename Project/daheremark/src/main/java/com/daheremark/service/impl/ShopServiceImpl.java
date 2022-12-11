package com.daheremark.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.daheremark.dto.Result;
import com.daheremark.entity.Shop;
import com.daheremark.mapper.ShopMapper;
import com.daheremark.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.concurrent.TimeUnit;

import static com.daheremark.utils.RedisConstants.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
@Slf4j
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public Result queryById(Long id) {
        String key=CACHE_SHOP_KEY+id;
        //从redis查询商铺缓存
        String shopJson = stringRedisTemplate.opsForValue().get(key);
        //判断是否存在,存在直接返回
        if(StrUtil.isNotBlank(shopJson)){
            Shop shop = JSONUtil.toBean(shopJson, Shop.class);
            return Result.ok(shop);
        }
        //判断命中是否为空值，解决缓存穿透问题
        if(shopJson!=null){
            //返回错误信息
            return Result.ok("记录不存在！");
        }
        //redis不存在，根据id查询数据库
        Shop shop=getById(id);
        //数据库中不存在，将空值写入redis
        if(shop==null){
            stringRedisTemplate.opsForValue().set(key, "",CACHE_NULL_TTL, TimeUnit.MINUTES);
            return Result.ok("记录不存在！");
        }
        //存在，写入redis
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(shop),CACHE_SHOP_TTL, TimeUnit.MINUTES);
        //返回
        return Result.ok(shop);
    }

    @Override
    @Transactional
    public Result update(Shop shop) {
        Long id = shop.getId();
        if(id==null){
            return Result.fail("id不能为空！");
        }
        //更新数据库
        updateById(shop);
        //删除缓存
        stringRedisTemplate.delete(CACHE_SHOP_KEY+id);
        return Result.ok();
    }
}
