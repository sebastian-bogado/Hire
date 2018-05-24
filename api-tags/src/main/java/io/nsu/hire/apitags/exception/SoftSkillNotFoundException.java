package io.nsu.hire.apitags.exception;

public class SoftSkillNotFoundException extends NotFoundException {

	public SoftSkillNotFoundException(String softSkillIdentifier) {
		super("001", "soft.skill.notfound.exception.message", null, "soft.skill.notfound.exception.description", new String[]{softSkillIdentifier});
	}

}
