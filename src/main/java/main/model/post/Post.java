package main.model.post;

import lombok.Getter;
import lombok.Setter;
import main.model.users.User;
import main.model.votes.Vote;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "moderation_status")
    private ModerationStatus moderationStatus=ModerationStatus.NEW;

    @Column (name = "moderator_id")
    private int moderatorId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @Column(name = "title", nullable = false)
    private String title;

    @Column (name = "text", columnDefinition = "TEXT", nullable = false)
    private String text;

    @Column(name = "view_count",nullable = false)
    private int viewCount;

    @OneToMany(mappedBy = "post")
    private List<Vote> votes;

}
