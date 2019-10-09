package lv.karoisuzvards.cucumber11.config.site;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/application-${env}.properties")
public class PropertiesSiteConfig implements SiteConfig {

    @Value("${site.url}")
    private String siteUrl;

    @Override
    public String getSiteUrl() {
        return siteUrl;
    }
}
