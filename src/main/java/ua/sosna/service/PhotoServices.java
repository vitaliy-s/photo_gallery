package ua.sosna.service;


import org.springframework.web.multipart.MultipartHttpServletRequest;
import ua.sosna.service.modelView.PhotoView;

import java.util.List;

public interface PhotoServices {

    void savePhoto(MultipartHttpServletRequest request);

    List<PhotoView> getAllPhotoView(String imageUrl, String thumbnailImageUrl, String userName);

    PhotoView getPhotoId(int id);

}
