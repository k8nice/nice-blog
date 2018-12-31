package com.nice.filter;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * @author nice
 */
@Configuration
public class WebInterceptorAdapter implements WebMvcConfigurer {
    @Bean
    public WebIntercrptor webIntercrptor(){
        return new WebIntercrptor();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webIntercrptor()).addPathPatterns("/**").excludePathPatterns("/user/login","/user/isExist","/user/register");
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/templates/");
        resourceViewResolver.setSuffix(".html");
        resourceViewResolver.setViewClass(JstlView.class);
        return resourceViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/view").addResourceLocations("/js/*","/css/*");
    }
}
