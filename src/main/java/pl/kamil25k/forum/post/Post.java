package pl.kamil25k.forum.post;

import pl.kamil25k.forum.comment.Comment;
import pl.kamil25k.forum.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String title;

    private String body;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
//    @JsonBackReference
    private List<Comment> comment;

    private LocalDateTime createDate;


    public Post() {
    }

    public Post(User user, String title, String body, LocalDateTime createDate, List<Comment> comment) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public static class Builder {
        private User user;
        private String title;
        private String body;
        private LocalDateTime createDate;
        private List<Comment> comment;

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

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setComment(List<Comment> comment) {
            this.comment = comment;
            return this;
        }

        public Post build() {
            return new Post(user, title, body, createDate, comment);
        }
    }
}
