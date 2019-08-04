class SnapshotArray {

    Map<Integer, Integer> changes;
    List<Map<Integer, Integer>> snaps;
    int snapId;
    
    public SnapshotArray(int length) {
        changes = new HashMap<>();
        snaps = new ArrayList<>();
        snapId = -1;
    }
    
    public void set(int index, int val) {
        changes.put(index, val);
    }
    
    public int snap() {
        snapId++;
        Map<Integer, Integer> map = new HashMap<>();
        map.putAll(changes);
        snaps.add(map);
        return snapId;
    }
    
    public int get(int index, int snap_id) {
        Map<Integer, Integer> map = snaps.get(snap_id);
        return map.getOrDefault(index, 0);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */