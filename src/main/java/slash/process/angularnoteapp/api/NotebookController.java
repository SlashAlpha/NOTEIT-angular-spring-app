package slash.process.angularnoteapp.api;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import slash.process.angularnoteapp.api.viewmodel.NotebookViewModel;
import slash.process.angularnoteapp.dbmanagement.NotebookRepository;
import slash.process.angularnoteapp.model.Notebook;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

/*
Requests can be tested using the built in HTTP Rest Client. Use the
examples found in 'noteit.http' file.
 */

@RestController
@RequestMapping("/api/notebooks")
@CrossOrigin
public class NotebookController {
    private NotebookRepository notebookRepository;
    private Mapper mapper;

    public NotebookController(NotebookRepository notebookRepository, Mapper mapper) {
        this.notebookRepository = notebookRepository;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<Notebook> all() {
        var allCategories = this.notebookRepository.findAll();
        return allCategories;
    }

    @PostMapping
    public Notebook save(@RequestBody NotebookViewModel notebookViewModel,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        var notebookEntity =notebookViewModel.modelToBook();

        // save notebookEntity instance to db
        this.notebookRepository.save(notebookEntity);

        return notebookEntity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.notebookRepository.deleteById(UUID.fromString(id));
    }
}
