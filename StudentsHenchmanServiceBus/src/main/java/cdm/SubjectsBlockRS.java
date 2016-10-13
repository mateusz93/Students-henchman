package cdm;

import model.SubjectsBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
public class SubjectsBlockRS {

    private List<SubjectsBlock> subjectsBlocks = new ArrayList<>();

    public List<SubjectsBlock> getSubjectsBlocks() {
        return subjectsBlocks;
    }

    public void setSubjectsBlocks(List<SubjectsBlock> subjectsBlocks) {
        this.subjectsBlocks = subjectsBlocks;
    }

    @Override
    public String toString() {
        return "SubjectsBlockRS{" +
                "subjectsBlocks=" + subjectsBlocks +
                '}';
    }
}
