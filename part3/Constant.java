//Constant sub class of Seq, all elements are the same

public class Constant extends Seq {
    
    protected int num, value;
    
    public Constant(int num, int value) {
        if(num == 0){ this.num = 0; this.value = 0; }//if num is 0
        else { this.num = num; this.value = value; }
    }//constructor
    
    public String toString(){
        return "[ " + num + " : " + value + " ]";
    }//override toString

    public int min() {
        return value;
    }//returns min value in sequence
    
    
}
