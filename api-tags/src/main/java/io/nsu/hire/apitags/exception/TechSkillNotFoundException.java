package io.nsu.hire.apitags.exception;

public class TechSkillNotFoundException extends NotFoundException {

	public TechSkillNotFoundException(String techSkillIdentifier) {
		super("001", "soft.skill.notfound.exception.message", null, "soft.skill.notfound.exception.description", new String[]{techSkillIdentifier});
	}

}