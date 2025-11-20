package com.solutions.neetcode.binarysearch.LC981;

import java.util.;

public class TImeBasedKeyValueStore {

    class TimeMap {
        class ValueItem {
            int timeStamp;
            String value;
        }

        HashMap<String, List<ValueItem>> rootMap;

        public TimeMap() {
            rootMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {

            List<ValueItem> list = rootMap.getOrDefault(key, new ArrayList<>());
            rootMap.put(key, list);
            ValueItem item = new ValueItem();
            item.timeStamp = timestamp;
            item.value = value;

            list.add(item);

        }

        public String get(String key, int timestamp) {
            List<ValueItem> list = rootMap.get(key);
            if (list == null || list.isEmpty()) return "";

            int closestUntilNow = 0;
            int lo = 0;
            int hi = list.size() - 1;

            if (timestamp < list.get(0).timeStamp) return "";
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (list.get(mid).timeStamp == timestamp) return list.get(mid).value;
                if (timestamp > list.get(mid).timeStamp) {
                    closestUntilNow = mid;
                    lo = mid+1;
                }
                else hi = mid - 1;
            }

            return list.get(closestUntilNow).value;
        }
    }

/
  Your TimeMap object will be instantiated and called as such:
  TimeMap obj = new TimeMap();
  obj.set(key,value,timestamp);
  String param_2 = obj.get(key,timestamp);
 /

/
  Your TimeMap object will be instantiated and called as such:
  TimeMap obj = new TimeMap();
  obj.set(key,value,timestamp);
  String param_2 = obj.get(key,timestamp);
 /

}
