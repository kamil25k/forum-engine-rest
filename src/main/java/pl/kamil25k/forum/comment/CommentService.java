package pl.kamil25k.forum.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamil25k.forum.post.PostDto;
import pl.kamil25k.forum.post.PostService;
import pl.kamil25k.forum.user.User;
import pl.kamil25k.forum.user.UserService;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final PostService postService;
    private final UserService userService;


    @Autowired
    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper, PostService postService, UserService userService) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.postService = postService;
        this.userService = userService;
    }

    public void saveComment(CommentDto commentDto, Long postId, User userComment) throws ParseException {
        if (postService.getPostById(postId).isPresent()) {
            PostDto postDto = postService.getPostById(postId).get();
            commentDto.setCreateDate(LocalDateTime.now());
            commentDto.setPost(postDto);
            Comment comment = commentMapper.mapToEntity(commentDto);
            comment.setUser(userComment);
            Comment savedComment = commentRepository.save(comment);

            if (postDto.getComment() != null) {
                postDto.getComment().add(commentMapper.mapToDto(savedComment));
            } else {
                List<CommentDto> commentDtoList = new ArrayList<>();
                commentDtoList.add(commentMapper.mapToDto(savedComment));
                postDto.setComment(commentDtoList);
            }
            User userPost = userService.getUserByUsername(postDto.getUser().getUsername());
            postService.savePost(postDto, userPost);
        }
    }

    public Optional<CommentDto> getCommentById(Long id) {
        return commentRepository.findById(id)
                .map(commentMapper::mapToDto);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public Collection<CommentDto> getAllComment() {
        return commentRepository.findAll()
                .stream()
                .map(commentMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
