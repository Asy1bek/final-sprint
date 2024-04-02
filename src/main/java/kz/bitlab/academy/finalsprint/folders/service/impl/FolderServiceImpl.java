package kz.bitlab.academy.finalsprint.folders.service.impl;

import kz.bitlab.academy.finalsprint.folders.entity.FolderEntity;
import kz.bitlab.academy.finalsprint.folders.repository.FolderRepository;
import kz.bitlab.academy.finalsprint.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

@Service
public class FolderServiceImpl {

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private TaskService taskService;

    public FolderEntity updateFolder(Long folderId, Folder updatedFolder) {
        FolderEntity folder = folderRepository.findById(folderId).orElse(null);
        if (folder != null) {
            folder.setName(updatedFolder.getName());
            return folderRepository.save(folder);
        }
        return null;
    }

    public void deleteFolder(Long folderId) {
        FolderEntity folder = folderRepository.findById(folderId).orElse(null);
        if (folder != null) {
            for (Task task : folder.getTasks()) {
                taskService.delete(task.getClass());
            }
            folderRepository.deleteById(folderId);
        }
    }
}
