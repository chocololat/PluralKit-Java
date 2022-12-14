package org.mesa.pkwrapper.managers;

import okhttp3.*;
import org.json.JSONObject;
import org.mesa.pkwrapper.PKClient;
import org.mesa.pkwrapper.PKClientBuilder;
import org.mesa.pkwrapper.enums.SystemPrivacyState;
import org.mesa.pkwrapper.models.PKSystemPrivacy;
import org.mesa.pkwrapper.utils.APIRequest;
import org.mesa.pkwrapper.utils.Constants;

import java.io.IOException;

public class PKSystemPrivacyManager {
    protected final String systemRef;
    JSONObject json;

    public PKSystemPrivacyManager(String systemRef) {
        this.systemRef = systemRef;
        this.json = new JSONObject();
    }

    public PKSystemPrivacyManager setDescriptionPrivacy(SystemPrivacyState state) {
        this.json.put("description_privacy", state.getState());

        return this;
    }

    public PKSystemPrivacyManager setPronounsPrivacy(SystemPrivacyState state) {
        this.json.put("pronoun_privacy", state.getState());

        return this;
    }

    public PKSystemPrivacyManager setMemberListPrivacy(SystemPrivacyState state) {
        this.json.put("member_list_privacy", state.getState());

        return this;
    }

    public PKSystemPrivacyManager setGroupListPrivacy(SystemPrivacyState state) {
        this.json.put("group_list_privacy", state.getState());

        return this;
    }

    public PKSystemPrivacyManager setFrontPrivacy(SystemPrivacyState state) {
        this.json.put("front_privacy", state.getState());

        return this;
    }

    public PKSystemPrivacyManager setFrontHistoryPrivacy(SystemPrivacyState state) {
        this.json.put("front_history_privacy", state.getState());

        return this;
    }

    public PKSystemPrivacy update() throws IOException {
        JSONObject finalJson = new JSONObject();
        finalJson.put("privacy", this.json);

        RequestBody body = RequestBody.create(finalJson.toString(), Constants.JSON);

        JSONObject systemPrivacyObject = APIRequest.patch(Constants.BASE_URL + "/systems/" + systemRef, body);

        return new PKSystemPrivacy(systemPrivacyObject.getJSONObject("privacy"), systemRef);
    }
}
