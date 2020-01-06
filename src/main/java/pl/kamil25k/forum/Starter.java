package pl.kamil25k.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.kamil25k.forum.comment.CommentDto;
import pl.kamil25k.forum.comment.CommentMapper;
import pl.kamil25k.forum.comment.CommentService;
import pl.kamil25k.forum.post.PostDto;
import pl.kamil25k.forum.post.PostMapper;
import pl.kamil25k.forum.post.PostService;
import pl.kamil25k.forum.user.Role;
import pl.kamil25k.forum.user.User;
import pl.kamil25k.forum.user.UserService;

import java.time.LocalDateTime;


@Component
public class Starter implements CommandLineRunner {


    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public Starter(UserService userService, PostService postService, CommentService commentService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.postService = postService;
        this.commentService = commentService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User.Builder()
                .setFirstName("Andrzej")
                .setLastName("Kowalski")
                .setRole(Role.ROLE_ADMIN)
                .setUsername("andrzej")
                .setPassword(passwordEncoder.encode("andrzej"))
                .build();
        userService.saveUser(user);

        User user1 = new User.Builder()
                .setFirstName("Marian")
                .setLastName("Nowak")
                .setRole(Role.ROLE_USER)
                .setUsername("marian")
                .setPassword(passwordEncoder.encode("marian"))
                .build();
        userService.saveUser(user1);

        User user2 = new User.Builder()
                .setFirstName("Tomasz")
                .setLastName("Gorski")
                .setRole(Role.ROLE_ADMIN)
                .setUsername("admin")
                .setPassword(passwordEncoder.encode("admin"))
                .build();
        userService.saveUser(user2);


        User user3 = new User.Builder()
                .setFirstName("Janusz")
                .setLastName("Kowalski")
                .setUsername("janusz")
                .setPassword(passwordEncoder.encode("kowalski"))
                .build();
        userService.saveUser(user3);

        User user4 = new User.Builder()
                .setFirstName("Anna")
                .setLastName("Kowalska")
                .setUsername("anna")
                .setPassword(passwordEncoder.encode("kowalska"))
                .build();
        userService.saveUser(user4);

        PostDto postDto = new PostDto.Builder()
                .setBody("Hello it's first post on this forum")
                .setTitle("1 post")
                .build();
        postService.savePost(postDto, user3);

        CommentDto commentDto = new CommentDto.Builder()
                .setBody("Hey")
                .build();
        commentService.saveComment(commentDto, 1L, user1);

        CommentDto commentDto1 = new CommentDto.Builder()
                .setBody("Nice to meet you")
                .build();
        commentService.saveComment(commentDto1, 1L, user1);


        PostDto postDto1 = new PostDto.Builder()
                .setTitle("Problem with laptop")
                .setBody("Hey i have problem with my laptop. I can't turn it on")
                .build();
        postService.savePost(postDto1, user3);

        CommentDto commentDto2 = new CommentDto.Builder()
                .setBody("Hey you should phone to computer service")
                .build();
        commentService.saveComment(commentDto2, 2L, user1);

        CommentDto commentDto3 = new CommentDto.Builder()
                .setBody("Thanks for help")
                .build();
        commentService.saveComment(commentDto3, 2L, user3);

    }
}
