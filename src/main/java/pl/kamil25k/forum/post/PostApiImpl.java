package pl.kamil25k.forum.post;

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
public class PostApiImpl implements PostApi {

    final private PostService postService;
    final private UserService userService;

    @Autowired
    public PostApiImpl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @Override
    public Collection<PostDto> getPosts() {
        return postService.getAllPost();
    }

    @Override
    public Optional<PostDto> getPost(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @Override
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @Override
    public void savePost(@RequestBody PostDto postDto, Principal principal) throws ParseException {
        User user = userService.getUserByUsername(principal.getName());
        postService.savePost(postDto, user);
    }

}
