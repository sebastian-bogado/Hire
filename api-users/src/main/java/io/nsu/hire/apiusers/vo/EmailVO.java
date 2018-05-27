package io.nsu.hire.apiusers.vo;

import io.nsu.hire.apiusers.model.ProcessEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class EmailVO {
	private Object data;
	private ProcessEnum processName;
	private List<String> direcciones;
	private List<String> direccionesCC;
	private List<String> direccionesCCO;
	private String emailTemplate;
}
