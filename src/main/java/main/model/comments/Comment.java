package main.model.comments;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.model.post.Post;
import main.model.users.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parent_id",referencedColumnName = "id")
    private Comment parentComment;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "post_id",referencedColumnName = "id", nullable = false)
    private Post post;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
    private User user;

    @Column(name = "time",nullable = false)
    private LocalDateTime time;

    @Column(name = "text", columnDefinition = "TEXT", nullable = false)
    private String text;

}
