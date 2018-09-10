package main.java.entities.contentCloud.blocks.multimedia;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import main.java.entities.contentCloud.File;
import main.java.entities.contentCloud.blocks.ReusableBlock;

import java.util.ArrayList;

public class MultimediaBlock extends ReusableBlock {
    public ArrayList<String> files;

    @JsonSetter("files")
    public void setFiles(ArrayList<File> files){
        for (File file: files){
            this.files.add(file.id);
        }
    }

    @JsonGetter("files")
    public ArrayList<String> getFiles(){
        return files;
    }

}
