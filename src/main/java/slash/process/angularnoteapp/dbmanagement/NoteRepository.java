package slash.process.angularnoteapp.dbmanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slash.process.angularnoteapp.model.Note;
import slash.process.angularnoteapp.model.Notebook;

import java.util.List;
import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {
    List<Note> findAllByNotebook(Notebook notebook);
}
