package org.smartregister.chw.ge.custom_views;

import android.app.Activity;
import android.content.Context;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.view.View;
import android.widget.LinearLayout;

import org.smartregister.chw.ge.R;
import org.smartregister.chw.ge.domain.MemberObject;
import org.smartregister.chw.ge.fragment.BaseGeCallDialogFragment;

public class BaseGeFloatingMenu extends LinearLayout implements View.OnClickListener {
    private MemberObject MEMBER_OBJECT;

    public BaseGeFloatingMenu(Context context, MemberObject MEMBER_OBJECT) {
        super(context);
        initUi();
        this.MEMBER_OBJECT = MEMBER_OBJECT;
    }

    protected void initUi() {
        inflate(getContext(), R.layout.view_ge_floating_menu, this);
        FloatingActionButton fab = findViewById(R.id.ge_fab);
        if (fab != null)
            fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ge_fab) {
            Activity activity = (Activity) getContext();
            BaseGeCallDialogFragment.launchDialog(activity, MEMBER_OBJECT);
        }  else if (view.getId() == R.id.ge_refer_to_facility_layout) {
            Activity activity = (Activity) getContext();
            BaseGeCallDialogFragment.launchDialog(activity, MEMBER_OBJECT);
        }
    }
}