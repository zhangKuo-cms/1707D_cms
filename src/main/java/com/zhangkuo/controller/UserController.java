package com.zhangkuo.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zhangkuo.common.CmsAssert;
import com.zhangkuo.common.ConstantClass;
import com.zhangkuo.common.MsgResult;
import com.zhangkuo.entity.Article;
import com.zhangkuo.entity.Channel;
import com.zhangkuo.entity.User;
import com.zhangkuo.service.ArticleService;
import com.zhangkuo.service.ChannelService;
import com.zhangkuo.service.UserService;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月12日 下午1:26:47 

*/
@Controller
@RequestMapping("user")
public class UserController {
	
	Logger logger = Logger.getLogger(UserController.class);
	
	@Value("${upload.path}")
	String updloadPath;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	ChannelService channelService;
	
	private SimpleDateFormat dateFormat;
	
	@RequestMapping(value = "hello",method = RequestMethod.GET)
	public String tet(HttpServletRequest request) {
		request.setAttribute("info", "hello");
		return "user/test";
	}
	
	/**
	 * 跳转到注册页面 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "register",method = RequestMethod.GET)
	public String register(HttpServletRequest request) {
		return "user/register";
	}
	
	/**
	 * 处理用户提交的注册的数据
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "register",method = RequestMethod.POST)
	public String register(HttpServletRequest request,User user) {
		int result = userService.register(user);
		CmsAssert.AssertTure(result>0, "用户注册失败，请稍后重试");
		
		return "redirect:/user/login";
	}
	
	/**
	 * 跳转到登录页面 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(HttpServletRequest request) {
		return "user/login";
	}
	
	/**
	 * 处理用户提交的登录的数据
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,User user) {
		
		
		User loginUser  = userService.login(user);
		// 用户存在 登录成功
		if(loginUser!=null) {
			request.getSession().setAttribute(ConstantClass.USER_KEY, loginUser);
			
			//return "redirect:/";
			return loginUser.getRole()==ConstantClass.USER_ROLE_ADMIN
					?"redirect:/admin/index":"redirect:/user/home";
		}else {
			request.setAttribute("errorMsg", "用户名或密码错误！！");
			request.setAttribute("user", user);
			return "user/login";
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(ConstantClass.USER_KEY);
		return "redirect:/";
	}
	
	@RequestMapping("checkname")
	@ResponseBody
	public boolean checkname(String username) {
		return null==userService.findByName(username);
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("home")
	public String home(HttpServletRequest request) {
		return "/user/home";
	}
	
	@GetMapping("updateArticle")
	public String updateArticle(HttpServletRequest request, int id) {
		Article article = articleService.getDetailById(id);
		request.setAttribute("article", article);
		request.setAttribute("", htmlspecialchars(article.getContent()));
		
		System.out.println("将要修改文章"+article);
		
		//获取所有的频道
		List<Channel> channels = channelService.list();
		request.setAttribute("channels", channels);
		
		return "article/update";
	}
	
	@RequestMapping("updateArticle")
	@ResponseBody
	public MsgResult updateArticle(HttpServletRequest request,
			MultipartFile file,Article article) throws IllegalStateException, IOException {
		//文章id 是否存在
		
		//用户是否有权限修改
		
		if (!file.isEmpty()) {
			String picUrl =  processFile(file);
			article.setPicture(picUrl);
		}
		
		int result = articleService.update(article);
		
		if (result>0) {
			return new MsgResult(1,"",null);
		}else {
			return new MsgResult(2,"失败",null);
		}
	}
	/**
	 * 进入发表文章的界面
	 * @param request
	 * @return
	 */
	@GetMapping("postArticle")
	public String postArticle(HttpServletRequest request) {
		//获取所有频道
		List<Channel> channels = channelService.list();
		request.setAttribute("channels", channels);
		return "article/publish";
	}
	
	/**
	 * 上传文件的规则
	 *  文件扩展名不能改变
	 *  保存到某个路径下边  要求子目录
	 *  子目录  每天一个子目录
	 */
	
	/**
	 * 
	 * @param file
	 * @param article
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping("postArticle")
	@ResponseBody
	public MsgResult postArticle(HttpServletRequest request,
			MultipartFile file,Article article) throws IllegalStateException, IOException {
		if (!file.isEmpty()) {
			String fileUrl = processFile(file);
			article.setPicture(fileUrl);
		}
		User loginUser = (User) request.getSession().getAttribute(ConstantClass.USER_KEY);
		article.setUserId(loginUser.getId());
		
		int result = articleService.add(article);
		if (result>0) {
			return new MsgResult(1,"处理成功",null);
		}else {
			return new MsgResult(2, "添加失败,请稍后重试", null);
		}
	}
	
	/**
	 * 
	 * @param file
	 * @return  保存文件的相对路径
	 * @throws IllegalStateException
	 * @throws IOException
	 */
    private String processFile(MultipartFile file) throws IllegalStateException, IOException {
    	
    	//1 求扩展名  "xxx.jpg"
    	String suffixName =  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
    	String fileNamePre = UUID.randomUUID().toString();
    	// 计算出新的文件名称
    	String fileName = fileNamePre + suffixName;
    	
    	dateFormat = new SimpleDateFormat("yyyyMMdd");
    	String path = dateFormat.format(new Date());
    	File pathFile  = new File("d:/pic/" + path);
    	if(!pathFile.exists()) {
    		pathFile.mkdirs();
    	}
    	
    	// 最终的新的文件名称
    	String newFileName = "d:/pic/"+ path + "/" + fileName;
    	file.transferTo(new File(newFileName));
    	
    	return path + "/" + fileName ;
    }
    
    /**
	 * 获取文章列表
	 * @return
	 */
    @RequestMapping("myarticles")
    public String myarticles(HttpServletRequest request,
    		@RequestParam(defaultValue = "1")int page) {
    	User loginUser = (User) request.getSession().getAttribute(ConstantClass.USER_KEY);
    	
    	PageInfo<Article> pageInfo = articleService.listByUser(page,loginUser.getId());
    	request.setAttribute("pageInfo", pageInfo);
    	return "user/myarticles";
    }
    
    /**
     * 删除文章
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("delArticle")
    @ResponseBody
    public MsgResult delArticle(HttpServletRequest request,int id) {
    	CmsAssert.AssertTure(id>0, "文章id必须大于0");
    	Article article = articleService.checkExist(id);
    	CmsAssert.AssertTure(article!=null, "该文章不存在");
    	
    	User loginUser = (User) request.getSession().getAttribute(ConstantClass.USER_KEY);
    	CmsAssert.AssertTure(
    			loginUser.getRole()==ConstantClass.USER_ROLE_ADMIN
    			|| loginUser.getId()==article.getUserId(),
    			"只有管理员和文章作者能删除文章");
    	int result = articleService.delete(id);
    	CmsAssert.AssertTure(result>0, "文章删除失败");
    	return new MsgResult(1,"删除成功",null);
    }
    private String htmlspecialchars(String str) {
    	str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
}
