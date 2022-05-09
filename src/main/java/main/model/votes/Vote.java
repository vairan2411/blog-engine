package main.model.votes;

import lombok.Getter;
import lombok.Setter;
import main.model.post.Post;
import main.model.users.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id",referencedColumnName = "id",nullable = false)
    private Post post;

    @Column(name = "time",nullable = false)
    LocalDateTime time;

    @Column(name = "value", nullable = false, length = 1)
    private byte value;

}
