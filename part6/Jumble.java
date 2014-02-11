//Jumble sub class of Seq, no restriction on the elements

public class Jumble extends Seq {
    
    protected int [] values;
    
    public Jumble(int [] values) {
        this.values = new int[values.length];
        System.arraycopy(values, 0, this.values, 0, values.length);
    }//constructor
    
    public String toString() {
        String result = "{ " + values.length + " :";
        for(int x: values)
            result = result + " " + x;
  
        return result + " }";
    }//override toString

    public int min() {
        int min = Integer.MAX_VALUE;
        for(int x: values) {
            if(x < min) min = x;
        }
        if(values.length == 0) return 0;
        else return min;
    }//returns min value in sequence   
    
    public SeqIt createSeqIt() {
        return new JumbleIt(this);
    }
}
