package io.nsu.hire.apiclients.exception;

public class ClientUserPetitionNotFoundException extends NotFoundException {

	//TODO change message
	public ClientUserPetitionNotFoundException(String softSkillIdentifier) {
		super(001,"soft.skill.notfound.exception.message", null, "soft.skill.notfound.exception.description", new String[]{softSkillIdentifier});
	}

}
