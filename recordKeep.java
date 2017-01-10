import java.io.*;
import java.util.*;


/**
 * Created by Dewey Milton  on 3/21/2016.
 * RecordKeep controls the state of the score boards, Loads and Saves New Scores
 */
public class recordKeep implements Serializable  {

    List<Record> topScores;

    /*
    Constructor
     */
    public recordKeep(){
        this.topScores = new ArrayList<Record>(10);
    }

    /*
      saveScores
      This method saves the state of recordKeep
     */
    public void saveScores() throws IOException {

        try{
            FileOutputStream file =
                    new FileOutputStream("C:/Users/ASUS/Desktop/JavaClass/Pong/Res/topScores.txt");
                   // new FileOutputStream("C:/topScores.txt");


            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(this);

            out.close();
            file.close();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }


    }

    /*
       loadScores
       loads existing scores
     */
    public recordKeep loadScores(){

        recordKeep tmpRecords = null;
        try{
            FileInputStream fileIn =
                    new FileInputStream("C:/Users/ASUS/Desktop/JavaClass/Pong/Res/topScores.txt");
                  //  new FileInputStream("C:/topScores.txt");

            ObjectInputStream in = new ObjectInputStream(fileIn);

            tmpRecords = (recordKeep) in.readObject();


            in.close();
            fileIn.close();

        }
        catch (Exception e){//Catch exception if any
            System.out.println("Error: " + e.getMessage());
        }



        return tmpRecords;
    }

    /*
      resetScores
      resets the score board with blueprint score board
     */
    public void resetScores(){


        File file = new File("C:/Users/ASUS/Desktop/JavaClass/Pong/Res/newScores.txt");
       // File file = new File("C:/newScores.txt");

        Scanner scan;
        try {
            scan = new Scanner(file);

            while(scan.hasNextLine())
            {
               int index = scan.nextInt();
              //  System.out.println(scan.next());

                String playerName = scan.next();

                int score = scan.nextInt();

                Record record = new Record(playerName, score, index);

                this.topScores.add(record);
            }

            scan.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /*
       checkScore
       Method used to check whether the play has a lower score than whats on the board
     */
    public void checkScore(String name, int score) {
        boolean newScore = false;

        Record newRecord = new Record(name, score, 0);

            int i = 0;

            while(!newScore && i < this.topScores.size()){
                if(this.topScores.get(i).recordCompare(newRecord) > 0){
                    newScore = true;
                    int newIndex = this.topScores.get(i).getIndex() + 1;

                    newRecord.setIndex(this.topScores.get(i).getIndex());
                    this.topScores.get(i).setIndex(newIndex);
                    this.topScores.add(i, newRecord);
                    i++;
                    while(i < this.topScores.size()){
                        this.topScores.get(i).setIndex(newIndex);
                        newIndex++;
                        i++;
                    }
                }
                else
                    i++;
            }
            if(this.topScores.size() > 10){
                    topScores.remove(10);
                }


        try {
            saveScores();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
       getSize
       Returns the size of the score board
     */
    public int getSize(){
        return this.topScores.size();
    }

    /*
      @param int index
      @return Record a score chosen
     */
    public Record getRecord(int index){
        return this.topScores.get(index);
    }

    /*
       removeRecord
       removes a score from the index
       @param int index
     */
    public void removeRecord(int index){
        this.topScores.remove(index);
    }

    /*
       Prints out the scores on the scoreBoard
       @return String result
     */
    public String toString(){
        String result = "";
        for(Record scores: topScores){
            result += scores + "\n";
        }

        return result;
    }

    /*
       indexString
      @return String at index position
     */
    public String indexString(int index){
        return this.topScores.get(index).toString();
    }
}
