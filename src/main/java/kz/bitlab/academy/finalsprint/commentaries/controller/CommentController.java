package kz.bitlab.academy.finalsprint.commentaries.controller;

import kz.bitlab.academy.finalsprint.commentaries.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/task/{taskId}")
    public ResponseEntity<Comment> addCommentToTask(@PathVariable Long taskId, @RequestBody Comment comment) {
        Comment newComment = commentService.addCommentToTask(taskId, comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }
}
