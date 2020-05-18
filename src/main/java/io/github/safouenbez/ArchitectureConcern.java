package io.github.safouenbez;

import java.util.List;

public class ArchitectureConcern {

	private String concern;
	private List<String> nfrs;
	private List<String> architecture;

	public String getConcern() {
		return concern;
	}

	public void setConcern(String concern) {
		this.concern = concern;
	}

	public List<String> getNfrs() {
		return nfrs;
	}

	public void setNfrs(List<String> nfrs) {
		this.nfrs = nfrs;
	}


	public List<String> getArchitecture() {
		return architecture;
	}

	public void setArchitecture(List<String> architecture) {
		this.architecture = architecture;
	}



}
