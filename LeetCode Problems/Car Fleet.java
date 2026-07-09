class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double time=0.0;
        TreeMap<Integer,Integer> tab=new TreeMap<>(
            Comparator.reverseOrder()
        );
        for(int index=0;index<position.length;index++)
        tab.put(position[index],speed[index]);
        Stack<Double> stk =new Stack<>();
        Set<Integer> dist=tab.keySet();
        for(int d:dist){
            time=(double)(target-d)/tab.get(d);
            if(stk.isEmpty()||time>stk.peek())
            stk.push(time);
        }
        return stk.size();

        }
          }
