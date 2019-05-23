package com.miaoshaproject.service.impl;

import com.miaoshaproject.dao.PromoDOMapper;
import com.miaoshaproject.dataobject.PromoDO;
import com.miaoshaproject.service.PromoService;
import com.miaoshaproject.service.model.PromoModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class PromoServiceImpl implements PromoService {

    @Resource
    private PromoDOMapper promoDOMapper;

    @Override
    public PromoModel getPromoByItemId(Integer itemId) {
        //获取对应商品的活动信息
        PromoDO promoDO = promoDOMapper.selecByItemId(itemId);

        //dataobject->model
        PromoModel promoModel = converFromDataObject(promoDO);

        //判断当前时间是否秒杀活动即将开始或正在进行

        return null;
    }

    private PromoModel converFromDataObject(PromoDO promoDO){
        if (promoDO == null) {
            return null;
        }
        PromoModel promoModel = new PromoModel();
        BeanUtils.copyProperties(promoDO,promoModel);
        promoModel.setPromoItemPrice(new BigDecimal((promoDO.getPromoItemPrice())));
        promoModel.setStartDate(new DateTime((promoDO.getStartDate())));
        promoModel.setEndDate(new DateTime((promoDO.getEndDate())));
        return promoModel;
    }
}
