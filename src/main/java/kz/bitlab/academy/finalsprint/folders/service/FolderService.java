package kz.bitlab.academy.finalsprint.folders.service;

import kz.bitlab.academy.finalsprint.folders.entity.FolderEntity;
import kz.bitlab.academy.finalsprint.folders.service.impl.Folder;

import java.util.List;

public interface FolderService {

    String create(String name);

    String update(Long id, String name);

    List<FolderEntity> findAll();

    FolderEntity findById(Long id);

    void addCategory(Long id, Long categoryId);

    void removeCategory(Long id, Long categoryId);

    void delete(Long id);

    Folder updateFolder(Long folderId, Folder folder);

    void deleteFolder(Long folderId);
}
