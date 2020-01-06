package pl.kamil25k.forum.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import pl.kamil25k.forum.post.PostDto;
import pl.kamil25k.forum.user.UserDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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

    public CommentDto(String body, LocalDateTime createDate, PostDto post, UserDto user) {
        this.body = body;
        this.createDate = createDate;
        this.post = post;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public PostDto getPost() {
        return post;
    }

    public void setPost(PostDto post) {
        this.post = post;
    }


    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", createDate=" + createDate +
                ", post=" + post +
                ", user=" + user +
                '}';
    }

    public static class Builder {
        private String body;
        private LocalDateTime createDate;
        private PostDto post;
        private UserDto user;

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setCreateDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder setPost(PostDto post) {
            this.post = post;
            return this;
        }

        public Builder setUser(UserDto user) {
            this.user = user;
            return this;
        }

        public CommentDto build() {
            return new CommentDto(body, createDate, post, user);
        }
    }
}
