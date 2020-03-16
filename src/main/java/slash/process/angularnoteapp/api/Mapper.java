package slash.process.angularnoteapp.api;

import org.springframework.stereotype.Component;
import slash.process.angularnoteapp.api.viewmodel.NoteViewModel;
import slash.process.angularnoteapp.api.viewmodel.NotebookViewModel;
import slash.process.angularnoteapp.dbmanagement.NotebookRepository;
import slash.process.angularnoteapp.model.Note;
import slash.process.angularnoteapp.model.Notebook;

import java.util.UUID;

@Component
public class Mapper {
    private NotebookRepository notebookRepository;

    public Mapper(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    public NoteViewModel convertToNoteViewModel(Note entity) {

//        var viewModel = entity.noteModel();
//        viewModel.setTitle(entity.getTitle());
//        viewModel.setId(entity.getId().toString());
//        viewModel.setLastModifiedOn(entity.getLastModifiedOn());
//        viewModel.setText(entity.getText());
//        viewModel.setNotebookId(entity.getNotebook().getId().toString());


        return entity.noteModel();
    }

//    public Note convertToNoteEntity(NoteViewModel viewModel) {
//        var notebook = this.notebookRepository.findById(UUID.fromString(viewModel.getNotebookId())).get();
//        var entity = new Note(viewModel.getId(), viewModel.getTitle(), viewModel.getText(), notebook);
//
//        return viewModel.modelToNote(notebook);
//    }

    public NotebookViewModel convertToNotebookViewModel(Notebook entity) {
        var viewModel = new NotebookViewModel();
        viewModel.setId(entity.getId().toString());
        viewModel.setName(entity.getName());
        viewModel.setNbNotes(entity.getNotes().size());

        return viewModel;
    }

    public Notebook convertToNotebookEntity(NotebookViewModel viewModel) {
        var entity = new Notebook(viewModel.getId(), viewModel.getName());

        return entity;
    }
}
