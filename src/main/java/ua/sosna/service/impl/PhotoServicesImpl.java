package ua.sosna.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ua.sosna.model.Gallery;
import ua.sosna.model.Photo;
import ua.sosna.model.User;
import ua.sosna.repository.GalleryRepository;
import ua.sosna.repository.PhotoRepository;
import ua.sosna.repository.UserRepository;
import ua.sosna.service.PhotoServices;
import ua.sosna.service.modelView.PhotoView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class PhotoServicesImpl implements PhotoServices {

    private static final Logger LOGGER = Logger.getLogger(PhotoServicesImpl.class);

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void savePhoto(MultipartHttpServletRequest request) {

        String galleryName = request.getParameter("select_gallery_list");
        int galleryId = galleryRepository.getId(galleryName);

        Iterator<String> iterator = request.getFileNames();
        MultipartFile multipartFile = null;

        Photo photo = new Photo();
        Gallery gallery = new Gallery();

        while (iterator.hasNext()) {
            multipartFile = request.getFile(iterator.next());


            photo.setName(multipartFile.getOriginalFilename());
            photo.setType(multipartFile.getContentType());
            photo.setSize(multipartFile.getSize() / 1024 + " Kb");
            try {
                photo.setImage(multipartFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            gallery.setId(galleryId);
            photo.setGallery(gallery);

            photoRepository.save(photo);

        }
    }

    @Override
    public List<PhotoView> getAllPhotoView(String imageUrl, String thumbnailImageUrl, String userName) {
        User user = userRepository.findByUsername(userName);
        Set<Gallery> galleryList = user.getGalleries();
        List<PhotoView> photoViews = new ArrayList<>();

        for (Gallery gallery : galleryList) {
            for (Photo photo : gallery.getPhotos()) {
                photoViews.add(new PhotoView(photo.getId(), photo.getName(), imageUrl + photo.getId(), thumbnailImageUrl + photo.getId()));
            }
        }
        return photoViews;
    }

    @Override
    public PhotoView getPhotoId(int id) {
        Photo photo = photoRepository.getOne(id);
        return new PhotoView(photo.getId(), photo.getName(), photo.getType(), photo.getSize(), photo.getImage());
    }
}
