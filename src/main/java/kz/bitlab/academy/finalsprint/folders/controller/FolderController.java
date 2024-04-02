package kz.bitlab.academy.finalsprint.folders.controller;
import kz.bitlab.academy.finalsprint.folders.service.FolderService;
import kz.bitlab.academy.finalsprint.folders.service.impl.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/folders")
public class FolderController {

    @Autowired
    private FolderService folderService;

    @PutMapping("/{folderId}")
    public ResponseEntity<Folder> updateFolder(@PathVariable Long folderId, @RequestBody Folder folder) {
        Folder updatedFolder = folderService.updateFolder(folderId, folder);
        if (updatedFolder != null) {
            return new ResponseEntity<>(updatedFolder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{folderId}")
    public ResponseEntity<Void> deleteFolder(@PathVariable Long folderId) {
        folderService.deleteFolder(folderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
