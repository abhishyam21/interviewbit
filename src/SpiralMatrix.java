public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> li = new ArrayList<Integer>();
        int t=0, b=A.size()-1, l=0, r=A.get(0).size()-1;
        int dir = 0;
        while(t<=b && l<=r){
            if(dir == 0){
                for(int i=l; i<=r; i++){
                    li.add(A.get(t).get(i));
                    
                }
                t++;
                dir =1;
            }else if(dir==1){
                for(int i = t; i<=b; i++){
                    li.add(A.get(i).get(r));
                    
                }
                r--;
                dir = 2;
            }else if(dir==2){
                for(int i=r; i>=l; i--){
                    li.add(A.get(b).get(i));
                    
                    
                }
                b--;
                dir=3;
            }else if(dir == 3){
                for(int i=b; i>=t; i--){
                    li.add(A.get(i).get(l));
                    
                    
                }
                l++;
                dir=0;
            }
        }
        return li;
    }
}
