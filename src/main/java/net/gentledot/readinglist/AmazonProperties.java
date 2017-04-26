package net.gentledot.readinglist;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Sang on 2017-04-26.
 */

@Component
@ConfigurationProperties("amazon") // "amazon" 접두어가 붙은 프로퍼티 주입
public class AmazonProperties {
    private String associateId;

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) { // associateId Setter
        this.associateId = associateId;
    }
}
