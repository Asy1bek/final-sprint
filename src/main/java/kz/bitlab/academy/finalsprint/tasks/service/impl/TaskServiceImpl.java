package kz.bitlab.academy.finalsprint.tasks.service.impl;

import kz.bitlab.academy.finalsprint.tasks.entity.TaskEntity;
import kz.bitlab.academy.finalsprint.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl {

    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    public TaskEntity updateTask(Long taskId, Task updatedTask) {
        TaskEntity task = taskRepository.findById(taskId).orElse(null);
        if (task != null) {
            task.setTitle(String.valueOf(updatedTask.getClass()));
            task.setDescription(String.valueOf(updatedTask.getClass()));
            task.setStatus(updatedTask.getClass().getModifiers());
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}

