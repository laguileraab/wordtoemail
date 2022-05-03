package com.file.wordtoemail.controllers;

import com.file.wordtoemail.response.MessageResponse;
import com.file.wordtoemail.services.HTMLService;
import com.file.wordtoemail.services.WordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/html")
@RestController
public class HTMLController {
    
    @Autowired
    private HTMLService htmlService;

    @GetMapping
    public ResponseEntity<MessageResponse>uploadHTML(@RequestParam("file") MultipartFile file){
        htmlService.sendEmailHTML(file);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
