package org.smartregister.chw.ge.contract;

import android.content.Context;

public interface BaseGeCallDialogContract {

    interface View {
        void setPendingCallRequest(Dialer dialer);
        Context getCurrentContext();
    }

    interface Dialer {
        void callMe();
    }
}
