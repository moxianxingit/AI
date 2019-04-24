package com.spring.web.dao;

import java.util.List;

import com.spring.web.entity.User;

public interface FaceDao {

	public List<User> selectAllUsers();

}
