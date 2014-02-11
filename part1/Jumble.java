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
}
