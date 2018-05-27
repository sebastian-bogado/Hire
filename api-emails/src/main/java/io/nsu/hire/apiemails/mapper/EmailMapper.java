package io.nsu.hire.apiemails.mapper;

import io.nsu.hire.apiemails.controller.dto.EmailDTO;
import io.nsu.hire.apiemails.model.Email;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

public class EmailMapper implements OrikaMapperFactoryConfigurer {
	@Override
	public void configure(MapperFactory mapperFactory) {
		mapperFactory.classMap(Email.class, EmailDTO.class)
				.field("direcciones", "direcciones")
				.field("direccionesCCO", "direccionesCCO")
				.field("direccionesCC", "direccionesCC")
				.byDefault()
				.register();
	}
}
