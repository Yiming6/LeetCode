class Solution {
    /*
        Topological sorting. Note that this is still valid even cycle appears because every
        ticket can be used only once. So we don't need visited array.
        O(E + V)
    */
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets.size() == 0 || tickets.get(0).size() == 0) return new ArrayList<>();
        
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!graph.containsKey(ticket.get(0))) graph.put(ticket.get(0), new PriorityQueue<>());
            
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        
        List<String> ans = new ArrayList<>();

        dfs(graph, "JFK", ans);
        
        Collections.reverse(ans);
        
        return ans;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> graph, String curr, List<String> list) {
        PriorityQueue<String> dests = graph.get(curr);
        
        while (dests != null && dests.size() > 0) {
            String dest = dests.poll();
            dfs(graph, dest, list);
        }
        
        list.add(curr);
    }
}