
public class ConstantIt implements SeqIt {
    private int numLeft, value;
    
    ConstantIt(Constant s) {
        numLeft = s.num; value = s.value;
    }
    
    public boolean hasNext() {
        if(numLeft != 0) return true;
        else return false;
    }
    
    public int next() {
        if(numLeft == 0)
        {
            System.out.println("ConstantIt called past end");
            System.exit(1);
        }
        numLeft--;
        return value;
    }
}
