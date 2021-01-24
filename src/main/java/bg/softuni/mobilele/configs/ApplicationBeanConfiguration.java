package bg.softuni.mobilele.configs;

import bg.softuni.mobilele.utils.XmlParser;
import bg.softuni.mobilele.utils.XmlParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public XmlParser xmlParser(){
       return new XmlParserImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
