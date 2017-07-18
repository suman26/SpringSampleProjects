package com.abhi.design.iterator;

public class CollectionOfNames implements Container {

	public String[] names={"abhi","suman","ravi","shyam"};
	int i;
	@Override
	public Iterator getIterator() {
	
		return new CollectionOfNamesIterate();
	}
	private class CollectionOfNamesIterate implements Iterator{

		@Override
		public boolean hasNext() {
			if(names.length>i)
				return true;
			return false;
		}

		@Override
		public Object next() {
			if(this.hasNext())
				return names[i++];
			
			return null;
		}
		
	}

}
