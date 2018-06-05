package com.sunhui.ssm.mapper;

import java.util.List;

import com.sunhui.ssm.pojo.ItemsCustom;
import com.sunhui.ssm.pojo.ItemsQueryVo;

public interface ItemsMapperCustom {
	//��Ʒ�Ĳ�ѯ�б�
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception ;
}