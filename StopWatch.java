/**
 * Created by Dewey Milton
 * Date 3/21/2016
 * Stop Watch class is created to control the game time and help with scoring
 *
 */


public class StopWatch {
    private int milSec;
    private int sec;
    private int minutes;
    private int hours;
    private boolean start;

    /*
       Constructor for stop watch
     */
    public StopWatch(int milSec, int sec, int minutes, int hours, boolean start){
        this.milSec = milSec;
        this.sec = sec;
        this.minutes = minutes;
        this.hours = hours;
        this.start = start;

    }

    /*
        This keeps the clock going as the update timer goes off.
     */
    public void update(){

        if(this.start) {
            if(milSec < 35){
                milSec++;
            }
            else if(sec < 59) {
                sec++;
                milSec = 0;
            } else if (minutes < 59) {
                minutes++;
                sec = 0;
            } else {
                hours = 1;
                minutes = 0;
                sec = 0;
            }
        }
    }

    /*
        Name: getTime()
      Returns the current time
     */
    public String getTime(){
        String result = "";
        if(hours > 0){
            result += hours + ":";
        }

        if(minutes > 0){
            if(minutes < 10){
                result += "0";
            }
            result += minutes + ":";
        }

        if(sec > 0){
            if(sec < 10){
                result += "0";
            }
            result += sec;
        }

        return result;
    }

    /*
        Name: Score Calc
        Calculates the score for the winning player
     */
    public int scoreCalc()
    {
        int score = 0;

        int integers = this.minutes * 60;
        integers += this.sec;

        score = 7 * integers;

        return score;
    }

    /*
       Name: stop
       Tells the stopwatch to start or stop
     */
    public void stop(boolean stop){
        this.start = false;
    }

    /*
      Name: getSec
      return: seconds
     */
    public int getSec(){
        return this.sec;
    }

    /*
      Name: getMinutes
      Description: get Minutes
      return minutes
     */
    public int getMinutes(){
        return this.minutes;
    }

    /*
      Name: resetTime
      resets time for new game
     */
    public void resetTime(){
        this.sec = 0;
        this.milSec = 0;
        this.minutes = 0;
        this.hours = 0;
    }
}
