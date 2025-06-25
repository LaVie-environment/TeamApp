package cz.mendelu.config;

import cz.mendelu.dao.RoleRepository;
import cz.mendelu.dao.domain.Role;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void init() {
        List<String> roles = List.of("developer", "designer", "manager");

        for (String roleName : roles) {
            roleRepository.findByName(roleName).orElseGet(() ->
                roleRepository.save(new Role(null, roleName))
            );
        }
    }
}
