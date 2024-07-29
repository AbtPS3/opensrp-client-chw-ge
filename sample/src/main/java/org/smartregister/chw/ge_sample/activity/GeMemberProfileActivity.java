package org.smartregister.chw.ge_sample.activity;

import android.app.Activity;
import android.content.Intent;

import com.vijay.jsonwizard.activities.JsonFormActivity;
import com.vijay.jsonwizard.utils.FormUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.smartregister.chw.ge.activity.BaseGeProfileActivity;
import org.smartregister.chw.ge.domain.MemberObject;
import org.smartregister.chw.ge.util.Constants;


public class GeMemberProfileActivity extends BaseGeProfileActivity {

    public static void startMe(Activity activity, String baseEntityID) {
        Intent intent = new Intent(activity, GeMemberProfileActivity.class);
        intent.putExtra(Constants.ACTIVITY_PAYLOAD.BASE_ENTITY_ID, baseEntityID);
        activity.startActivityForResult(intent, Constants.REQUEST_CODE_GET_JSON);
    }

    @Override
    public void recordGe(MemberObject memberObject) {
        try {
            JSONObject jsonObject = new FormUtils()
                    .getFormJsonFromRepositoryOrAssets(GeMemberProfileActivity.this, "ge_event_mobilization");
            jsonObject.put("entity_id", memberObject.getBaseEntityId());
            Intent intent = new Intent(this, SampleJsonFormActivity.class);
            intent.putExtra("json", jsonObject.toString());
            startActivityForResult(intent, 700);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected MemberObject getMemberObject(String baseEntityId) {
        return EntryActivity.getSampleMember();
    }
}