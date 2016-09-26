package ua.sosna.service.modelView;

import java.util.Set;

public class GalleryView {

    private int id;
    private String name;
    private Set<PhotoView> photos;

    public GalleryView() {
    }

    public GalleryView(int id, String name, Set<PhotoView> photos) {
        this.id = id;
        this.name = name;
        this.photos = photos;
    }

    public GalleryView(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public GalleryView(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PhotoView> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<PhotoView> photos) {
        this.photos = photos;
    }
}
