package by.bsuir.ppvis.general.model;

import java.io.Serializable;

public class Note implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String studentFIO;
	private String parentsFIO;
	private String workingAddress;
	private String parentsPost;
	private int parentsExperience;
	
	public Note(){
		studentFIO = null;
		parentsFIO = null;
		workingAddress = null;
		parentsPost = null;
		parentsExperience = 0;
	}
	
	public Note(String studentFIO, String parentsFIO, String workingAddress, 
			String parentsPost, int parentsExperience)
	{
		this.studentFIO = studentFIO;
		this.parentsFIO = parentsFIO;
		this.workingAddress = workingAddress;
		this.parentsPost = parentsPost;
		this.parentsExperience = parentsExperience;
	}
	
	public String getStudentFIO() {
		return studentFIO;
	}

	public void setStudentFIO(String studentFIO) {
		this.studentFIO = studentFIO;
	}

	public String getParentsFIO() {
		return parentsFIO;
	}

	public void setParentsFIO(String parentsFIO) {
		this.parentsFIO = parentsFIO;
	}

	public String getWorkingAddress() {
		return workingAddress;
	}

	public void setWorkingAddress(String workingAddress) {
		this.workingAddress = workingAddress;
	}

	public String getParentsPost() {
		return parentsPost;
	}

	public void setParentsPost(String parentsPost) {
		this.parentsPost = parentsPost;
	}

	public int getParentsExperience() {
		return parentsExperience;
	}

	public void setParentsExperience(int parentsExperience) {
		this.parentsExperience = parentsExperience;
	}

}