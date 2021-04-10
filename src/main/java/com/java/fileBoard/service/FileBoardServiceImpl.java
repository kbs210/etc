package com.java.fileBoard.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.HAspect;
import com.java.fileBoard.dao.FileBoardDao;
import com.java.fileBoard.dto.FileBoardDto;

@Component
public class FileBoardServiceImpl implements FileBoardService {

	@Autowired
	FileBoardDao fileBoardDao;
	
	@Override
	public void fileBoardWrite(ModelAndView mav) {

		int boardNumber = 0;
		int groupNumber = 1;
		int sequenceNumber = 0;
		int sequenceLevel = 0;
		
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		if (request.getParameter("boardNumber")!=null) {
			boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
			groupNumber = Integer.parseInt(request.getParameter("groupNumber"));
			sequenceNumber = Integer.parseInt(request.getParameter("sequenceNumber"));
			sequenceLevel = Integer.parseInt(request.getParameter("sequenceLevel"));
		}
		
		mav.addObject("boardNumber", boardNumber);
		mav.addObject("groupNumber", groupNumber);
		mav.addObject("sequenceNumber", sequenceNumber);
		mav.addObject("sequenceLevel", sequenceLevel);
		
		mav.setViewName("fileBoard/write");
		
	}

	
	
	@Override
	public void fileBoardWriteOk(ModelAndView mav) {

		Map<String, Object> map = mav.getModelMap();
		FileBoardDto fileBoardDto = (FileBoardDto) map.get("fileBoardDto");
		MultipartHttpServletRequest request = (MultipartHttpServletRequest) map.get("request");
		
		fileBoardDto.setWriteDate(new Date());
		fileBoardDto.setReadCount(0);
		writeNumber(fileBoardDto);
		
		MultipartFile upFile = request.getFile("file");
		
		if(upFile.getSize() != 0) {
			String fileName = Long.toString(System.currentTimeMillis()) + "_" + upFile.getOriginalFilename();
			long fileSize =upFile.getSize();
			File path = new File("C:\\workspace\\spring\\06_MavenSpringMVC\\src\\main\\webapp\\resources\\");
			
			path.mkdir();
			if(path.exists() && path.isDirectory()) {
				File file = new File(path, fileName);
				
				try {
					upFile.transferTo(file);
					fileBoardDto.setPath(file.getAbsolutePath());
					fileBoardDto.setFileName(fileName);
					fileBoardDto.setFileSize(fileSize);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		int check = fileBoardDao.fileBoardWrite(fileBoardDto);
		
		mav.addObject("check", check);
		mav.setViewName("fileBoard/writeOk");
				
		
	}

	private void writeNumber(FileBoardDto fileBoardDto) {
		int boardNumber = fileBoardDto.getBoardNumber();
		int groupNumber = fileBoardDto.getGroupNumber();
		int sequenceNumber = fileBoardDto.getSequenceNumber();
		int sequenceLevel = fileBoardDto.getSequenceLevel();
		
		if(boardNumber == 0) {
			int max = fileBoardDao.fileBoardGroupNumberMax();
			
			if (max != 0) {
				fileBoardDto.setGroupNumber(max + 1);
			}
		} else {
			
			HashMap<String, Integer> hmap = new HashMap<String, Integer>();
			hmap.put("groupNumber", groupNumber);
			hmap.put("sequenceNumber", sequenceNumber);
			
			int check = fileBoardDao.fileBoardWriteNumber(hmap);
			
			sequenceNumber += 1;
			sequenceLevel += 1;
			
			fileBoardDto.setSequenceNumber(sequenceNumber);
			fileBoardDto.setSequenceLevel(sequenceLevel);
		}
	}

	@Override
	public void fileBoardList(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fileBoardRead(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fileDownLoad(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fileBoardUpdate(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fileBoardUpdateOk(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}
	

}
