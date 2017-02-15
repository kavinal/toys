package com.demo.toys.core.spider;

import com.demo.toys.core.spider.domain.ItemDO;
import com.demo.toys.core.spider.service.ItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Set;

/**
 * Created by Kavinal on 2017/2/14.
 */
public class App {
    public static void main(String [] args){
        ApplicationContext a = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ItemService itemService = a.getBean(ItemService.class);
        ItemDO item = new ItemDO();
        item.setPostTime(new Date());
        item.setUrl("ttt");
        item.setTitle("laksdjfaksdflka");
        try {
            Spider spider = new Spider();
            Set<ItemDO> itemDOs = spider.praseAllPages("https://bbs.hupu.com/bxj");
            for(ItemDO itemDO : itemDOs){
                Long result = itemService.insertItem(itemDO);
            }
//            itemService.queryAllItem();
            int bbbb = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        int ab = 0;
    }
}
