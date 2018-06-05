package com.sunhui.ssm.pojo;

/**
 * 
 * <p>Title: ItemsQueryVo</p>
 * <p>Description: ��Ʒ��װ����</p>
 * <p>Company:www.hailun.online</p>
 * @author sunhui
 * @date 2018��4��19��
 * @version 1.0
 */
public class ItemsQueryVo {

	private Items items ;
	
	//Ϊ��ϵͳ�Ŀ���չ�ԣ���ԭ����pojo������չ
	private ItemsCustom itemsCustom;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	
	
}
