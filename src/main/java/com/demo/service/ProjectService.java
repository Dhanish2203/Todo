package com.demo.service;

import java.util.List;

import com.demo.entity.Project;
import com.demo.entity.Todo;


public interface ProjectService {
    Project createProject(String title);
    List<Project> getAllProjects();
    Project getProjectById(Long id);
    void deleteProject(Long id);
    void addTodo(Long projectId, String description);
    Todo updateTodo(Long todoId, String description, boolean completed);
    void deleteTodo(Long todoId);
}
