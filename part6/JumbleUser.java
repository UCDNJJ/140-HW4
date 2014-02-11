
public class JumbleUser {
    
    public static int lengthLongestNDCSS1(Jumble j) {
        JumbleIt jumble = new JumbleIt(j);
        int length = 0, prev = 0, curr = 0, max = 0;
        boolean first = true;
        
        if(jumble.hasNext() == false)
            return 0;
        
        while(jumble.hasNext()) {
            try{
                if(first) { 
                    prev = jumble.next(); length++; first = false;
                }
                else if(prev <= (curr = jumble.next())){
                    prev = curr; length++;
                } 
                else { 
                    if(length > max)
                        max = length;
                
                    length = 1; prev = curr; 
                }
            }
            catch(UsingIteratorPastEndException e) {
                
            }
        }
        
        if(length > max) //special case when NDCSS is length of array
            max = length;
        
        return max;
    }
    
    public static int lengthLongestNDCSS2(Jumble j) {
        JumbleIt jumble = new JumbleIt(j);
        int length = 0, prev = 0, curr = 0, max = 0;
        boolean first = true;
        
        if(jumble.hasNext() == false)
            return 0;
        
        while(true) {

            try{
                if(first) { 
                    prev = jumble.next(); length++; first = false;
                }
                else if(prev <= (curr = jumble.next())){
                    prev = curr; length++;
                } 
                else { 
                    if(length > max)
                        max = length;
                
                    length = 1; prev = curr; 
                }
            }
            catch(UsingIteratorPastEndException e) {
                break;
            }
        }
        
        if(length > max) //special case when NDCSS is length of array
            max = length;
        
        return max;
    }
    
}
