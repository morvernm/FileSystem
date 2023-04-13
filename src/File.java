//leaf
package file2809522;

public class File implements Component{
	private String name;
	private int size;
//	to store the parent directory of a File
	private Component parent;
	
	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public int getSize() {
		return size;
	}
	public int getCount() {
//		count of a single file is always 1
		return 1;
	}
//	will be used by Directory to set the parent directory of a file
	public void setParent(Component parent) {
		this.parent = parent;
	}
//	will be used by Directory to return the parent of an individual file
	public Component getParent() {
		return parent;
	}
	public String display(String prefix) {
		return prefix + name + " (" + size + ")\n";
	}

	public Component search(String name) {
//		checking if a file with this name exists 
		boolean match = name.equals(this.name);
//		if this file exists return the parent directory of this file
		if(match == true) {
			return parent;
		}else {
			return null;
			}
	}

}
