//composite 
package file2809522;

import java.util.ArrayList;

public class Directory implements Component{
	private String name;
//	to store the files/directories within the current directory
	private ArrayList<Component> children;

//	setting name and creating the list;
	public Directory(String name) {
		this.name = name;
		children = new ArrayList<Component>();
	}
	public void add(Component c) {
//		if the Component added is an individual File
		if(c instanceof File a) {
//			check if the file has a parent already
//			if the file doesn't have a parent i.e. hasn't yet been added to a directory
			if(a.getParent() == null) {
//				set the file's parent directory to be this directory
				a.setParent(this);
			}
		}
//		add the file/directory to the list
		children.add(c);
	}
	public void remove(Component c) {
		children.remove(c);
	}
	public String getName() {
		return name;
	}
	public int getSize() {
//		setting the directory size to 0 initially - will always be 0 unless File is added
		int size = 0;
//		get the size of each element in the children array
		for(Component a: children) {
//			add the child's size to the directory's size - only for files
			size += a.getSize();
		}
		return size;
	}
	public int getCount() {
//		setting the directory's count to 0 initially - will always be 0 unless a File is added
		int count = 0;
//		iterate through each child in directory
		for(Component a: children) {
//			call getCount method for file or directory. 
			count += a.getCount();
		}
		return count;
	}
	public String display(String prefix) {	
//		root directory output
		String display = getName() + ": " + "(count=" + getCount() + ", size=" + getSize() + ")" + "\n";
//		traverse through each child in the directory
		for(Component a: children) {
//			if the child is a File
			if(a instanceof File) {
				display += a.display(prefix);
			}else if(a instanceof Directory) {
//				if the child is another directory, format output with prefix first then call display() 
				display += prefix + a.display(prefix + prefix); 
			}
	}		return display;
	}
//	searching for a file whose name matches the inputed name 
	public Component search(String name) {
//		initialising match to null
		Component match = null;
		for(Component a: children) {
//			calling search method of each element in children to check if the file exists
				match = a.search(name);
//				if the File.display() method returns a Component (not null), then the file exists
				if(match!= null) {
//					as the file has been found, stop traversing arrayList to end the search.
					break;
				}
			}
//		will always return null for directories 
		return match;
	}
}