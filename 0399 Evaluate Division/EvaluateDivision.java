class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // builld a map
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> list = equations.get(i);
            graph.putIfAbsent(list.get(0), new HashMap<>());
            graph.putIfAbsent(list.get(1), new HashMap<>());
            graph.get(list.get(0)).put(list.get(1), values[i]);
            graph.get(list.get(1)).put(list.get(0), 1 / values[i]);
        }
        
        // dfs
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<String>(), 1.0);
        }
        return res;
    }
    
     private double dfs(String start, String end, Map<String, Map<String, Double>> graph, 
                        HashSet<String> set, double val) {
         if (!graph.containsKey(start) || set.contains(start)) {
             return -1.0;
         }
         if (start.equals(end)) {
             return val;
         }
         set.add(start);
         Map<String, Double> next = graph.get(start);
         for (String key: next.keySet()) {
             double res = dfs(key, end, graph, set, val * next.get(key));
             if (res != -1.0) {
                 return res;
             }
         }
         return -1.0;
     }
}