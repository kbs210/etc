package com.java.fileBoard.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.fileBoard.dto.FileBoardDto;

@Component
public class FileBoardDaoImpl implements FileBoardDao  {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int fileBoardGroupNumberMax() {
		return sqlSessionTemplate.selectOne("fileBoard_maxGroup");
	}
	
	public int fileBoardWriteNumber(HashMap<String, Integer> hmap) {
		return sqlSessionTemplate.update("fileBoard_update_number", hmap);
	}
	
	public int fileBoardWrite(FileBoardDto fileBoardDto) {
		if(fileBoardDto.getFileName()==null) {
			return sqlSessionTemplate.insert("fileBoard_insert", fileBoardDto);
		}
		return sqlSessionTemplate.insert("fileBoard_insert_file", fileBoardDto);
	}

	@Override
	public int fileBoardCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FileBoardDto> fileBoardList(int startRow, int endRow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileBoardDto fileBoardRead(int boardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileBoardDto filBoardSelect(int boardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileBoardDto fileBoardUpdate(int boardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int fileBoardupdateOk(int boardNumber, FileBoardDto fileBoardDto) {
		// TODO Auto-generated method stub
		return 0;
	}
}
