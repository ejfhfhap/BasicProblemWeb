package com.sam.basic.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {

		public static String saveFile(MultipartFile multipartFile, String realPath) throws Exception {
			File file = new File(realPath);
			if(!file.exists()) {
				file.mkdir();
			}
			
			String fileName = UUID.randomUUID().toString() + multipartFile.getOriginalFilename();
			file = new File(file, fileName);
			multipartFile.transferTo(file);
			return fileName;
		}
}
