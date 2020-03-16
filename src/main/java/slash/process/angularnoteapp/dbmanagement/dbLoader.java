package slash.process.angularnoteapp.dbmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import slash.process.angularnoteapp.model.Note;
import slash.process.angularnoteapp.model.Notebook;

@Component
@ConditionalOnProperty(name = "noteit.db.recreate",havingValue = "true")
public class dbLoader implements CommandLineRunner {
 NoteRepository noteRepository;
 NotebookRepository notebookRepository;

    public dbLoader(NoteRepository noteRepository, NotebookRepository notebookRepository) {
        this.noteRepository = noteRepository;
        this.notebookRepository = notebookRepository ;
    }

    @Override
    public void run(String... args) throws Exception {
        this.notebookRepository.deleteAll();
        this.noteRepository.deleteAll();
        // Save a default notebook
        var defaultNotebook = new Notebook("Default");
        this.notebookRepository.save(defaultNotebook);

        var quotesNotebook = new Notebook("Quotes");
        this.notebookRepository.save(quotesNotebook);

        // Save the welcome note
        var note = new Note("Hello", "Welcome to Note It", defaultNotebook);
        this.noteRepository.save(note);

        // Save a quote note
        var quoteNote = new Note("Latin Quote", "Carpe Diem", quotesNotebook);
        this.noteRepository.save(quoteNote);

        System.out.println("init DB");

    }
}
