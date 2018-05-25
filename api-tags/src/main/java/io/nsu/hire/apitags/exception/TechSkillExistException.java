package io.nsu.hire.apitags.exception;

public class TechSkillExistException extends ElementExistException {

	public TechSkillExistException(String skillName) {
		super("001", "soft.skill.exist.exception.message", null, "soft.skill.exist.exception.description", new String[]{skillName});
	}

}
