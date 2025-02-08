// Problem Name: Design a Number Container System
// Problem Link: https://leetcode.com/problems/design-a-number-container-system/

class NumberContainers {

    private Map<Integer, TreeSet<Integer>> mp2;
    private Map<Integer, Integer> mp1;
    public NumberContainers() {
        mp1 = new HashMap<>();
        mp2 = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(mp1.containsKey(index)) {
            int prevNumber = mp1.get(index);
            mp2.get(prevNumber).remove(index);
            if(mp2.get(prevNumber).isEmpty()) {
                mp2.remove(prevNumber);
            }
        }
        mp1.put(index, number);
        mp2.putIfAbsent(number, new TreeSet<>());
        mp2.get(number).add(index);
    }
    
    public int find(int number) {
        if(mp2.containsKey(number)) {
            return mp2.get(number).first();
        }
        return -1;
    }
}
