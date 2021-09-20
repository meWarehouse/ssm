package com.kc.mybatis_1.mvc4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author wen
 * @create 2020-05-18 22:43
 */
@Controller
@RequestMapping("/file")
public class FileController {

	@GetMapping("/uploadUI")
	public String uploadUI() {
		return "upload";
	}

	@PostMapping("/upload")
	public String upload(String name, MultipartFile[] file, Model model) throws IOException {

		System.out.println("name:" + name);
//        System.out.println("原始文件名："+file.getOriginalFilename());
//        file.transferTo(new File("D:\\test\\upload.txt"));//保存文件目录

		for (MultipartFile multipartFile : file) {
			System.out.println("原始文件名：" + multipartFile.getOriginalFilename());
			multipartFile.transferTo(new File("D:\\test\\" + "副本_" + multipartFile.getOriginalFilename()));

		}

		model.addAttribute("msg", "上传成功");

		return "uploadResult";

	}

	@GetMapping("/downloadUI")
	public String downloadUI() {
		return "download";
	}

	@GetMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

		// 设置文件名
		String fileName = "尚硅谷centos6.8下安装mysql.docx";

		String encodFileName = null;
		// 获取用户浏览器
		String agent = request.getHeader("User-Agent");
		System.out.println("获取用户浏览器:" + agent);

		if (agent.contains("MSIE")) {// ie 浏览器
			encodFileName = URLEncoder.encode(fileName, "UTF-8".replace("+", " "));
		} else if (agent.contains("Firefox")) {
			encodFileName = "=?utf-8?B?" + new sun.misc.BASE64Encoder().encode(fileName.getBytes("utf-8")) + "?=";
		} else {
			encodFileName = URLEncoder.encode(fileName, "UTF-8");
		}

		// 设置相应头
		response.setHeader("content-Disposition", "attachement;filename=" + encodFileName);
		// 设置响应内容类型
		response.setContentType(request.getServletContext().getMimeType(fileName));

		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream(new File("D:\\test\\" + fileName));
			os = response.getOutputStream();

			byte[] bs = new byte[1024];
			int len = -1;

			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
				os.flush();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
