package com.vladraresraducu.nordigenjavaapi.token;

import com.vladraresraducu.nordigenjavaapi.token.model.SpectacularJWTObtain;
import org.springframework.stereotype.Component;

@Component
public class TokenContext {
    private SpectacularJWTObtain spectacularJWTObtain;

    public String getAccessToken() {
        return spectacularJWTObtain.getAccess();
    }

    public String getRefreshToken() {
        return spectacularJWTObtain.getRefresh();
    }

    public void setSpectacularJWTObtain(SpectacularJWTObtain spectacularJWTObtain) {
        this.spectacularJWTObtain = spectacularJWTObtain;
    }

    public boolean isTokenPresent() {
        return spectacularJWTObtain != null;
    }
}
