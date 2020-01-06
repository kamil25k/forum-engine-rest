package pl.kamil25k.forum.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import pl.kamil25k.forum.user.User;
import pl.kamil25k.forum.user.UserService;

import java.security.Principal;
import java.text.ParseException;
import java.util.Collection;
import java.util.Optional;

@Component
public class CommentApiImpl implements CommentApi {

    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public CommentApiImpl(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @Override
    public Optional<CommentDto> getComment(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @Override
    public Collection<CommentDto> getComments() {
        return commentService.getAllComment();
    }

    @Override
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

    @Override
    public void saveComment(@RequestBody CommentDto commentDto, @PathVariable Long id, Principal principal) throws ParseException {
        User user = userService.getUserByUsername(principal.getName());
        commentService.saveComment(commentDto, id, user);
    }


}
