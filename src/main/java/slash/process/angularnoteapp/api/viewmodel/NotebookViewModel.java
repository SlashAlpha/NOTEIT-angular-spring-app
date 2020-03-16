package slash.process.angularnoteapp.api.viewmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slash.process.angularnoteapp.model.Notebook;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class NotebookViewModel {
    private String id;

    @NotNull
    private String name;

    private int nbNotes;

    public Notebook modelToBook(){
        Notebook notebook=new Notebook(this.id,this.name);
        return notebook;

    }

}
