package com.amit.save_retrieve_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amit.save_retrieve_file.entity.Image;
import com.amit.save_retrieve_file.repos.ImageRepository;

@SpringBootTest
class SaveRetrieveFileApplicationTests {
	
	@Autowired
	ImageRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void saveFile()throws Exception {
		Image image = new Image();
		
		image.setId(1L);
		
		image.setName("test-image.jpg");
		
		File file = new File("C:\\Users\\Amit\\Downloads\\test-image.jpg");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte fileContent[]=new byte[(int)file.length()];
		fileInputStream.read(fileContent);
		
		image.setData(fileContent);
		
		fileInputStream.close();
		
		repository.save(image);
		
	}
	
	@Test
	void downloadFile()throws Exception {
		Image image = repository.findById(1L).get();
		
		File file = new File("C:\\Users\\Amit\\Downloads\\test\\"+image.getName());
		FileOutputStream fos=null;
		try {
			fos= new FileOutputStream(file);
			fos.write(image.getData());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fos.close();
		}
		
		
		
		
		
		
	}

}
