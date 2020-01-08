package pl.kamil25k.forum.comment;

import lombok.*;
import pl.kamil25k.forum.post.Post;
import pl.kamil25k.forum.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
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

    public Comment(Long id, String body, LocalDateTime createDate, Post post, User user) {
        this.id = id;
        this.body = body;
        this.createDate = createDate;
        this.post = post;
        this.user = user;
    }
}
