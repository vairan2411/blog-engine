package main.model;

import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.model.enume.ModerationStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "posts")
@NoArgsConstructor
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private Boolean isActive;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum('NEW', 'ACCEPTED', 'DECLINED') default 'NEW'", nullable = false)
  private ModerationStatus moderationStatus;

  private Long moderatorId;

  @ManyToOne
  @JoinColumn(nullable = false)
  private User user;

  @Column(nullable = false)
  private LocalDateTime time;

  @Column(nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String text;

  @Column(nullable = false)
  private int viewCount;

  @OneToMany(mappedBy = "post")
  private List<Vote> votes;

  @OneToMany(mappedBy = "post")
  private List<Comment> comments;

  @ManyToMany
  @JoinTable(name = "tag2post", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "post_id"))
  private Set<Tag> tags;


}
