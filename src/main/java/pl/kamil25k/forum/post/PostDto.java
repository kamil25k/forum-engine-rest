package pl.kamil25k.forum.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import pl.kamil25k.forum.comment.CommentDto;
import pl.kamil25k.forum.user.UserDto;

import java.time.LocalDateTime;
import java.util.List;

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

    public PostDto(Long id, UserDto user, String title, String body, LocalDateTime createDate, List<CommentDto> comment) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.body = body;
        this.createDate = createDate;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<CommentDto> getComment() {
        return comment;
    }

    public void setComment(List<CommentDto> comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

//    @Override
//    public String toString() {
//        return "PostDto{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", body='" + body + '\'' +
//                ", comment=" + comment +
//                ", user='" + user + '\'' +
//                ", createDate=" + createDate +
//                '}';
//    }

    public static class Builder {
        private Long id;
        private UserDto user;
        private String title;
        private String body;
        private List<CommentDto> comment;
        private LocalDateTime createDate;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }


        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setCreateDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder setUser(UserDto user) {
            this.user = user;
            return this;
        }

        public Builder setComment(List<CommentDto> comment) {
            this.comment = comment;
            return this;
        }

        public PostDto build() {
            return new PostDto(id, user, title, body, createDate, comment);
        }

    }
}
