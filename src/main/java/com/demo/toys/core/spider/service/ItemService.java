package com.demo.toys.core.spider.service;

import com.demo.toys.core.spider.domain.ItemDO;
import com.demo.toys.core.spider.domain.ItemQTO;

import java.util.List;
import java.util.Set;

/**
 * Created by Kavinal on 2017/2/14.
 */
public interface ItemService {
    Long insertItem(ItemDO item) throws Exception;
    Long batchInsertItems(Set<ItemDO> itemDOs) throws Exception;
    List<ItemDO> queryAllItem() throws Exception;
    List<ItemDO> getByItem(ItemQTO itemQTO) throws Exception;
}
