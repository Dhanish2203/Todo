package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Project;
import com.demo.entity.Todo;
import com.demo.repository.ProjectRepository;
import com.demo.repository.TodoRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Project createProject(String title) {
        Project project = new Project(title, null);
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void addTodo(Long projectId, String description) {
        Project project = getProjectById(projectId);
        Todo todo = new Todo(description, description, false);
        todo.setProject(project);
        todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long todoId, String description, boolean completed) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setDescription(description);
        todo.setCompleted(completed);
        return todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
