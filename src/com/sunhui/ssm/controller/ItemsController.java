package com.sunhui.ssm.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sunhui.ssm.pojo.ItemsCustom;
import com.sunhui.ssm.pojo.ItemsQueryVo;
import com.sunhui.ssm.service.ItemsService;

/**
 * 
 * <p>Title: ItemsController</p>
 * <p>Description:商品的controller </p>
 * <p>Company:www.hailun.online</p>
 * @author sunhui
 * @date 2018年4月19日
 * @version 1.0
 */
@Controller
//为了对url进行分类管理，可以在这里定义根路径，最终访问的url是：根路径+子路径(窄化请求映射)
@RequestMapping("/items" )
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService ;
	
	//商品查询 （子路径）
	@RequestMapping("/queryItems")
	//在形参中让包装类型的pojo接收查询条件参数
	//页面传参的特点：复杂，多样性 因此如果使用简单的pojo比较麻烦、乱
	//pojo数据传入controller方法后，SpringMVC自动将pojo数据放到Request域，key等于pojo类型（首字母小写）
	public ModelAndView  queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
		
		//List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		
		//返回ModelAndView
		ModelAndView mav = new ModelAndView();
		//相当于requeset的setAttribute，在jsp页面中通过itemsList取数据。
		mav.addObject("itemsList",itemsList);
		
		//指定视图
		//下面的路径配置需要指定jsp路径的前缀和jsp路径的后缀
		//mav.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		//上面的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		mav.setViewName("items/itemsList");
		
		return mav;
	}
	
	//商品信息修改页面显示
	//@RequestMapping("/editItems")
	//限制http请求方式，可以post也可以get
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	//public ModelAndView editItems(Integer id)
	//request传入的参数名和controller方法的形参名保持一致
	//使用@RequestParam(value="") 则可以将Request传入的参数和形参进行绑定
	//@RequestParam中的required属性指定参数是否必须要传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参进行绑定
	public ModelAndView editItems(HttpServletRequest request,@RequestParam(value="id",required=true) Integer id,ItemsCustom itemsCustom) throws Exception{
		
		itemsCustom = itemsService.findItemsById(id);
		
		//返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("itemsCustom",itemsCustom);
		
		modelAndView.setViewName("items/editItems");
		
		return modelAndView ;
		
	}
	
	//商品信息的提交
	@RequestMapping("/editItemsSubmit")
	//pojo绑定：页面中的input中的name和controller的pojo形参中的属性名称一致，将页面中数据绑定到pojo
	//在需要校验的pojo前面添加@Validated，在需要校验的pojo后边添加BindingResult bindingResult接校验的错误信息
	//注意：@Validated和BindingResult是成对出现的 位置固定（一前一后）
	public String editItemsSubmit(
			Model model,
			HttpServletRequest request,
			Integer id,
			@Validated ItemsCustom itemsCustom,
			BindingResult bindingResult,
			//接收商品图片
			MultipartFile items_pic 
			) throws Exception{

		//获取校验错误信息
		if(bindingResult.hasErrors()) {
			//输出错误信息
			List <ObjectError> allErrors = bindingResult.getAllErrors();
			
			for(ObjectError objectError:allErrors) {
				//输出错误信息
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("allErrors",allErrors);
			
			//重新到商品修改页面
			
			return "items/editItems" ;
			
		}
		
		//原始名称
		String originalFilename = items_pic.getOriginalFilename();
		
		//上传图片
		if(items_pic!=null && originalFilename!=null && originalFilename.length()>0) {
			//存储图片的物理路径
			String pic_path = "F:\\Tomcat_upload\\temp\\";
			
			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			
			File newFile = new File(pic_path+newFileName);
			
			//将内存中的数据写入磁盘
			items_pic.transferTo(newFile);
			
			//将新的图片名称写到itemsCustom中
			itemsCustom.setPic(newFileName);
		}
		
		//调用service更新商品信息，页面要将商品信息传到此方法
		itemsService.updateItems(id, itemsCustom);
		
		//返回一个成功页面
		return "success";
		
	}
}
