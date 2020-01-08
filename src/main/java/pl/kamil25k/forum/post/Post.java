package pl.kamil25k.forum.post;

import lombok.*;
import pl.kamil25k.forum.comment.Comment;
import pl.kamil25k.forum.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
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
    private List<Comment> comment;

    private LocalDateTime createDate;

    public Post() {
    }

    public Post(Long id, User user, String title, String body, List<Comment> comment, LocalDateTime createDate ) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.body = body;
        this.createDate = createDate;
        this.comment = comment;
    }

}
