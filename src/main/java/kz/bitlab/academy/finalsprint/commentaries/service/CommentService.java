package kz.bitlab.academy.finalsprint.commentaries.service;

import kz.bitlab.academy.finalsprint.commentaries.repository.CommentRepository;
import kz.bitlab.academy.finalsprint.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TaskService taskService;

    public Comment addCommentToTask(Long taskId, Comment comment) {
        Task task = taskService.getClass(taskId);
        if (task != null) {
            comment.getText();
            return commentRepository.save(comment);
        }
        return null;
    }
}
