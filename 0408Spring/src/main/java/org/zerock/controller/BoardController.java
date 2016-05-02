package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/boards")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	@RequestMapping(value="/register" ,method=RequestMethod.GET)
	public void registGET(){
		logger.info("get ���");
	}
	
	@RequestMapping(value="/register" ,method=RequestMethod.POST)
	public String registPOST(BoardVO vo, Model model) throws Exception{
		
		logger.info("post ���");
		
		service.register(vo);
		System.out.println(vo);
		model.addAttribute("result", "list");
		
		
		return "redirect:/boards/listPage";
		
	}
	
	@RequestMapping(value="/list" ,method=RequestMethod.GET)
	public void listGET(Model model) throws Exception{
		logger.info("list ���");
		
		model.addAttribute("list", service.listAll());
	}

	@RequestMapping(value="/readpage" ,method=RequestMethod.GET)
	public void readpage(@RequestParam("bno")Integer bno,@ModelAttribute("cri") Criteria cri,  Model model) throws Exception{
		logger.info("readpage ���");
		
		model.addAttribute(service.selectOne(bno));
	}
	@RequestMapping(value="/remove" ,method=RequestMethod.POST)
	public String remove(@RequestParam("bno")Integer bno,Criteria cri, RedirectAttributes rttr) throws Exception{
		logger.info("����----����Ʈ");
		
		service.delete(bno);
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/boards/listPage";
	}
	@RequestMapping(value="/modify" ,method=RequestMethod.GET)
	public void modify(@RequestParam("bno")int bno, Model model,@ModelAttribute("cri") Criteria cri) throws Exception{
		logger.info("����----rpt");
		
		model.addAttribute(service.selectOne(bno));
	}
	@RequestMapping(value="/modify" ,method=RequestMethod.POST)
	public String modifyPOST(BoardVO vo,Criteria cri, RedirectAttributes rttr) throws Exception{
		logger.info("����----����Ʈ");
		
		service.update(vo);
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addFlashAttribute("msg","success");
		return "redirect:/boards/listPage";
	}
	
	@RequestMapping(value="/listCri" ,method=RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception{
		logger.info("ũ���׸���");
		
		model.addAttribute("list",service.listCriteria(cri));
	}
	
	@RequestMapping(value="/listPage" ,method=RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception{
		logger.info(cri.toString());
		
		model.addAttribute("list",service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(38);
		
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping("/getAttach/{bno}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("bno")Integer bno)throws Exception{
		return service.getAttach(bno);
	}
	

}
