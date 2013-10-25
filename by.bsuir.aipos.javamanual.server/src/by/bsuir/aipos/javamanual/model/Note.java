/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.aipos.javamanual.model;

import java.io.Serializable;

public class Note implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String content;
	
	public Note(){
		name = null;
        content = null;
	}
	
	public Note(String name, String content)
	{
		this.name = name;
                this.content = content;
	}
	
	public String getName(){
            return name;
        }
        
        public String getContent(){
            return content;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setContent(String content){
            this.content = content;
        }

}