package cz.mendelu.config;

import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Import({EshopConfig.class})
public class WebConfig implements WebMvcConfigurer {
}
