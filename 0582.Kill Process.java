class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (pid.size() == 0 || ppid.size() == 0 || pid.size() != ppid.size()) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < pid.size(); i++) {
            if (!map.containsKey(pid.get(i))) map.put(pid.get(i), new ArrayList<>());
            
            if (ppid.get(i) == 0) continue;
            
            if (!map.containsKey(ppid.get(i))) map.put(ppid.get(i), new ArrayList<>());
            
            map.get(ppid.get(i)).add(pid.get(i));
        }
        
        queue.add(kill);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ans.add(curr);
            
            for (int child : map.get(curr)) queue.add(child);
        }
        
        return ans;
    }
}