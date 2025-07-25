package com.AutoSales_Agent.Feedback;

import java.time.LocalDateTime;

import com.AutoSales_Agent.Email.Email;
import com.AutoSales_Agent.Lead.Lead;
import com.AutoSales_Agent.Project.Project;

import lombok.Data;

@Data
public class FeedbackDto {

	private Integer projectId;
	private Integer leadId;
	private Integer emailId;
	private String responseSummary;
	private String responseType; // Enum 문자열 값
	private LocalDateTime createdAt;

	// Entity → Dto (응답용)
	public static FeedbackDto fromEntity(Feedback feedback) {
		FeedbackDto dto = new FeedbackDto();
		dto.setProjectId(feedback.getProject().getId());
		dto.setLeadId(feedback.getLead().getId());
		dto.setEmailId(feedback.getMail().getId());
		dto.setResponseSummary(feedback.getResponseSummary());
		dto.setResponseType(feedback.getResponse_type().name());
		dto.setCreatedAt(feedback.getCreatedAt());
		return dto;
	}

	// Dto → Entity (저장용)
	public static Feedback toEntity(FeedbackDto dto, Project project, Lead lead, Email email) {
		Feedback feedback = new Feedback();
		feedback.setProject(project);
		feedback.setLead(lead);
		feedback.setMail(email);
		feedback.setResponseSummary(dto.getResponseSummary());
		feedback.setResponse_type(Feedback.responseType.valueOf(dto.getResponseType()));
		return feedback;
	}
}
