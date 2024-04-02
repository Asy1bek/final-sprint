package kz.bitlab.academy.finalsprint.tasks.service;

import kz.bitlab.academy.finalsprint.tasks.entity.TaskEntity;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TaskService {

    void create(String title, String description, Long folderId);

    void update(Long id, String title, String description, int status);

    List<TaskEntity> findAllByFolder(Long folderId);

    TaskEntity findById(Long id);

    void delete(Class<? extends Task> id);

    Task getClass(Long taskId);
}
