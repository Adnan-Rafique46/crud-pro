package services;

import dto.NotesDTO;

import java.util.List;

public interface NotesService {

    boolean create(NotesDTO dto);
    boolean update(NotesDTO dto);
    boolean deleteById(String id);
    NotesDTO findById(String id);
    List<NotesDTO> findAll();
}
