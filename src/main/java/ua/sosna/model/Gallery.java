package ua.sosna.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gallery")
public class Gallery {

    private int id;
    private String name;
    private Set<Photo> photos;
    private User user;


    public Gallery() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gallery_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "gallery_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "gallery")
    @Column(name = "photo_id")
    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
