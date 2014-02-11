
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
    
    public int next() {
        if(pos == itr.values.length) {
            System.out.println("JumbleIt called past end");
            System.exit(1);
        }
        value = itr.values[pos];
        pos++;
        return value;
    }    
    
}
