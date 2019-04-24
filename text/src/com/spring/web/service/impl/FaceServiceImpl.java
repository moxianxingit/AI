package com.spring.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.web.dao.FaceDao;
import com.spring.web.entity.User;
import com.spring.web.service.FaceService;

@Service
public class FaceServiceImpl implements FaceService {
	@Resource
	private FaceDao facedao;


	public List<User> selectAllUsers() {
		return facedao.selectAllUsers();
	}

}
