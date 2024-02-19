package com.webtodo.WebToDo.Controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer>{
    public List<ToDo> findByUserName(String userName);

}
