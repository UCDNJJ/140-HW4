//Delta sub class of Seq, succesive elements differ by a constant

public class Delta extends Seq {
    
    protected int num, initial, delta;
    
    public Delta(int num, int initial, int delta) {
        if(num == 0) { this.num = 0; this.initial = 0; this.delta = 0; }
        else { this.num = num; this.initial = initial; this.delta = delta; }
    }//constructor
    
    public String toString(){
        return "< " + num + " : " +  initial + " &" + delta + " >";
    }//override toString

    public int min(){
        if(delta >= 0) return initial;
        else return initial + ((num * delta) + 1);
    }//returns min of sequence, else accounts for num*delta going 1 step 
     //to far in sequence when intial is 1 and delta is negative.
    
     public SeqIt createSeqIt() {
         return new DeltaIt(this);
     }
}
