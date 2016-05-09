package org.zerock.com;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ChildVO;
import org.zerock.service.ChildService;


@Controller
@RequestMapping("/child/*")
public class ChildController {

	private static final Logger logger = LoggerFactory.getLogger(ChildController.class);
	
	@Inject
	private ChildService service;
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public void registerGET(ChildVO child, Model model)throws Exception{
		
		logger.info("register Page....GET");
		
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String registerPOST(ChildVO child,RedirectAttributes rttr)throws Exception{
		logger.info("register Page....POST!!");
		logger.info(child.toString());
		
		service.regist(child);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/child/listAll";
		
	}
	
	@RequestMapping(value="/listAll",method =RequestMethod.GET)
	public void listAll(Model model)throws Exception{
		logger.info("show all list...");
		
		model.addAttribute("list", service.listAll());
	}
	
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void read(@RequestParam("cno") int cno,Model model)throws Exception{
		model.addAttribute(service.read(cno));
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("cno")int cno, RedirectAttributes rttr)throws Exception{
		
		service.remove(cno);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/child/listAll";
	}
	
	@RequestMapping(value ="/modify",method = RequestMethod.GET)
	public void modifyGET(int cno, Model model)throws Exception{
		
		model.addAttribute(service.read(cno));
	}
	@RequestMapping(value ="/modify",method = RequestMethod.POST)
	public String modifyPOST(ChildVO child, RedirectAttributes rttr)throws Exception{
		
		logger.info("mod post......");
		
		service.modify(child);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/child/listAll";
	}
	
	
}
