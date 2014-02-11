
public class Plus {
    public static Seq plus(Constant c1, Constant c2){
        int count = 0, pos = 0, value;
        
        if(c1.num >= c2.num) { count = c2.num; }
        else count = c1.num;
        
        value = c1.value + c2.value;
        
        Constant result = new Constant(count, value);
        
        return result;
            
    }
    
    public static Seq plus(Delta d1, Delta d2) {
        int count = 0, pos = 0, value, delta;
        boolean first = true;
        
        if(d1.num >= d2.num) { count = d2.num; }
        else count = d1.num;
        
        value = d1.initial + d2.initial;
        delta = d1.delta + d2.delta;    
        
        Delta result = new Delta(count, value, delta);
        
        return result;
    }
    
    public static Seq plus(Jumble j1, Jumble j2) {
        int count = 0, pos = 0, value;
        
        if(j1.values.length >= j2.values.length) count = j2.values.length;
        else count = j1.values.length;
        
        int [] values = new int[count];
        
        Jumble result = new Jumble(values);
        
        while(pos != count) {
            value = j1.values[pos] + j2.values[pos];
            result.values[pos] = value;
            pos++;
        }
        
        return result;
    }
}