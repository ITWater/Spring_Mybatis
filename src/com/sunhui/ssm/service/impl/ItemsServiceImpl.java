package com.sunhui.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunhui.ssm.mapper.AdminMapper;
import com.sunhui.ssm.mapper.ItemsMapper;
import com.sunhui.ssm.mapper.ItemsMapperCustom;
import com.sunhui.ssm.pojo.Admin;
import com.sunhui.ssm.pojo.Items;
import com.sunhui.ssm.pojo.ItemsCustom;
import com.sunhui.ssm.pojo.ItemsQueryVo;
import com.sunhui.ssm.service.ItemsService;
/**
 * 
 * <p>Title: ItemsServiceImpl</p>
 * <p>Description: ��Ʒ����</p>
 * <p>Company:www.hailun.online</p>
 * @author sunhui
 * @date 2018��4��19��
 * @version 1.0
 */
@Service
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom ;
	
	@Autowired
	private ItemsMapper itemsMapper ;
	
	@Autowired
	private AdminMapper adminMapper ;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		//ͨ��ItemsMapperCustom��ѯ���ݿ�
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		
		//����Ʒ��Ϣ����ҵ����
		//....
		//����ItemsCustom
		
		ItemsCustom itemsCustom = new ItemsCustom();
		//��Items�����ݿ�������itemsCustom
		BeanUtils.copyProperties(items,itemsCustom);
		
		return itemsCustom;
	}

	@Override
	public void updateItems(int id, ItemsCustom itemsCustom) throws Exception {
		//���ҵ��У�飬ͨ����service�ӿڶԹؼ���������У��
		//У��id�Ƿ�Ϊ�գ����Ϊ�����׳��쳣
		
		
		//������Ʒ��Ϣ ʹ��updateByPrimaryKeyWithBLOBs���Ը���id����items�������е��ֶΣ��������ı��ֶ�
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}

	@Override
	public Admin selectByAdmin(String username,String password) throws Exception {
		return adminMapper.selectByAdmin(username,password);
	}


}
