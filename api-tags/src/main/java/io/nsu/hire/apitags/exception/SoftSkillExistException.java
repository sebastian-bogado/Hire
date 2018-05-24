package io.nsu.hire.apitags.exception;

public class SoftSkillExistException extends ElementExistException {

	public SoftSkillExistException(String skillName) {
		super("001", "soft.skill.exist.exception.message", null, "soft.skill.exist.exception.description", new String[]{skillName});
	}

}
