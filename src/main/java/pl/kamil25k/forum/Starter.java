package pl.kamil25k.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.kamil25k.forum.comment.CommentDto;
import pl.kamil25k.forum.comment.CommentService;
import pl.kamil25k.forum.post.PostDto;
import pl.kamil25k.forum.post.PostService;
import pl.kamil25k.forum.user.Role;
import pl.kamil25k.forum.user.User;
import pl.kamil25k.forum.user.UserService;

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

        User user = User.builder()
                .firstName("Andrzej")
                .lastName("Kowalski")
                .role(Role.ROLE_ADMIN)
                .username("andrzej")
                .password(passwordEncoder.encode("andrzej"))
                .build();
        userService.saveUser(user);

        User user1 = User.builder()
                .firstName("Marian")
                .lastName("Nowak")
                .role(Role.ROLE_USER)
                .username("marian")
                .password(passwordEncoder.encode("marian"))
                .build();
        userService.saveUser(user1);

        User user2 = User.builder()
                .firstName("Tomasz")
                .lastName("Gorski")
                .role(Role.ROLE_ADMIN)
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .build();
        userService.saveUser(user2);

        User user3 = User.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .username("jan")
                .password(passwordEncoder.encode("kowalski"))
                .build();
        userService.saveUser(user3);

        User user4 = User.builder()
                .firstName("Anna")
                .lastName("Kowalska")
                .username("anna")
                .password(passwordEncoder.encode("kowalska"))
                .build();
        userService.saveUser(user4);

        PostDto postDto = PostDto.builder()
                .body("Hello it's first post on this forum")
                .title("1 post")
                .build();
        postService.savePost(postDto, user3);

        CommentDto commentDto = CommentDto.builder()
                .body("Hey")
                .build();
        commentService.saveComment(commentDto, 1L, user1);

        CommentDto commentDto1 = CommentDto.builder()
                .body("Nice to meet you")
                .build();
        commentService.saveComment(commentDto1, 1L, user2);

        PostDto postDto1 = PostDto.builder()
                .title("Problem with laptop")
                .body("Hey i have problem with my laptop. I can't turn it on")
                .build();
        postService.savePost(postDto1, user3);

        CommentDto commentDto2 = CommentDto.builder()
                .body("Hey you should phone to computer service")
                .build();
        commentService.saveComment(commentDto2, 2L, user1);

        CommentDto commentDto3 = CommentDto.builder()
                .body("Thanks for help")
                .build();
        commentService.saveComment(commentDto3, 2L, user3);

    }
}
