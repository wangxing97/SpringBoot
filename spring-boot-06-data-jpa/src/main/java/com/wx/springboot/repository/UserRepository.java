package com.wx.springboot.repository;

import com.wx.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository需要带两个泛型，第一个是需要操作的Entiry，第二个传主键的类型
public interface UserRepository extends JpaRepository<User,Integer>{
}
