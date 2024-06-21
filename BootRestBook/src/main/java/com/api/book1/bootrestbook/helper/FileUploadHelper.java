package com.api.book1.bootrestbook.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadHelper {
	
	//public final String UPLOAD_DIR = "C:\\Users\\win 10\\Documents\\springcourse\\BootRestBook\\src\\main\\resources\\static\\image";
	public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath();
	public FileUploadHelper() throws IOException{
		
	}
	
	public boolean uploadFile(MultipartFile data) {
		
		boolean f = false;
		try {
			Files.copy(data.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + data.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			f = true;
		} catch (Exception e) {
			e.printStackTrace();	
		}	
		return f;		
	}
}
