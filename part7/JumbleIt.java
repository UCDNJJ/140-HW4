
public class JumbleIt implements SeqIt {
    
    private Jumble itr;
    private int pos, value;
    
    JumbleIt(Jumble j){
        itr = j;
        pos = 0;
    }   
    
    public boolean hasNext() {
        if(pos != itr.values.length) return true;
        else return false;
    }
    
    public int next() throws UsingIteratorPastEndException{
        if(pos == itr.values.length) {
            throw new UsingIteratorPastEndException();
        }
        value = itr.values[pos];
        pos++;
        return value;
    }    
    
}
