package org.smartregister.chw.ge.interactor;

import androidx.annotation.VisibleForTesting;

import org.smartregister.chw.ge.contract.GeRegisterContract;
import org.smartregister.chw.ge.util.GeUtil;
import org.smartregister.chw.ge.util.AppExecutors;

public class BaseGeRegisterInteractor implements GeRegisterContract.Interactor {

    private AppExecutors appExecutors;

    @VisibleForTesting
    BaseGeRegisterInteractor(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
    }

    public BaseGeRegisterInteractor() {
        this(new AppExecutors());
    }

    @Override
    public void saveRegistration(final String jsonString, final GeRegisterContract.InteractorCallBack callBack) {

        Runnable runnable = () -> {
            try {
                GeUtil.saveFormEvent(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }

            appExecutors.mainThread().execute(() -> callBack.onRegistrationSaved());
        };
        appExecutors.diskIO().execute(runnable);
    }
}
