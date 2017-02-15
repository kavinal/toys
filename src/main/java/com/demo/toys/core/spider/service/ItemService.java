package com.demo.toys.core.spider.service;

import com.demo.toys.core.spider.domain.ItemDO;

import java.util.List;

/**
 * Created by Kavinal on 2017/2/14.
 */
public interface ItemService {
    Long insertItem(ItemDO item) throws Exception;
    List<ItemDO> queryAllItem() throws Exception;
}
