
public class ConstantIt implements SeqIt {
    protected int numLeft, value;
    
    ConstantIt(Constant s) {
        numLeft = s.num; value = s.value;
    }
    
    public boolean hasNext() {
        if(numLeft != 0) return true;
        else return false;
    }
    
    public int next() throws UsingIteratorPastEndException{
        if(numLeft == 0)
        {
            throw new UsingIteratorPastEndException();
        }
        numLeft--;
        return value;
    }
}
