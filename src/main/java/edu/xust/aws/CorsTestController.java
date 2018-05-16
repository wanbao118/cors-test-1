package edu.xust.aws;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class CorsTestController {

	@RequestMapping(path="/image/{filename}", method = RequestMethod.GET,produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<InputStreamResource> load(@PathVariable("filename") String filename) throws Exception {
		
//		InputStream inputStream = CorsTestController.class.getResourceAsStream(filename);
		ClassPathResource imgFile = new ClassPathResource("static" + File.separator + filename);
		InputStreamResource data = new InputStreamResource(imgFile.getInputStream());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(data);
	}
	
	
	
}
