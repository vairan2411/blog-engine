package main.model.tags;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.model.post.Post;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tags")
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "tag2post",
            joinColumns = @JoinColumn(name = "posts_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Post> posts;

}
