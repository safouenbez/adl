package io.github.safouenbez;

import java.util.ArrayList;
import java.util.List;

public class ArchitectureRecord {
	
	private String identifier ; 
	private ArchitectureConcern concern ; 
	private ArchitectureDecisionRecord arDecisionRecord ;
	private ArchitectureMetRequirement arMetRequirement ;
	private List<Class<?>> _class = new ArrayList<Class<?>>(); 
	
	public ArchitectureConcern getConcern() {
		return concern;
	}
	public void setConcern(ArchitectureConcern concern) {
		this.concern = concern;
	}
	public ArchitectureDecisionRecord getArDecisionRecord() {
		return arDecisionRecord;
	}
	public void setArDecisionRecord(ArchitectureDecisionRecord arDecisionRecord) {
		this.arDecisionRecord = arDecisionRecord;
	}
	public ArchitectureMetRequirement getArMetRequirement() {
		return arMetRequirement;
	}
	public void setArMetRequirement(ArchitectureMetRequirement arMetRequirement) {
		this.arMetRequirement = arMetRequirement;
	}
	public List<Class<?>> get_class() {
		return _class;
	}
	public void set_class(List<Class<?>> _class) {
		this._class = _class;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String string) {
		this.identifier = string;
	}

	
	
	

}
