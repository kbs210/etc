package com.java.fileBoard.controller;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.fileBoard.dto.FileBoardDto;
import com.java.fileBoard.service.FileBoardService;

@Controller
public class FileBoardController{
   
   @Autowired
   private FileBoardService fileBoardService;

   @RequestMapping(value="/fileBoard/write.do")
   public ModelAndView fileBoardWrite(HttpServletRequest request, HttpServletResponse response) {
      
      ModelAndView mav = new ModelAndView();
      mav.addObject("request",request);
      
      fileBoardService.fileBoardWrite(mav);
      
      return mav;
      
   }
   
   @RequestMapping(value="/fileBoard/writeOk.do")
   public ModelAndView fileBoardWriteOk(HttpServletRequest request, HttpServletResponse response, FileBoardDto fileBoardDto) {
      
      ModelAndView mav = new ModelAndView();
      mav.addObject("request", request);
      mav.addObject("fileBoardDto", fileBoardDto);
      fileBoardService.fileBoardWriteOk(mav);
      
      return mav;
      
   }
}
