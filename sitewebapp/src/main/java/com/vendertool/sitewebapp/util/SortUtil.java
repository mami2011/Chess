package com.vendertool.sitewebapp.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortUtil {

	public static TreeMap<String, String> sortMapByValue(Map<String, String> map) {
		ValueComparator vc = new ValueComparator(map);
		TreeMap<String, String> sorted = new TreeMap<String, String>(vc);
		sorted.putAll(map);
		 
	    return sorted;
	}
	
	static class ValueComparator implements Comparator<String> {

        Map<String, String> base;

        ValueComparator(Map<String, String> base) {
            this.base = base;
        }

        @Override
        public int compare(String a, String b) {
           return base.get(a).compareTo(base.get(b));
        }
    }
	
	
	public static void main(String[] args) {
		
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("one", "Zebra");
        map.put("two", "Apple");
        map.put("three", "Pony");
        
        Map<String, String> sorted = sortMapByValue(map);
        
        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            System.out.println(entry.getValue());
        }
       
    }
	
}
