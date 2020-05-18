package io.github.safouenbez.service;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import io.github.safouenbez.ArchitectureConcern;
import io.github.safouenbez.ArchitectureDecisionRecord;
import io.github.safouenbez.ArchitectureMetRequirement;
import io.github.safouenbez.ArchitectureRecord;
import io.github.safouenbez.annotations.ADC;
import io.github.safouenbez.annotations.ADL;
import io.github.safouenbez.annotations.ADLRef;
import io.github.safouenbez.annotations.ADM;
import io.github.safouenbez.config.ArchitectureRecordProperties;


@EnableConfigurationProperties(ArchitectureRecordProperties.class)
public class ArchitectureDRService {
	
	@Autowired
    private ArchitectureRecordProperties properties;
	


	public List<ArchitectureRecord> generateAR() {
		
		List<ArchitectureRecord> architectureRecords = new ArrayList<>();



		Reflections reflections = new Reflections(properties.getPackages());

		Set<Class<? extends Object>> allClasses = reflections.getTypesAnnotatedWith(ADL.class);

		for (Class<? extends Object> obj : allClasses) {
			

			ArchitectureRecord architectureRecord = new ArchitectureRecord();

			if (obj.isAnnotationPresent(ADC.class)) {
				Annotation annotation = obj.getAnnotation(ADC.class);
				ADC adc = (ADC) annotation;
				ArchitectureConcern architectureConcern = new ArchitectureConcern();
				architectureConcern.setConcern(adc.concerns());
				architectureConcern.setNfrs(
						Arrays.stream(adc.nfrs()).map(e -> e.toString()).collect(Collectors.toList()));
				architectureConcern.setArchitecture(
						Arrays.stream(adc.architectre()).map(e -> e.toString()).collect(Collectors.toList()));
				architectureRecord.setConcern(architectureConcern);
			}

			if (obj.isAnnotationPresent(ADL.class)) {
				ADL[] adlAnnotations = obj.getAnnotationsByType(ADL.class);
				for (ADL adlAnnotation : adlAnnotations) {
					ArchitectureDecisionRecord aDecisionRecord = new ArchitectureDecisionRecord();
					aDecisionRecord
							.setJiraReference(adlAnnotation.jiraReference().isEmpty() ? "none" : adlAnnotation.jiraReference());
					aDecisionRecord.setProblem(adlAnnotation.problem());
					aDecisionRecord.setAlternatives(adlAnnotation.chosenAlternative());
					aDecisionRecord.setJustification(adlAnnotation.justification());
					aDecisionRecord.setPositiveConsequences(adlAnnotation.positiveConsequences());
					aDecisionRecord.setNegativeConsequences(adlAnnotation.negativeConsequences());
					architectureRecord.setArDecisionRecord(aDecisionRecord);
					architectureRecord.setIdentifier(adlAnnotation.identifier());
					architectureRecord.get_class().add(obj);

				}

			}
			if (obj.isAnnotationPresent(ADM.class)) {
				Annotation annotation = obj.getAnnotation(ADM.class);
				ADM admAnnotation = (ADM) annotation;
				ArchitectureMetRequirement metRequirement = new ArchitectureMetRequirement();
				metRequirement.setStatus(admAnnotation.status());
				metRequirement.setJiraReference(admAnnotation.jiraReference());
				architectureRecord.setArMetRequirement(metRequirement);
				

			}
			
			
			architectureRecords.add(architectureRecord);

		}
		
		for (Class<? extends Object> obj : allClasses) {
			
			if (obj.isAnnotationPresent(ADLRef.class)) {
				Annotation annotation = obj.getAnnotation(ADLRef.class);
				ADLRef adlRefAnnotation = (ADLRef) annotation;
				for (ArchitectureRecord record : architectureRecords) {
					if(record.getIdentifier().equals(adlRefAnnotation.reference()))
					{
						record.get_class().add(obj);
					}
					
				}
			

			}
			
			
		}
		
		return architectureRecords;

	}



}
