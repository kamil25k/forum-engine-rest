package pl.kamil25k.forum.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.*;
import pl.kamil25k.forum.post.PostDto;
import pl.kamil25k.forum.user.UserDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@ApiModel(value = "Comment")
public class CommentDto {

    private Long id;

    @NotNull
    private String body;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createDate;

    @JsonBackReference
    private PostDto post;

    private UserDto user;

    public CommentDto() {
    }

    public CommentDto(Long id, String body, LocalDateTime createDate, PostDto post, UserDto user) {
        this.id = id;
        this.body = body;
        this.createDate = createDate;
        this.post = post;
        this.user = user;
    }
}
