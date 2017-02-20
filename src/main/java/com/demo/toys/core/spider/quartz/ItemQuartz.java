package com.demo.toys.core.spider.quartz;

import com.demo.toys.core.spider.Spider;
import com.demo.toys.core.spider.domain.ItemDO;
import com.demo.toys.core.spider.domain.ItemQTO;
import com.demo.toys.core.spider.service.ItemService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

/**
 * Created by Kavinal on 2017/2/15.
 */
public class ItemQuartz extends QuartzJobBean {
    @Resource
    private ItemService itemService;
    @Resource
    private Spider spider;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            Set<ItemDO> itemDOs = spider.praseAllPages("https://bbs.hupu.com/bxj");
            if(!CollectionUtils.isEmpty(itemDOs)){
                for(ItemDO itemDO : itemDOs){
                    ItemQTO query = new ItemQTO();
                    BeanUtils.copyProperties(itemDO,query);
                    List<ItemDO> itemDOList = itemService.getByItem(query);
                    if(CollectionUtils.isEmpty(itemDOList))
                        itemService.insertItem(itemDO);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
