package ua.sosna.service.modelView;


public class PhotoView {

    private int id;
    private String name;
    private String type;
    private String size;
    private String img;
    private byte[] image;
    private GalleryView gallery;
    private String imageUrl;
    private String thumbnailImageUrl;

    public PhotoView() {
    }

    public PhotoView(int id, String name, String type, String size, byte[] image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.image = image;
    }

    public PhotoView(int id, String name, String imageUrl, String thumbnailImageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.thumbnailImageUrl = thumbnailImageUrl;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public GalleryView getGallery() {
        return gallery;
    }

    public void setGallery(GalleryView gallery) {
        this.gallery = gallery;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }
}
