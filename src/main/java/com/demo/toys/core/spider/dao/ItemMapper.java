package com.demo.toys.core.spider.dao;

import com.demo.toys.core.spider.domain.ItemDO;
import com.demo.toys.core.spider.domain.ItemQTO;

import java.util.List;
import java.util.Set;

/**
 * Created by Kavinal on 2017/2/14.
 */
public interface ItemMapper {
    Long insert(ItemDO item) throws Exception;
    Long batchInsert(List<ItemDO> itemDOs) throws Exception;
    Long batchInserts(Set<ItemDO> itemDOs) throws Exception;
    List<ItemDO> queryAllItem() throws Exception;
    List<ItemDO> queryByItem(ItemQTO itemQTO) throws Exception;
    List<ItemDO> getByItem(ItemQTO itemQTO) throws Exception;
}
