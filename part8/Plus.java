public class Plus {  
    public static Seq plus(Seq s1, Seq s2) {
        int count = 0, pos = 0, prev = 0, value = 0, delta = 0, initial = 0;
        boolean first = true, firstDelta = true, isConstant = true, isDelta = true;
               
        SeqIt itr1 = s1.createSeqIt();
        SeqIt itr2 = s2.createSeqIt();
        
        while(itr1.hasNext() && itr2.hasNext()) {
            try {
                if(first) { 
                    prev = itr1.next() + itr2.next();
                    count++; initial = prev; first = false; 
                }
                else {
                    value = itr1.next() + itr2.next();                 
                    //Check to see if can use constant as return
                    if(value == prev && isConstant) {
                        isConstant =  true;
                    }
                    else if(value != prev && isConstant) {
                        isConstant = false;
                    }    
                    
                    //Check to see if can use delta as return
                    if(firstDelta) {
                        delta = value - prev;  
                        firstDelta = false;
                    }
                    
                    if(delta == value - prev && isDelta) {
                        isDelta = true;
                    }              
                    else {
                        isDelta = false;
                    }
                    count++; prev = value;
                }                         
              } 
              catch(UsingIteratorPastEndException e) {
                  break;
              }
        }
        
        if(isConstant)
        {
            if(count == 1)
                return new Constant(count, initial);
            else
                return new Constant(count, value);
        }//Constant returned
        else if(isDelta)
        {
            return new Delta(count, initial, delta);
        }//Delta returned
        else
        {       
            Jumble result = new Jumble(new int[count]);
            
            itr1 = s1.createSeqIt(); itr2 = s2.createSeqIt();
            
            while(pos != count) {
                try{
                    result.values[pos] = itr1.next() + itr2.next();
                    pos++;
                } catch(UsingIteratorPastEndException e) {
                        break;
                  }
            }
            return result;
        }//Jumble returned            
    }
   
    
    
/*    public static Seq plus(Constant c1, Constant c2){
        int count = 0, pos = 0, value;
        
        if(c1.num >= c2.num) { count = c2.num; }
        else count = c1.num;
        
        value = c1.value + c2.value;
        
        Constant result = new Constant(count, value);
        
        return result;
        
    }
    
    public static Seq plus(Delta d1, Delta d2) {
        int count = 0, pos = 0, value, delta;
        
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
    
    public static Seq plus(Constant c, Delta d) {
        int count = 0, pos = 0, value;
        
        if(c.num >= d.num) count = d.num;
        else count = c.num;
        
        value = c.value + d.initial;
        
        Delta result = new Delta(count, value, d.delta);
        
        return result;
        
    }
    
    public static Seq plus(Delta d, Constant c) {
        int count = 0, pos = 0, value;
        
        if(c.num >= d.num) count = d.num;
        else count = c.num;
        
        value = c.value + d.initial;
        
        Delta result = new Delta(count, value, d.delta);
        
        return result;
        
    }
    
    public static Seq plus(Constant c, Jumble j) {
        int count = 0, pos = 0, value;
        
        if(c.num >= j.values.length) count = j.values.length;
        else count = c.num;
        
        int [] values = new int[count];
        
        Jumble result = new Jumble(values);
        
        while(pos != count) {
            value = c.value + j.values[pos];
            result.values[pos] = value;
            pos++;
        }
        
        return result;
    }
    
    public static Seq plus(Jumble j, Constant c) {
        int count = 0, pos = 0, value;
        
        if(c.num >= j.values.length) count = j.values.length;
        else count = c.num;
        
        int [] values = new int[count];
        
        Jumble result = new Jumble(values);
        
        while(pos != count) {
            value = c.value + j.values[pos];
            result.values[pos] = value;
            pos++;
        }
        
        return result;
    }
    
    public static Seq plus(Delta d, Jumble j) {
        int count = 0, pos = 0, value, delta;
        
        if(d.num >= j.values.length) count = j.values.length;
        else count = d.num;
        
        int [] values = new int[count];
        
        Jumble result = new Jumble(values);
        
        SeqIt itr = d.createSeqIt();
        
        while(pos != count) {
            try{
              value = itr.next() + j.values[pos];
              result.values[pos] = value;
              pos++;
            }
            catch(UsingIteratorPastEndException e) {
                break;
            }
        }
        
        return result;
    }
    
    public static Seq plus(Jumble j, Delta d) {
        int count = 0, pos = 0, value, delta;
        
        if(d.num >= j.values.length) count = j.values.length;
        else count = d.num;
        
        int [] values = new int[count];
        
        Jumble result = new Jumble(values);
        
        SeqIt itr = d.createSeqIt();
        
        while(pos != count) {
            try{
              value = itr.next() + j.values[pos];
              result.values[pos] = value;
              pos++;
            }
            catch(UsingIteratorPastEndException e) {
                break;
            }
        }
        
        return result;
    }*/
}