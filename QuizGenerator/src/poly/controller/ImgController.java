package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.OcrDTO;
import poly.service.IOcrService;
import poly.service.impl.OcrService;

@Controller
public class ImgController {
	private Logger log = Logger.getLogger(this.getClass());
	public static int ccnt = 77;
	public static String value="";
	@Resource(name = "OcrService")
	private IOcrService ocrService;
	
	@RequestMapping(value = "img/img")
	public String getImgCut(HttpServletRequest request, HttpServletResponse response,
			ModelMap model, OcrDTO pDTO) throws Exception {
		
		/*
		 * log.info(this.getClass().getName() + ".getImgCut start!");
		 * if(pDTO.getBase64() != null) { String ba64 = pDTO.getBase64(); String name =
		 * "E:/picture/test" + ccnt; ccnt++; log.info(ba64+"@@@@@@@@@@@@@");
		 * log.info(name+"@@@@@@@@@@@@@"); new OcrService(ba64, name); //OcrDTO rDTO =
		 * new OcrDTO(); value = OcrService.process(name);
		 * 
		 * //rDTO.setBase64(ba64); //rDTO.setNum(name);
		 * 
		 * log.info(value+"원본"); value = value.trim(); log.info(value+"오왼삭제"); value =
		 * value.replaceAll(" ", ""); log.info(value+"교체"); //if(value != null) {
		 * model.addAttribute("value", value); //} else { //model.addAttribute("value",
		 * "영"); //}
		 * log.info((String)request.getAttribute("value")+"###################");
		 * 
		 * } pDTO = null;
		 */
		
		return "/img/img";
		
	}
	@RequestMapping(value = "img/img2")
	@ResponseBody
	public String imgimg(HttpServletRequest request, HttpServletResponse response,
			ModelMap model, OcrDTO pDTO) throws Exception {
		
		log.info(this.getClass().getName() + ".imgimg start!");
		if(pDTO.getBase64() != null) {
			String ba64 = pDTO.getBase64();
			String name = "E:/picture/test" + ccnt;
			ccnt++;
			log.info(ba64+"@@@@@@@@@@@@@");
			log.info(name+"@@@@@@@@@@@@@");
			new OcrService(ba64, name);
			//OcrDTO rDTO = new OcrDTO();
			value = OcrService.process(name);
			
			//rDTO.setBase64(ba64);
			//rDTO.setNum(name);		
			
			log.info(value+"원본");
			value = value.trim();
			log.info(value+"오왼삭제");
			value = value.replaceAll(" ", "");
			log.info(value+"교체");
			//if(value != null) {
					model.addAttribute("value", value);
			//} else {
					//model.addAttribute("value", "영");
			//}
			log.info((String)request.getAttribute("value")+"###################");
			
		}

		log.info(value+"오와우");
		return value;
		
	}
	/*
	 * 
	 * 
	 * @ResponseBody public String simpleWithObject(OcrDTO pDTO) throws Exception {
	 * 
	 * String ba64 = pDTO.getBase64(); String name = "E:/picture/test" + ccnt +
	 * ".jpg"; new OcrService(ba64, name);
	 * 
	 * String result = ((OcrService) ocrService).process(name); log.info(result);
	 * return result; }
	 */
}
