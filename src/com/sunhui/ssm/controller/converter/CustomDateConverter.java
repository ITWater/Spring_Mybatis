package com.sunhui.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
* <p>Title: CustomDateConverter</p>  
* <p>Description:自定义参数绑定类 </p>  
* @author sunhui 
* @date 2018年4月26日
 */
public class CustomDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		//ʵ�ֽ����ڴ�ת��Ϊ�������ͣ���ʽ��yyyy-MM-dd HH:mm:ss��
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			//ת��ֱ�ӷ���
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//���������ʧ�ܷ���null
		return null;
	}
	
}
