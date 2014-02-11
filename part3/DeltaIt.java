
public class DeltaIt implements SeqIt {
    private int num, initial, delta, currValue;
    DeltaIt(Delta d){
        num = d.num; initial = d.initial; delta = d.delta;
    }
    
    public boolean hasNext() {
        if(num != 0) return true;
        else return false;
    }
    
    public int next() {
        if(num == 0)
        {
            System.out.println("DeltaIt called past end");
            System.exit(1);
        }
        num--;
        currValue = initial; //correct value to return
        initial = initial + delta; //update to new value based on delta
        return currValue;
    }    
    
}
