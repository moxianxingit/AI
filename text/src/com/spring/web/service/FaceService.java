package com.spring.web.service;

import java.util.List;

import com.mysql.jdbc.Blob;
import com.spring.web.entity.User;

public interface FaceService {

	public List<User> selectAllUsers();

}
