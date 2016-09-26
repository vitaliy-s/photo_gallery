package ua.sosna.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ua.sosna.model.User;
import ua.sosna.service.GalleryServices;
import ua.sosna.service.UserService;
import ua.sosna.service.modelView.GalleryView;
import ua.sosna.service.PhotoServices;
import ua.sosna.service.modelView.PhotoView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

@RestController
public class PhotoGalleryController {

    private static final Logger LOGGER = Logger.getLogger(PhotoGalleryController.class);

    @Autowired
    private GalleryServices galleryServices;

    @Autowired
    private PhotoServices photoServices;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
    public void uploadPhoto(MultipartHttpServletRequest multipartHttpServletRequest) {
        photoServices.savePhoto(multipartHttpServletRequest);
    }


    @RequestMapping(value = "/downloadPhoto/{value}", method = RequestMethod.GET)
    public void downloadPhoto(@PathVariable String value) {

    }

    @RequestMapping(value = "/createGallery", method = RequestMethod.POST)
    public void createGallery(@RequestBody GalleryView gallery, Authentication authentication) {

        LOGGER.info("Gallery create - " + gallery.getName());
        String name = authentication.getName();
        galleryServices.createGalleryView(gallery, name);
    }

    @RequestMapping(value = "/allGallery", method = RequestMethod.GET)
    public List<GalleryView> allGallery(Authentication authentication) {

        LOGGER.info("allGallery");
        String name = authentication.getName();

        User user = userService.findByUsername(name);

        return galleryServices.albomsName(user.getId());
    }

    @RequestMapping(value = "/getAllPhoto", method = RequestMethod.GET)
    public List<PhotoView> getAllPhoto(HttpServletRequest request, Authentication authentication) {

        String name = authentication.getName();
        String url = request.getRequestURL().toString();
        String imageUrl = url + "/photo/";
        String thumbnailImageUrl = url + "/photo/thunb/";

        List<PhotoView> photoViews = photoServices.getAllPhotoView(imageUrl, thumbnailImageUrl, name);
        return photoViews;
    }

    @RequestMapping(value = "/getAllPhoto/photo/{id}", method = RequestMethod.GET)
    public void photoView(@PathVariable("id") String idImg, HttpServletResponse resp){

        int id = Integer.parseInt(idImg);
        PhotoView photoView = photoServices.getPhotoId(id);
        resp.reset();
        resp.setContentType(MediaType.IMAGE_JPEG_VALUE);

        LOGGER.info("/getAllPhoto/photo/{id} --- " + id);

        try(BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(photoView.getImage()))) {

            BufferedImage original = ImageIO.read(inputStream);

            int height = original.getHeight();
            int width = original.getWidth();

            int squareSize = (height > width ? width : height);

            int xc = width / 2;
            int yc = height / 2;

            BufferedImage sub = original.getSubimage(474, 338, 474, 338);
            ImageIO.write(sub, "jpeg", resp.getOutputStream());

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/getAllPhoto/photo/thunb/{id}", method = RequestMethod.GET)
    public void thunbView(@PathVariable("id") String idImg, HttpServletResponse resp) {
        int id = Integer.parseInt(idImg);
        PhotoView photoView = photoServices.getPhotoId(id);
        resp.reset();
        resp.setContentType(MediaType.IMAGE_JPEG_VALUE);

        try (BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(photoView.getImage()))){
            BufferedImage original = ImageIO.read(inputStream);
            BufferedImage sub = original.getSubimage(250, 250, 250, 250);
            ImageIO.write(sub, "jpeg", resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
