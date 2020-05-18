package io.github.safouenbez;

public class ArchitectureDecisionRecord {

	private String jiraReference;
	private String problem;
	private String alternatives;
	private String justification;
	private String[] positiveConsequences;
	private String[] negativeConsequences;


	public String getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(String alternatives) {
		this.alternatives = alternatives;
	}


	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}



	public String getJiraReference() {
		return jiraReference;
	}

	public void setJiraReference(String jiraReference) {
		this.jiraReference = jiraReference;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String[] getPositiveConsequences() {
		return positiveConsequences;
	}

	public void setPositiveConsequences(String[] positiveConsequences) {
		this.positiveConsequences = positiveConsequences;
	}

	public String[] getNegativeConsequences() {
		return negativeConsequences;
	}

	public void setNegativeConsequences(String[] negativeConsequences) {
		this.negativeConsequences = negativeConsequences;
	}


	
	

}
