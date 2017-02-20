package com.demo.toys.core.spider.service.impl;

import com.demo.toys.core.spider.domain.ItemDO;
import com.demo.toys.core.spider.dao.ItemMapper;
import com.demo.toys.core.spider.domain.ItemQTO;
import com.demo.toys.core.spider.service.ItemService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

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

    @Override
    public Long batchInsertItems(Set<ItemDO> itemDOs) throws Exception {
//        return itemMapper.batchInsert(Lists.newArrayList(itemDOs));
        return itemMapper.batchInserts(itemDOs);
    }

    public List<ItemDO> queryAllItem() throws Exception {
        return itemMapper.queryAllItem();
    }

    @Override
    public List<ItemDO> getByItem(ItemQTO itemQTO) throws Exception {
        return itemMapper.getByItem(itemQTO);
    }
}
