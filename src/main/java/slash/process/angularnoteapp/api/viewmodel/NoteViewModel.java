package slash.process.angularnoteapp.api.viewmodel;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slash.process.angularnoteapp.model.Note;
import slash.process.angularnoteapp.model.Notebook;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteViewModel {
    private String id;

    @NotNull
    @Min(3)
    private String title;

    @NotNull
    private String text;

    @NotNull
    private String notebookId;

    private Date lastModifiedOn;

    public Note modelToNote(Notebook notebook){
        Note note=new Note(this.id,this.title,this.text,notebook);
        return note;
    }
}