/**
 * Created by ASUS on 3/21/2016.
 */
import java.io.Serializable;
import java.util.Iterator;
public class Record implements Serializable  {

    private String name;
    private int score;
    private int index;

    public Record(String _name, int _Score, int _Index){
        this.name = _name;
        this.score = _Score;
        this.index = _Index;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public int getIndex(){
        return this.index;
    }

    public void setIndex(int newIndex){
        this.index = newIndex;
    }

    public int recordCompare(Record newRecord) {
        int recordValue = 0;

        if (this.score > newRecord.getScore()) {
            recordValue = 1;
        } else if (this.score < newRecord.getScore()) {
            recordValue = -1;
        }

        return recordValue;
    }

    public String toString(){
        return this.index + ". " + this.name + " " + this.score + "\n";
    }


}
