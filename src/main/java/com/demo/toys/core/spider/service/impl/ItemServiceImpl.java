package com.demo.toys.core.spider.service.impl;

import com.demo.toys.core.spider.domain.ItemDO;
import com.demo.toys.core.spider.dao.ItemMapper;
import com.demo.toys.core.spider.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Kavinal on 2017/2/14.
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemMapper itemMapper;
    public Long insertItem(ItemDO item) throws Exception {
        return itemMapper.insert(item);
    }

    public List<ItemDO> queryAllItem() throws Exception {
        return itemMapper.queryAllItem();
    }
}
