package org.smartregister.chw.ge.interactor;

import androidx.annotation.VisibleForTesting;

import org.smartregister.chw.ge.GeLibrary;
import org.smartregister.chw.ge.contract.GeProfileContract;
import org.smartregister.chw.ge.domain.MemberObject;
import org.smartregister.chw.ge.domain.Visit;
import org.smartregister.chw.ge.util.AppExecutors;
import org.smartregister.chw.ge.util.Constants;
import org.smartregister.chw.ge.util.GeUtil;

public class BaseGeProfileInteractor implements GeProfileContract.Interactor {
    protected AppExecutors appExecutors;

    @VisibleForTesting
    BaseGeProfileInteractor(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
    }

    public BaseGeProfileInteractor() {
        this(new AppExecutors());
    }

    @Override
    public void refreshProfileInfo(MemberObject memberObject, GeProfileContract.InteractorCallBack callback) {
        Runnable runnable = () -> appExecutors.mainThread().execute(() -> {
            callback.refreshMedicalHistory(getVisit(Constants.EVENT_TYPE.GE_FOLLOW_UP_VISIT, memberObject) != null);
        });
        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void saveRegistration(final String jsonString, final GeProfileContract.InteractorCallBack callback) {

        Runnable runnable = () -> {
            try {
                GeUtil.saveFormEvent(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
        appExecutors.diskIO().execute(runnable);
    }

    private Visit getVisit(String eventType, MemberObject memberObject) {
        try {
            return GeLibrary.getInstance().visitRepository().getLatestVisit(memberObject.getBaseEntityId(), eventType);
        } catch (Exception e) {
            return null;
        }
    }
}
