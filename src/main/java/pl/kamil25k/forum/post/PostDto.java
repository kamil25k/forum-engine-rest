package pl.kamil25k.forum.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import lombok.*;
import pl.kamil25k.forum.comment.CommentDto;
import pl.kamil25k.forum.user.UserDto;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@ApiModel(value = "Post")
public class PostDto {

    private Long id;

    private String title;

    private String body;

    private UserDto user;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createDate;

    @JsonManagedReference
    private List<CommentDto> comment;

    public PostDto() {
    }

    public PostDto(Long id, String title, String body, UserDto user, LocalDateTime createDate, List<CommentDto> comment) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.createDate = createDate;
        this.comment = comment;
    }
}

