package ua.lviv.iot.christmasfair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.christmasfair.business.DecorBoxService;
import ua.lviv.iot.christmasfair.model.DecorBox;

@RestController
@RequestMapping("/boxes")
public class DecorBoxController {

  @Autowired
  private DecorBoxService decorBoxService;

  @GetMapping("/test")
  public DecorBox getViewerTest() {
    return new DecorBox();
  }
  
  @GetMapping
  public List<DecorBox> getAllBoxes() {
    return decorBoxService.getAllObjects();
  }

  @GetMapping("/{id}")
  public ResponseEntity<DecorBox> getBox(final @PathVariable("id") Integer boxId) {
    DecorBox currentDecorBox;
    ResponseEntity<DecorBox> response = (currentDecorBox = decorBoxService.getObject(boxId)) == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(currentDecorBox, HttpStatus.OK);
    return response;
  }

  @PostMapping
  public DecorBox createBox(final @RequestBody DecorBox box) {
    decorBoxService.createObject(box);
    return box;
  }

  @PutMapping("/{id}")
  public ResponseEntity<DecorBox> updateBox(final @PathVariable("id") Integer boxId, final @RequestBody DecorBox box) {
    box.setId(boxId);
    DecorBox oldDecorBox;
    ResponseEntity<DecorBox> response = (oldDecorBox = decorBoxService.updateObject(boxId, box, new DecorBox())) == null
        ? new ResponseEntity<DecorBox>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<DecorBox>(oldDecorBox, HttpStatus.OK);
    return response;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<DecorBox> deleteBox(final @PathVariable("id") Integer boxId) {
    HttpStatus status = decorBoxService.deleteObject(boxId) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<DecorBox>(status);
  }

}
