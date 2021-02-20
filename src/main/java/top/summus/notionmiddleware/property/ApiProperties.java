package top.summus.notionmiddleware.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:api.properties", encoding = "UTF-8")
public class ApiProperties {
    @Value("${moji.sessionToken}")
    private String mojiSessionToken;

    @Value("${moji.applicationId}")
    private String mojiApplicationId;

    @Value("${moji.installationId}")
    private String mojiInstallationId;

    @Value("${moji.clientVersion}")
    private String clientVersion;

    @Value("${notion.token}")
    private String notionToken;
}
