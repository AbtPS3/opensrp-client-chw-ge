package org.smartregister.chw.ge.listener;


import android.view.View;

import org.smartregister.chw.ge.R;
import org.smartregister.chw.ge.fragment.BaseGeCallDialogFragment;
import org.smartregister.chw.ge.util.GeUtil;

import timber.log.Timber;

public class BaseGeCallWidgetDialogListener implements View.OnClickListener {

    private BaseGeCallDialogFragment callDialogFragment;

    public BaseGeCallWidgetDialogListener(BaseGeCallDialogFragment dialogFragment) {
        callDialogFragment = dialogFragment;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.ge_call_close) {
            callDialogFragment.dismiss();
        } else if (i == R.id.ge_call_head_phone) {
            try {
                String phoneNumber = (String) v.getTag();
                GeUtil.launchDialer(callDialogFragment.getActivity(), callDialogFragment, phoneNumber);
                callDialogFragment.dismiss();
            } catch (Exception e) {
                Timber.e(e);
            }
        } else if (i == R.id.call_ge_client_phone) {
            try {
                String phoneNumber = (String) v.getTag();
                GeUtil.launchDialer(callDialogFragment.getActivity(), callDialogFragment, phoneNumber);
                callDialogFragment.dismiss();
            } catch (Exception e) {
                Timber.e(e);
            }
        }
    }
}
