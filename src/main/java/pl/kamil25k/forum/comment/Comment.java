package pl.kamil25k.forum.comment;

import pl.kamil25k.forum.post.Post;
import pl.kamil25k.forum.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    private LocalDateTime createDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Post post;

    @ManyToOne
    private User user;

    public Comment() {
    }

    public Comment(String body, LocalDateTime createDate, Post post, User user) {
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", createDate=" + createDate +
                ", post=" + post +
                '}';
    }

    public static class Builder {
        private String body;
        private LocalDateTime createDate;
        private Post post;
        private User user;

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setCreateDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder setPost(Post post) {
            this.post = post;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Comment build() {
            return new Comment(body, createDate, post, user);
        }
    }

}
