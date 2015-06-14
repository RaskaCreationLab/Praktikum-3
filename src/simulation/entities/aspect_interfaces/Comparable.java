package simulation.entities.aspect_interfaces;

public interface Comparable<T extends WithUniqueId> extends java.lang.Comparable<T> {
	
	 default public int compareTo(T o){
		
		long diff=((T)this).id().idNummer() - o.id().idNummer();
		if(diff < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		else if(diff>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		else return diff.intValue();
		
	}
	

}
