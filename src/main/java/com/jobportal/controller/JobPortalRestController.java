package com.jobportal.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.model.User;
import com.jobportal.service.UserService;

@RestController
public class JobPortalRestController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/checkuserexists")
	@ResponseBody
	public String callDao(@RequestParam(name="username",required=true) String username) {
		if(username!= null && username !="") {
		List<User> userList = userService.findUserByName1(username);
			if(userList != null && !userList.isEmpty() && userList.size()>0) {
				System.out.println(userList);
				return "true";
			}
			return "false";
		}
		return "Try Again.";
	}
	
	/*@RequestMapping(path = "/download", method = RequestMethod.POST)
	public ResponseEntity<InputStreamResource> download(@RequestParam("uuid") String uuid, @RequestParam("documentName") String documentName) throws IOException {
		System.out.println("uuid:"+uuid);
		System.out.println("documentName:"+documentName);
		StringBuffer path = new StringBuffer("E:\\work\\zdocs\\"+uuid+"\\"+documentName);
		System.out.println("path:"+path.toString());
		File file = new File(path.toString());
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	    HttpHeaders headers = new HttpHeaders(); headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=myDoc.docx");
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(file.length())
	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
	            .body(resource);
	}*/
	
	/*@RequestMapping(path = "/download/{uuid}/{documentName}", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> download(@PathVariable("uuid") String uuid, @PathVariable("documentName") String documentName) throws IOException {
		System.out.println("uuid:"+uuid);
		System.out.println("documentName:"+documentName);
		StringBuffer path = new StringBuffer("E:\\work\\zdocs\\"+uuid+"\\"+documentName);
		System.out.println("path:"+path.toString());
		File file = new File(path.toString());
		
		
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	    HttpHeaders headers = new HttpHeaders(); headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename="+documentName);
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(file.length())
	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
	            .body(resource);
	}*/
	
	@RequestMapping(path = "/download/{uuid}/{documentName}", method = RequestMethod.POST)
	public String download(@PathVariable("uuid") String uuid, @PathVariable("documentName") String documentName) throws IOException {
		System.out.println("uuid:"+uuid);
		System.out.println("documentName:"+documentName);
		StringBuffer path = new StringBuffer("E:\\work\\zdocs\\"+uuid+"\\"+documentName);
		System.out.println("path:"+path.toString());
		File file = new File(path.toString());
		byte [] bytes = Files.readAllBytes(file.toPath());
	    String b64 = Base64.getEncoder().encodeToString(bytes);
	    System.out.println("-------------------------------------------");
	    System.out.println(b64);
	    System.out.println("-------------------------------------------");
	    return b64;
	}
	
}
