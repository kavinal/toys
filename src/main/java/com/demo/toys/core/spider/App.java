package com.demo.toys.core.spider;

import com.demo.toys.core.spider.domain.ItemDO;
import com.demo.toys.core.spider.domain.ItemQTO;
import com.demo.toys.core.spider.service.ItemService;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Kavinal on 2017/2/14.
 */
public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main(String [] args){
        ApplicationContext a = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ItemService itemService = a.getBean(ItemService.class);
        ItemDO item = new ItemDO();
        item.setPostTime(new Date());
        item.setUrl("3333");
        item.setTitle("33333");
        Set<ItemDO> set = Sets.newHashSet();
        set.add(item);
//        item.setUrl("4444");
//        item.setTitle("44444");
//        set.add(item);
        try {
//            Spider spider = new Spider();
//            Set<ItemDO> itemDOs = spider.praseAllPages("https://bbs.hupu.com/bxj");
//            for(ItemDO itemDO : itemDOs){
//                Long result = itemService.insertItem(itemDO);
//            }
            itemService.batchInsertItems(set);
            ItemQTO query = new ItemQTO();
            query.setTitle("44444");
            List<ItemDO> itemDOs = itemService.getByItem(query);
            log.info("itemDOs:{}",itemDOs);
//            itemService.queryAllItem();
            int bbbb = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        int ab = 0;
    }
}
