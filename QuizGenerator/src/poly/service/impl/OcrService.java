package poly.service.impl;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import poly.dto.OcrDTO;
import poly.persistance.mapper.IOcrMapper;
import poly.service.IOcrService;

@Service("OcrService")
public class OcrService implements IOcrService {

	@Resource(name = "OcrMapper")
	private IOcrMapper ocrMapper;

	public static OcrService ocrService;
	String ocrba64;
	String ocrname;

	// 로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * 이미지 파일로부터 문자 읽어 오기
	 * 
	 * @param pDTO 이미지 파일 정보
	 * @return pDTO 이미지로부터 읽은 문자열
	 */
	/*
	 * @Override public OcrDTO getReadforImageText(OcrDTO pDTO) throws Exception {
	 * 
	 * log.info(this.getClass().getName() + ".getReadforImageText start!");
	 * 
	 * File imageFile = new File(CmmUtil.nvl(pDTO.getFilePath()) + "//" +
	 * CmmUtil.nvl(pDTO.getFileName())); //File imageFile = new File(
	 * "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"
	 * ); //File imageFile = new
	 * File("blob:http://127.0.0.1:5500/0077811c-328f-471a-82cd-98f6bded1155");
	 * 
	 * log.info(imageFile); // OCR 기술 사용을 위한 Tesseract 플랫폼 객체 생성 ITesseract instance
	 * = new Tesseract();
	 * 
	 * // OCR 분석에 필요한 기준 데이터(이미 각 나라의 언어별로 학습시킨 데이터 위치 폴더) // 저장 경로는 물리경로를 사용함(전체
	 * 경로) instance.setDatapath("E:\\ocrdata");
	 * 
	 * // 한국어 학습 데이터 선택(기본 값은 영어) instance.setLanguage("kor"); // 한국어 설정 //
	 * instance.setLanguage("eng"); // 영어 설정
	 * 
	 * // 이미지 파일로부터 텍스트 읽기 String result = instance.doOCR(imageFile); //String
	 * result = instance.doOCR(
	 * "data:image/jpeg;base64,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"
	 * );
	 * 
	 * 
	 * // 읽은 글자를 DTO에 저장하기 pDTO.setTextFromImage(result);
	 * 
	 * log.info("S- saveFileName : " + pDTO.getFileName());
	 * log.info("S- saveFilePath : " + pDTO.getFilePath());
	 * log.info("S- originalFileName : " + pDTO.getOrg_file_name());
	 * log.info("S- ext : " + pDTO.getExt());
	 * 
	 * ocrMapper.InsertOcrInfo(pDTO);
	 * 
	 * log.info("result : " + result);
	 * 
	 * log.info(this.getClass().getName() + ".getReadforImageText end!");
	 * 
	 * return pDTO; }
	 */
	public OcrService() throws Exception {

	}

	public OcrService(String ba64, String name) throws Exception {

		log.info(this.getClass().getName() + ".OcrService 시작!!!");
		String base64 = ba64 + "'";
		if (aOCR(base64, name + ".jpg", name + ".png"))
			System.out.println("성공");
		else
			System.out.println("실패");
		log.info(this.getClass().getName() + ".OcrService 끝!!!");
	}

	public static boolean aOCR(String base64, String target1, String target2) {

		// log.info(this.getClass().getName() + ".aOCR 시작!!!");

		int start = base64.indexOf(",");
		String str = base64.substring(start + 1, base64.length());
		int end = str.indexOf("'");
		String result = str.substring(0, end);
		byte[] imageBytes = DatatypeConverter.parseBase64Binary(result);

		try {
			BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imageBytes));

			ImageIO.write(bufImg, "jpg", new File(target1));
//			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
//			bufImg = resize(bufImg, (int) (bufImg.getWidth() * (60 / (double) bufImg.getHeight())), 60);

//			ImageIO.write(bufImg, "png", new File(target2));
			// log.info(this.getClass().getName() + ".aOCR 끝!!!");
			return true;
		} catch (IOException e) {
			// log.info(this.getClass().getName() + ".aOCR 에러!!!");
			return false;
		}
	}

	public String process(String fileName, boolean lang) throws Exception {

		log.info(this.getClass().getName() + ".process 시작!!!");
		// File imageFile = new File(CmmUtil.nvl(pDTO.getFilePath()) + "//" +
		// CmmUtil.nvl(pDTO.getFileName()));
		File inputFile = new File(fileName + ".jpg");
		// File imageFile = new
		// File("blob:http://127.0.0.1:5500/0077811c-328f-471a-82cd-98f6bded1155");

		// OCR 기술 사용을 위한 Tesseract 플랫폼 객체 생성
		ITesseract instance = new Tesseract();

		instance.setTessVariable("user_defined_dpi", "300");
		// OCR 분석에 필요한 기준 데이터(이미 각 나라의 언어별로 학습시킨 데이터 위치 폴더)
		// 저장 경로는 물리경로를 사용함(전체 경로)
		instance.setDatapath("E:\\ocrdata");

		// 한국어 학습 데이터 선택(기본 값은 영어)
		if (lang == true)
			instance.setLanguage("kor"); // 한국어 설정
		else
			instance.setLanguage("eng"); // 영어 설정

		// 이미지 파일로부터 텍스트 읽기
		String result = instance.doOCR(inputFile);

		/*
		 * String fileName2 = fileName + ".txt"; try{
		 * 
		 * // 파일 객체 생성 File file = new File(fileName2) ;
		 * 
		 * // true 지정시 파일의 기존 내용에 이어서 작성 FileWriter fw = new FileWriter(file, false) ;
		 * result = result.trim(); result = result.replaceAll(" ", ""); // 파일안에 문자열 쓰기
		 * fw.write(result); fw.flush(); }catch(Exception e){ e.printStackTrace(); }
		 */
		log.info(this.getClass().getName() + ".process 끝!!!");

		return result;
	}

	@Override
	public OcrDTO getReadforImageText(OcrDTO pDTO) throws Exception {
		return null;
	}
	/*
	 * public BufferedImage scaleImage(BufferedImage img, int width, int height,
	 * Color background) { log.info(this.getClass().getName() +
	 * ".scaleImage 시작!!!");
	 * 
	 * int imgWidth = img.getWidth(); int imgHeight = img.getHeight(); if
	 * (imgWidth*height < imgHeight*width) { width = imgWidth*height/imgHeight; }
	 * else { height = imgHeight*width/imgWidth; } BufferedImage newImage = new
	 * BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); Graphics2D g =
	 * newImage.createGraphics(); try {
	 * g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	 * RenderingHints.VALUE_INTERPOLATION_BICUBIC); g.setBackground(background);
	 * g.clearRect(0, 0, width, height); g.drawImage(img, 0, 0, width, height,
	 * null); } finally { g.dispose(); } log.info(this.getClass().getName() +
	 * ".scaleImage 끝!!!"); return newImage; }
	 * 
	 * //Resize public static BufferedImage resize(BufferedImage img, int newWidth,
	 * int newHeight) {
	 * 
	 * BufferedImage copy = img;
	 * 
	 * double nWidthFactor = (double) img.getWidth() / (double) newWidth; double
	 * nHeightFactor = (double) img.getHeight() / (double) newHeight;
	 * 
	 * double fx, fy, nx, ny; int cx, cy, fr_x, fr_y; Color colour1; Color colour2;
	 * Color colour3; Color colour4; byte nRed, nGreen, nBlue;
	 * 
	 * byte bp1, bp2;
	 * 
	 * int cnt = 0;
	 * 
	 * for (int x = 0; x < copy.getWidth(); ++x) { for (int y = 0; y <
	 * copy.getHeight(); ++y) {
	 * 
	 * cnt++; System.out.println(cnt+"cnt!!!!!!!!!!!!!!!!!!!!!!!!"); fr_x = (int)
	 * Math.floor(x * nWidthFactor); fr_y = (int) Math.floor(y * nHeightFactor); cx
	 * = fr_x + 1; if (cx >= img.getWidth()) cx = fr_x; cy = fr_y + 1; if (cy >=
	 * img.getHeight()) cy = fr_y; fx = x * nWidthFactor - fr_x; fy = y *
	 * nHeightFactor - fr_y; nx = 1.0 - fx; ny = 1.0 - fy;
	 * 
	 * 
	 * colour1 = new Color(img.getRGB(fr_x, fr_y)); colour2 = new
	 * Color(img.getRGB(cx, fr_y)); colour3 = new Color(img.getRGB(fr_x, cy));
	 * colour4 = new Color(img.getRGB(cx, cy));
	 * 
	 * color1 = img.getPixel(fr_x, fr_y); color2 = img.getPixel(cx, fr_y); color3 =
	 * img.getPixel(fr_x, cy); color4 = img.getPixel(cx, cy);
	 * 
	 * 
	 * // Blue bp1 = (byte) (nx * colour1.getBlue() + fx * colour2.getBlue()); bp2 =
	 * (byte) (nx * colour3.getBlue() + fx * colour4.getBlue()); nBlue = (byte) (ny
	 * * (double) (bp1) + fy * (double) (bp2)); System.out.println(nBlue); // Green
	 * bp1 = (byte) (nx * colour1.getGreen() + fx * colour2.getGreen()); bp2 =
	 * (byte) (nx * colour3.getGreen() + fx * colour4.getGreen()); nGreen = (byte)
	 * (ny * (double) (bp1) + fy * (double) (bp2)); System.out.println(nGreen); //
	 * Red bp1 = (byte) (nx * colour1.getRed() + fx * colour2.getRed()); bp2 =
	 * (byte) (nx * colour3.getRed() + fx *colour4.getRed()); nRed = (byte) (ny *
	 * (double) (bp1) + fy * (double) (bp2)); System.out.println(nRed);
	 * copy.setRGB(x, y, new Color((int)nRed, (int)nGreen, (int)nBlue).getRGB()); }
	 * }
	 * 
	 * copy = setGrayscale(copy); copy = removeNoise(copy);
	 * 
	 * 
	 * return copy; }
	 * 
	 * 
	 * // SetGrayscale private static BufferedImage setGrayscale(BufferedImage img)
	 * {
	 * 
	 * for(int y = 0; y < img.getHeight(); y++) { for(int x = 0; x < img.getWidth();
	 * x++) { Color colour = new Color(img.getRGB(x, y)); // Choose one from below
	 * // int Y = (int) (0.299 * colour.getRed() + 0.587 * colour.getGreen() + 0.114
	 * * colour.getBlue()); int Y = (int) (0.2126 * colour.getRed() + 0.7152 *
	 * colour.getGreen() + 0.0722 * colour.getBlue()); img.setRGB(x, y, new Color(Y,
	 * Y, Y).getRGB()); } }
	 * 
	 * return img; }
	 * 
	 * // RemoveNoise private static BufferedImage removeNoise(BufferedImage img) {
	 * 
	 * 
	 * for (int x = 0; x < img.getWidth(); x++) { for (int y = 0; y <
	 * img.getHeight(); y++) { Color colour = new Color(img.getRGB(x, y)); if
	 * (colour.getRed() < 162 && colour.getGreen() < 162 && colour.getBlue() < 162)
	 * { img.setRGB(x, y, new Color(0, 0, 0).getRGB()); } } } for (int x = 0; x <
	 * img.getWidth(); x++) { for (int y = 0; y < img.getHeight(); y++) { Color
	 * colour = new Color(img.getRGB(x, y)); if (colour.getRed() > 162 &&
	 * colour.getGreen() > 162 && colour.getBlue() > 162) { img.setRGB(x, y, new
	 * Color(255, 255, 255).getRGB()); } } }
	 * 
	 * return img; }
	 */
}
