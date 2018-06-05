package com.sunhui.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunhui.ssm.pojo.Admin;
import com.sunhui.ssm.pojo.ItemsCustom;
import com.sunhui.ssm.pojo.ItemsQueryVo;


public interface ItemsService {
	//��Ʒ�Ĳ�ѯ�б�
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

	//����id��ѯ��Ʒ��Ϣ
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	/**
	 * 
	 * @param id �޸���Ʒ��id
	 * @param itemsCustom Ҫ�޸ĵ���Ʒ����Ϣ
	 * @throws Exception
	 */
	//�޸���Ʒ��Ϣ
	public void updateItems(int id,ItemsCustom itemsCustom) throws Exception;
	
	public Admin selectByAdmin(String username, String password) throws Exception ;
}
