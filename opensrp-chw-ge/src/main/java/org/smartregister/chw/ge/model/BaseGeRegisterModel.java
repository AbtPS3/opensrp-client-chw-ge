package org.smartregister.chw.ge.model;

import org.json.JSONObject;
import org.smartregister.chw.ge.contract.GeRegisterContract;
import org.smartregister.chw.ge.util.GeJsonFormUtils;

public class BaseGeRegisterModel implements GeRegisterContract.Model {

    @Override
    public JSONObject getFormAsJson(String formName, String entityId, String currentLocationId) throws Exception {
        JSONObject jsonObject = GeJsonFormUtils.getFormAsJson(formName);
        GeJsonFormUtils.getRegistrationForm(jsonObject, entityId, currentLocationId);

        return jsonObject;
    }

}
