package ua.lviv.iot.christmasfair.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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
import ua.lviv.iot.christmasfair.business.ViewerService;
import ua.lviv.iot.christmasfair.model.Viewer;

@RestController
@RequestMapping("/viewers")
public class ViewerController {

  @Autowired
  private ViewerService viewerService;
  private AtomicInteger idCounter = new AtomicInteger();
  
  @GetMapping("/test")
  public Viewer getViewerTest() {
    return new Viewer();
  }
  
  @GetMapping
  public List<Viewer> getAllViewers() {
    return viewerService.getAllObjects();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Viewer> getObject(final @PathVariable("id") Integer viewerId) {
    Viewer currentViewer;
    ResponseEntity<Viewer> response = (currentViewer = viewerService.getObject(viewerId)) == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(currentViewer, HttpStatus.OK);
    return response;
  }

  @PostMapping
  public Viewer createObject(final @RequestBody Viewer viewer) {
    viewer.setId(idCounter.incrementAndGet());
    viewerService.createObject(viewer);
    return viewer;
  }

  @PutMapping("/{id}")
  public ResponseEntity<Viewer> updateObject(final @PathVariable("id") Integer viewerId, final @RequestBody Viewer viewer) {
    viewer.setId(viewerId);
    Viewer oldViewer;
    ResponseEntity<Viewer> response = (oldViewer = viewerService.updateObject(viewerId, viewer, new Viewer())) == null
        ? new ResponseEntity<Viewer>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<Viewer>(oldViewer, HttpStatus.OK);
    return response;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Viewer> deleteObject(final @PathVariable("id") Integer viewerId) {
    HttpStatus status = viewerService.deleteObject(viewerId) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<Viewer>(status);
  }
}
