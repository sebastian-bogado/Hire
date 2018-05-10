package io.nsu.hire.apiusers.controller.mapper;

import io.nsu.hire.apiusers.controller.dto.CreateAdminUserRequest;
import io.nsu.hire.apiusers.model.User;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements OrikaMapperFactoryConfigurer {
	@Override
	public void configure(MapperFactory mapperFactory) {
		configureUserWithCreateClientUserRequest(mapperFactory);
	}

	private void configureUserWithCreateClientUserRequest(MapperFactory mapperFactory) {
		mapperFactory.classMap(User.class, CreateAdminUserRequest.class)
				.byDefault()
				.register();
	}
}