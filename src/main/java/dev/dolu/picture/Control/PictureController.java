package dev.dolu.picture.Control;


import dev.dolu.picture.Picture.PictureService;
import dev.dolu.picture.Picture.PictureToSend;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PictureController {

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }


    @ResponseStatus(code = HttpStatus.OK)  // HTTP 200 OK status code for successful response
    @GetMapping("/random")

    public PictureToSend getRandomPicture() {
        return pictureService.getRandomPicture();
    }



}
