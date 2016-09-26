package ua.sosna.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sosna.model.Gallery;
import ua.sosna.model.User;
import ua.sosna.repository.GalleryRepository;
import ua.sosna.repository.UserRepository;
import ua.sosna.service.GalleryServices;
import ua.sosna.service.modelView.GalleryView;

import java.util.ArrayList;
import java.util.List;

@Service
public class GalleryServicesImpl implements GalleryServices{

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<GalleryView> albomsName(int userId) {
        List<GalleryView> galleryViews = new ArrayList<>();
        for (Gallery gallery : galleryRepository.findByUser_Id(userId)){
            galleryViews.add(new GalleryView(gallery.getName()));
        }
        return galleryViews;
    }

    @Override
    public void createGalleryView(GalleryView galleryView, String userName) {
        User user = userRepository.findByUsername(userName);
        Gallery gallery = new Gallery();
        gallery.setName(galleryView.getName());
        gallery.setUser(user);
        galleryRepository.save(gallery);
    }


}
