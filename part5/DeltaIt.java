
public class DeltaIt implements SeqIt {
    private int num, initial, delta, currValue;
    
    DeltaIt(Delta d){
        num = d.num; initial = d.initial; delta = d.delta;
    }
    
    public boolean hasNext() {
        if(num != 0) return true;
        else return false;
    }
    
    public int next() throws UsingIteratorPastEndException{
        if(num == 0)
        {
           throw new UsingIteratorPastEndException();
        }
        num--;
        currValue = initial; //correct value to return
        initial = initial + delta; //update to new value based on delta
        return currValue;
    }    
    
}
