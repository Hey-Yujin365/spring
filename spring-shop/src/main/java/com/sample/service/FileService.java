package com.sample.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	@Value("${upload.save.directory}")
	private String saveDirectory;
	
	public String upload(MultipartFile uploadFile) {
		// 첨부파일이 비어있으면 파일저장과정 없이 default.png를 반환한다.
		if (uploadFile.isEmpty()) {
			return "default.png";
		}
		
		// 첨부파일이 비어있지 않으면 파일을 저장하고, 해당 파일명을 반환한다.
		String filename = uploadFile.getOriginalFilename();
		File file = new File(saveDirectory, filename);
		
		try {
			FileCopyUtils.copy(uploadFile.getBytes(), file);
		} catch (IOException ex) {
			throw new RuntimeException("첨부파일을 저장할 수 없습니다.", ex);
		}
		
		return filename;
	}
}
